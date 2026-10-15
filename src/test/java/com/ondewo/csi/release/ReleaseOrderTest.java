package com.ondewo.csi.release;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * The release contract shared by every ondewo-csi-client SDK: {@code make release} proves
 * everything read-only first, then builds and tests, commits locally, publishes to Maven Central
 * and waits until it is SERVED, and only then pushes, branches, tags and creates the GitHub
 * release; {@code make ondewo_release} deletes its ondewo-devops-accounts clone before
 * {@code $(MAKE) release} starts, and on every failure.
 */
class ReleaseOrderTest {

    private static final String[] SECRET_NAMES = {
        "GITHUB_GH_TOKEN",
        "MAVEN_CENTRAL_USERNAME",
        "MAVEN_CENTRAL_PASSWORD",
        "MAVEN_GPG_KEY_B64",
        "MAVEN_GPG_PASSPHRASE",
        "DEVOPS_ACCOUNT_DIR"
    };

    private static List<String> makefile;

    @BeforeAll
    static void read() throws IOException {
        makefile = Files.readAllLines(Paths.get("Makefile"), StandardCharsets.UTF_8);
    }

    /** The target's header line. */
    private static String header(final String target) {
        return makefile.stream()
                .filter(line -> line.startsWith(target + ":"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("no target " + target));
    }

    /**
     * The recipe lines of a target, trimmed, without the comment lines between them. A recipe
     * ends at the first blank line.
     */
    private static List<String> recipe(final String target) {
        final int start = makefile.indexOf(header(target));
        final List<String> lines = new ArrayList<>();
        for (int i = start + 1; i < makefile.size() && !makefile.get(i).isEmpty(); i++) {
            if (makefile.get(i).startsWith("\t")) {
                lines.add(makefile.get(i).trim());
            }
        }
        return lines;
    }

    private static int indexOf(final List<String> lines, final String step) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).equals(step) || lines.get(i).startsWith(step + " ")) {
                return i;
            }
        }
        throw new AssertionError("'" + step + "' is not a step of " + lines);
    }

    @Test
    void releaseRunsItsStepsInTheContractOrder() {
        final List<String> release = recipe("release");
        final List<String> order =
                Arrays.asList(
                        "make release_preflight",
                        "make build",
                        "make test_via_docker",
                        "make dry_run_maven_central_via_docker",
                        "git diff --cached --quiet || git commit --no-verify",
                        "make push_to_maven_central_via_docker",
                        "make verify_maven_central_serves_version",
                        "git push",
                        "make create_release_branch",
                        "make create_release_tag",
                        "make release_to_github_via_docker_image",
                        "make release_verify");

        int previous = -1;
        for (final String step : order) {
            final int index = indexOf(release, step);
            assertTrue(index > previous, "'" + step + "' runs too early in " + release);
            previous = index;
        }
    }

    @Test
    void thePreflightIsTheFirstStepAndNothingButThePreCommitRunMayFailSilently() {
        final List<String> steps =
                recipe("release").stream()
                        .filter(line -> !line.startsWith("@echo"))
                        .collect(Collectors.toList());
        assertEquals("make release_preflight", steps.get(0));
        assertEquals(
                List.of("-make precommit_hooks_run_all_files"),
                steps.stream().filter(line -> line.startsWith("-")).collect(Collectors.toList()),
                "a '-' step swallows its failure, e.g. a failed commit before the tag");
    }

    @Test
    void thePreflightProvesCredentialsVersionAndNotesReadOnly() {
        final List<String> preflight = recipe("release_preflight");
        for (final String check :
                new String[] {
                    "make check_release_host_tools",
                    "make check_no_devops_clone_in_workspace",
                    "make check_release_credentials",
                    "make validate_release_credentials_via_docker_image",
                    "make check_release_notes",
                    "make check_version_unreleased",
                    "make check_branch_up_to_date"
                }) {
            assertTrue(
                    preflight.stream().anyMatch(line -> line.equals(check) || line.endsWith(" " + check)),
                    check + " is not part of release_preflight");
        }
        assertTrue(
                String.join("\n", recipe("check_version_unreleased"))
                        .contains("git ls-remote --exit-code origin \"refs/tags/${ONDEWO_CSI_VERSION}\""),
                "the origin check is not an exact ref lookup");
    }

    @Test
    void theVerificationChecksTagReleaseNotesAndMavenCentral() {
        assertEquals(
                List.of(
                        "make check_tag_on_origin",
                        "make verify_maven_central_serves_version",
                        "make verify_github_release_via_docker_image"),
                recipe("release_verify").stream()
                        .filter(line -> line.contains("make "))
                        .map(line -> line.substring(line.indexOf("make ")))
                        .collect(Collectors.toList()));
    }

    @Test
    void ondewoReleaseChecksThenLoadsTheCredentialsThenReleases() {
        assertTrue(
                header("ondewo_release").startsWith("ondewo_release: update_pom_version spc run_release_with_devops "),
                header("ondewo_release"));

        final List<String> script = recipe("run_release_with_devops");
        final int trap = indexOf(script, "trap 'rm -rf \"$$accounts\"' EXIT; \\");
        final int clone = indexOf(script, "git clone -q --depth 1");
        final int load = indexOf(script, "eval \"$$(grep -hE '^GITHUB_GH_TOKEN='");
        final int delete = indexOf(script, "if [ -n \"$$own_clone\" ]; then rm -rf \"$$accounts\"; fi; \\");
        final int release = indexOf(script, "$(MAKE) release");

        assertTrue(trap < clone, "the clone is not removed when the release fails");
        assertTrue(clone < load && load < delete, "the clone is deleted before it is read");
        assertTrue(delete < release, "the clone still exists while `make release` runs");
        assertEquals(script.size() - 1, release, "`$(MAKE) release` is not the last step");
    }

    // ---------------------------------------------------------------------------------------
    // Behaviour: run_release_with_devops against a local fixture repository, with a stand-in
    // for `$(MAKE)` that records what `make release` would have seen and then fails.
    // ---------------------------------------------------------------------------------------

    private static boolean onPath(final String tool) {
        return Arrays.stream(System.getenv().getOrDefault("PATH", "").split(File.pathSeparator))
                .anyMatch(dir -> Files.isExecutable(Paths.get(dir, tool)));
    }

    private static void run(final Path dir, final String... command) throws Exception {
        final Process process =
                new ProcessBuilder(command).directory(dir.toFile()).redirectErrorStream(true).start();
        final String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        assertTrue(process.waitFor(60, TimeUnit.SECONDS), "timed out: " + String.join(" ", command));
        assertEquals(0, process.exitValue(), String.join(" ", command) + "\n" + output);
    }

    private static void writeAccounts(final Path dir, final boolean withMavenCentral) throws IOException {
        Files.createDirectories(dir);
        Files.write(
                dir.resolve("account_github.env"),
                List.of("# GITHUB_GH_TOKEN=commented-out", "GITHUB_GH_TOKEN=fake-gh-token"),
                StandardCharsets.UTF_8);
        if (withMavenCentral) {
            Files.write(
                    dir.resolve("account_maven_central.env"),
                    List.of(
                            "# MAVEN_GPG_KEY_B64 is base64 of the armoured key",
                            "MAVEN_CENTRAL_USERNAME=fake-user",
                            "MAVEN_CENTRAL_PASSWORD=fake-password",
                            "MAVEN_GPG_KEY_B64=ZmFrZQ==",
                            "MAVEN_GPG_PASSPHRASE=fake-passphrase"),
                    StandardCharsets.UTF_8);
        }
    }

    private static Path fixtureRepository(final Path root, final boolean withMavenCentral) throws Exception {
        final Path repository = root.resolve("accounts-origin");
        writeAccounts(repository, withMavenCentral);
        run(repository, "git", "-c", "init.defaultBranch=master", "init", "-q");
        run(repository, "git", "add", ".");
        run(
                repository,
                "git",
                "-c",
                "user.name=release-test",
                "-c",
                "user.email=release-test@ondewo.invalid",
                "commit",
                "-q",
                "-m",
                "fixture");
        return repository;
    }

    /** Runs the target; returns its exit code. The stand-in make writes {@code report}. */
    private static int runReleaseWithDevops(
            final Path root, final Path origin, final Path clone, final Path accountsDir)
            throws Exception {
        final Path fakeMake = root.resolve("fake-make.sh");
        Files.write(
                fakeMake,
                List.of(
                        "#!/bin/sh",
                        "{",
                        "  if [ -e \"$CLONE\" ]; then echo clone-present; else echo clone-absent; fi",
                        "  [ \"$GITHUB_GH_TOKEN\" = fake-gh-token ] && echo gh-token-loaded",
                        "  [ \"$MAVEN_CENTRAL_PASSWORD\" = fake-password ] && echo central-loaded",
                        "  [ \"$MAVEN_GPG_PASSPHRASE\" = fake-passphrase ] && echo gpg-loaded",
                        "  echo \"args=$*\"",
                        "} > \"$REPORT\"",
                        "exit 3"),
                StandardCharsets.UTF_8);
        assertTrue(fakeMake.toFile().setExecutable(true));

        final ProcessBuilder builder =
                new ProcessBuilder(
                                "make",
                                "--no-print-directory",
                                "run_release_with_devops",
                                "DEVOPS_ACCOUNT_GIT_URL=" + origin,
                                "DEVOPS_ACCOUNT_CLONE_DIR=" + clone,
                                "MAKE=" + fakeMake)
                        .redirectErrorStream(true);
        final Map<String, String> environment = builder.environment();
        for (final String name : SECRET_NAMES) {
            environment.remove(name);
        }
        // A parent make's flags (e.g. -n) must not leak into this run.
        environment.remove("MAKEFLAGS");
        environment.remove("MFLAGS");
        environment.remove("MAKELEVEL");
        if (accountsDir != null) {
            environment.put("DEVOPS_ACCOUNT_DIR", accountsDir.toString());
        }
        environment.put("CLONE", clone.toString());
        environment.put("REPORT", root.resolve("report.txt").toString());
        final Process process = builder.start();
        process.getInputStream().readAllBytes();
        assertTrue(process.waitFor(60, TimeUnit.SECONDS), "run_release_with_devops timed out");
        return process.exitValue();
    }

    private static List<String> report(final Path root) throws IOException {
        return Files.readAllLines(root.resolve("report.txt"), StandardCharsets.UTF_8);
    }

    @Test
    void theCloneIsGoneBeforeMakeReleaseStartsAndAfterItFails(@TempDir final Path root) throws Exception {
        assumeTrue(onPath("make") && onPath("git"), "needs make and git");
        final Path clone = root.resolve("clone");

        final int status = runReleaseWithDevops(root, fixtureRepository(root, true), clone, null);

        assertNotEquals(0, status, "a failed `make release` must fail ondewo_release");
        assertEquals(
                List.of("clone-absent", "gh-token-loaded", "central-loaded", "gpg-loaded", "args=release"),
                report(root));
        assertFalse(Files.exists(clone), "the devops-accounts clone survived the release");
    }

    @Test
    void theCloneIsRemovedWhenLoadingTheCredentialsFails(@TempDir final Path root) throws Exception {
        assumeTrue(onPath("make") && onPath("git"), "needs make and git");
        final Path clone = root.resolve("clone");

        final int status = runReleaseWithDevops(root, fixtureRepository(root, false), clone, null);

        assertNotEquals(0, status);
        assertFalse(Files.exists(root.resolve("report.txt")), "`make release` ran without credentials");
        assertFalse(Files.exists(clone), "the devops-accounts clone survived a failed load");
    }

    @Test
    void aGivenDevopsAccountDirIsReadNeitherClonedNorDeleted(@TempDir final Path root) throws Exception {
        assumeTrue(onPath("make"), "needs make");
        final Path given = root.resolve("given-accounts");
        writeAccounts(given, true);
        final Path clone = root.resolve("clone");

        final int status =
                runReleaseWithDevops(root, root.resolve("no-such-origin"), clone, given);

        assertNotEquals(0, status);
        assertEquals(
                List.of("clone-absent", "gh-token-loaded", "central-loaded", "gpg-loaded", "args=release"),
                report(root));
        assertTrue(Files.isRegularFile(given.resolve("account_github.env")), "the caller's checkout was deleted");
        assertFalse(Files.exists(clone), "a clone was made although DEVOPS_ACCOUNT_DIR was given");
    }
    /** Runs {@code make <args>} in the checkout with no secret, no caller DEVOPS_ACCOUNT_DIR and no parent make flags. */
    private static String makeOutput(final Map<String, String> extraEnvironment, final String... args)
            throws Exception {
        final List<String> command = new ArrayList<>(List.of("make", "--no-print-directory"));
        command.addAll(Arrays.asList(args));
        final ProcessBuilder builder = new ProcessBuilder(command).redirectErrorStream(true);
        final Map<String, String> environment = builder.environment();
        for (final String name : SECRET_NAMES) {
            environment.remove(name);
        }
        for (final String name : List.of("MAKEFLAGS", "MFLAGS", "MAKELEVEL", "VERIFY_ATTEMPTS",
                "VERIFY_INTERVAL_S", "RELEASE_VERIFY_ATTEMPTS", "RELEASE_VERIFY_INTERVAL_S")) {
            environment.remove(name);
        }
        environment.putAll(extraEnvironment);
        final Process process = builder.start();
        final String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        assertTrue(process.waitFor(60, TimeUnit.SECONDS), "timed out: " + command);
        assertEquals(0, process.exitValue(), command + "\n" + output);
        return output;
    }

    /**
     * {@code make -n ondewo_release} prints the release and touches nothing: a recipe line that
     * contains $(MAKE) runs even under -n, so without the MAKE_DRY_RUN guard it would clone the
     * credentials repository. An unreachable URL proves no clone is even attempted.
     */
    @Test
    void aDryRunOfOndewoReleaseClonesAndReadsNothing(@TempDir final Path root) throws Exception {
        assumeTrue(onPath("make"), "needs make");
        final Path clone = root.resolve("clone");

        final String output =
                makeOutput(
                        Map.of(),
                        "-n",
                        "ondewo_release",
                        "DEVOPS_ACCOUNT_GIT_URL=" + root.resolve("nonexistent").resolve("x.git"),
                        "DEVOPS_ACCOUNT_CLONE_DIR=" + clone);

        assertTrue(output.contains("not cloning or reading"), output);
        assertTrue(output.contains("make release_preflight"), output);
        // make -n prints the whole recipe, the clone line included; what must not happen is that it
        // RUNS: a clone of the unreachable URL would print git's fatal error and fail the target.
        assertFalse(output.contains("fatal:"), "a dry run tried to clone:\n" + output);
        assertFalse(Files.exists(clone), "make -n ondewo_release cloned the credentials repository");
    }

    /** The polling of verify_maven_central_serves_version, as make -n prints it. */
    private static String verifyPolling(final Map<String, String> environment, final String... overrides)
            throws Exception {
        final List<String> args = new ArrayList<>(List.of("-n", "verify_maven_central_serves_version"));
        args.addAll(Arrays.asList(overrides));
        return makeOutput(environment, args.toArray(new String[0]));
    }

    /**
     * The release driver passes the driver-wide VERIFY_ATTEMPTS / VERIFY_INTERVAL_S to every client;
     * they must reach the repo1.maven.org polling, and the older RELEASE_VERIFY_* names keep working.
     */
    @Test
    void theDriverWideVerifyOverridesReachThePolling() throws Exception {
        assumeTrue(onPath("make"), "needs make");

        final String defaults = verifyPolling(Map.of());
        assertTrue(defaults.contains("-ge 20 ]") && defaults.contains("sleep 30"), defaults);

        final String commandLine = verifyPolling(Map.of(), "VERIFY_ATTEMPTS=3", "VERIFY_INTERVAL_S=10");
        assertTrue(commandLine.contains("-ge 3 ]") && commandLine.contains("sleep 10"), commandLine);

        final String environment =
                verifyPolling(Map.of("VERIFY_ATTEMPTS", "4", "VERIFY_INTERVAL_S", "11"));
        assertTrue(environment.contains("-ge 4 ]") && environment.contains("sleep 11"), environment);

        final String legacy =
                verifyPolling(Map.of(), "RELEASE_VERIFY_ATTEMPTS=5", "RELEASE_VERIFY_INTERVAL_S=12");
        assertTrue(legacy.contains("-ge 5 ]") && legacy.contains("sleep 12"), legacy);
    }
}
