# Release History

*****************

## Release ONDEWO CSI Java Client 5.9.2

### New Features

* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) Keycloak authentication with offline-token start-up, the same behaviour as ondewo-csi-client-python 5.9.2: `refreshToken` in `ClientConfig` (`keycloakUrl`, `realm`, `clientId`, `username`, `password`, `tokenExpirationInS`, `keycloakVerifySsl` and `refreshToken`) hands the client a Keycloak *offline* refresh token instead of a password. The client then starts with one `grant_type=refresh_token` exchange and never sends a password grant, not even as a fallback; a refused token is never answered with a password login. Keycloak's brute-force detection counts failed LOGINS, so N processes booting at once with one technical user are a burst the realm penalises, while N refresh grants of one offline token are not.
* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) A Keycloak configuration needs a password OR a refresh token, and the Keycloak URL, realm and client id are all-or-nothing; when both credentials are set the token wins. The password and the token are redacted from every rendering of the configuration and take part (hashed) in the shared-provider registry key, so two token-only configurations of different tenants never share a provider. The `token_expiration_in_s` window is armed on both start-up paths.
* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) `GrpcChannels` attaches `authorization: Bearer <token>` to every call when Keycloak is configured (and nothing otherwise); one provider is shared per credential set (SHA-256 keyed, weakly held, never a closed one), with `CallCredentials`, an interceptor and `attachTo` for any stub.

### Bug Fixes

* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) A failed token refresh never ends the background refresh: any failure of the token endpoint (a 502 from a proxy, a DNS failure, a restarting Keycloak, a dead offline session) is retried with one full-jitter backoff (5 s doubling up to 300 s, measured from the moment the failure is recorded) that the per-call path shares, and a success resets it. Concurrent callers during an outage share one in-flight refresh, so an outage costs one token request, not one per call.
* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) A token that is still valid keeps being served when its refresh fails inside the 30 s expiry leeway; only an EXPIRED token raises `KeycloakAuthenticationException`, whatever failed underneath: a transport error, a non-2xx status, a body that is not JSON or not a JSON object, a missing `access_token` or a non-numeric `expires_in`, each with the original error as its cause. A malformed response changes no provider state, and a password login whose response carries no `refresh_token` keeps the previous one, as the python SDK does.

### Improvements

* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) One Keycloak contract across every ONDEWO client SDK, with the python SDK as the reference: the same constants, log lines and error texts. The token request is bounded by 10 s, quoted Keycloak error bodies are cut at 500 characters, a token response is reported by its field names only (never its values), and each failure logs one WARNING with the attempt number and the retry delay, the first success afterwards one INFO; no credential appears in either line.
* [[OND236-120]](https://ondewo.atlassian.net/browse/OND236-120) Tests implement the cross-SDK test catalogue T01-T62 plus edge cases, on a fake token endpoint and clock, with 100 % coverage of the hand-written authentication code.
* Tracking API Version [5.9.0](https://github.com/ondewo/ondewo-csi-api/releases/tag/5.9.0) ( [Documentation](https://ondewo.github.io/ondewo-csi-api/) ); the generated code is unchanged against 5.9.0.

*****************

## Release ONDEWO CSI Java Client 5.9.0

### Improvements

* Tracking API Version [5.9.0](https://github.com/ondewo/ondewo-csi-api/releases/tag/5.9.0) ( [Documentation](https://ondewo.github.io/ondewo-csi-api/) )
* Generated with ondewo-proto-compiler 5.17.0 (protoc 35.1); new runtime floors: protobuf-java 4.35.1, grpc-java 1.85.1, proto-google-common-protos 2.82.0 (protoc 35.1).

*****************

## Release ONDEWO CSI Java Client 5.7.0

### Improvements

* Tracking API Version [5.7.0](https://github.com/ondewo/ondewo-csi-api/releases/tag/5.7.0) ( [Documentation](https://ondewo.github.io/ondewo-csi-api/) )

*****************

## Release ONDEWO CSI Java Client 5.6.2

### Improvements

* Tracking API Version [5.6.2](https://github.com/ondewo/ondewo-csi-api/releases/tag/5.6.2) ( [Documentation](https://ondewo.github.io/ondewo-csi-api/) )

*****************

## Release ONDEWO CSI Java Client 5.6.0

### New Features

* Tracks API Version [5.6.0](https://github.com/ondewo/ondewo-csi-api/releases/tag/5.6.0); the stubs in
  `ondewo.csi` are regenerated from it. New in the API (summary of its release notes):
  * `Conversations.SetCallMediaControl`: per-call operator media control pushed by ondewo-sip. The request
    `CallMediaControlLevel` carries the full effective level (`bot_muted`, `listening_paused`), a monotonic
    `generation` (older pushes are answered `stale=true`) and a `reason`; the response
    `SetCallMediaControlResponse` reports `applied`, `changed`, `stale`, `bot_playback_in_flight` and
    `refusal_reason`.
  * `ControlStreamResponse.media_control`: set only on media-control messages of `GetControlStream`; such a
    message must not be handled as a `control_status` update.
* The API change is purely additive: code built against 5.5.x compiles and stays wire-compatible. The
  vendored nlu / s2t / t2s APIs are unchanged (7.1.0 / 7.5.0 / 6.6.0).

### Improvements

* The stubs are generated by the [ONDEWO proto compiler](https://github.com/ondewo/ondewo-proto-compiler)
  `5.15.5` (was `5.15.2`; no change to the java image between the two).

### Tests

* `GeneratedServicesTest` asserts the new unary `SetCallMediaControl` rpc of `ondewo.csi.Conversations`.

*****************

## Release ONDEWO CSI Java Client 5.5.1

### New Features

* TLS and mutual TLS helper in the hand-written package `com.ondewo.csi.channel` (kept by a
  regeneration): `ClientConfig` (`host`, `port`, `grpcCert`, `grpcClientCert`, `grpcClientKey`,
  `useSecureChannel`, default `true`) and `GrpcChannels.newChannel(config)` /
  `GrpcChannels.newChannelBuilder(config)`. One channel serves every stub of the client.
  * The certificate fields take **PEM content, not file paths**. Non-PEM material (typically a path) or an
    encrypted / non-PKCS#8 key is refused with `IllegalArgumentException` before any connection is
    attempted. An empty `grpcCert` means the JVM trust store.
  * `grpcClientCert` and `grpcClientKey` are both-or-neither: setting only one makes
    `ClientConfig.Builder.build()` throw. Both empty means plain server-authenticated TLS.
  * `useSecureChannel(false)` with a client identity throws instead of silently dropping it. A plaintext
    channel logs a `WARNING` naming `host:port` through `java.util.logging`; the logging configuration of
    the application is never touched.
  * `ClientConfig.toString()` shows `grpcClientKey` as `***REDACTED***` (empty when unset) and the
    certificates only as their length; no error message renders a PEM, the key or a whole config.
  * A bare IPv6 literal host is bracketed (`::1` -> `[::1]:50051`); PEMs with CRLF line endings work.
* Channel defaults aligned with the ONDEWO Python clients where grpc-java exposes them: keepalive timeout
  20 s, `keepAliveWithoutCalls(false)`, `maxInboundMessageSize(Integer.MAX_VALUE)`.
  * Keepalive time is **5 minutes**, not the Python clients' 30 s: grpc-java has no
    `http2.max_pings_without_data`, so a 30 s ping on a silent stream is answered by a default grpc-core
    server with a `too_many_pings` GOAWAY (measured against a grpcio 1.81 server). Pair a server that
    permits faster pings with a shorter `keepAliveTime` on the builder.
  * Not available in grpc-java and documented as gaps: `http2.max_pings_without_data`,
    `max_reconnect_backoff_ms` (grpc-java's backoff caps at 120 s), and no retry policy is configured
    (only gRPC's transparent retries).

### Improvements

* Still tracking API Version [5.5.0](https://github.com/ondewo/ondewo-csi-api/releases/tag/5.5.0)
* The stubs are generated by the [ONDEWO proto compiler](https://github.com/ondewo/ondewo-proto-compiler) `5.15.2` (was `5.15.1`).
* README section "TLS, mutual TLS and certificates": modes, loading PEMs from files, a test PKI with openssl,
  channel defaults, security notes and troubleshooting.

### Tests

* `ClientConfigTest` and `GrpcChannelsTest`: real TLS handshakes against a loopback Netty server with a PKI
  generated at test time (BouncyCastle, test scope only; no key is committed) - TLS with a custom CA, mutual
  TLS, CRLF PEMs, IPv6 `[::1]`, empty identity = plain TLS; missing client certificate, client from an
  unrelated CA and wrong CA end in `UNAVAILABLE`; half pair, plaintext with identity, insecure warning and
  redaction edge cases. The 100 % JaCoCo gate now also covers `com/ondewo/csi/channel/**`.
* `ReleaseNotesTest` pins the `RELEASE.md` heading spelling and the `*****` separator the GitHub release
  body is sliced by, and that the current version has non-empty notes.

*****************

## Release ONDEWO CSI Java Client 5.5.0

### New Features

* Initial release of the ONDEWO CSI (Conversational Speech Interface) gRPC client for Java. The library
  is generated from the protobuf definitions of [ondewo-csi-api](https://github.com/ondewo/ondewo-csi-api)
  by the `ondewo-java-proto-compiler` image of the
  [ONDEWO proto compiler](https://github.com/ondewo/ondewo-proto-compiler) release
  `5.15.1`: `protoc --java_out` for the message classes, `protoc-gen-grpc-java` for the
  service stubs, and a rendered `pom.xml` that pins the gRPC, protobuf and
  `proto-google-common-protos` versions the stubs were generated against. The packaged artifact is
  `com.ondewo:ondewo-csi-client-java`, compiled with `maven.compiler.release=11`, and ships a
  sources jar alongside the binary jar.
* `make build` regenerates the whole client from the pinned submodules - api protos and proto
  compiler - and `make test` verifies that every `.proto` produced java code before running
  `mvn verify`: the JUnit 5 suite over the **committed** stubs (424 generated java files, 19 gRPC
  services) plus the JaCoCo gate. Both run in CI on JDK 11 and JDK 21, unconditionally - a
  missing or truncated client turns the run red instead of skipping a step.
* Adds the one hand-written class of this client, `com/ondewo/csi/auth/BearerToken.java`, which wraps the
  `authorization: Bearer <token>` header every ONDEWO server expects and decorates any generated
  stub with it. Coverage is measured over the hand-written sources only and the build fails below
  100% instruction, branch and method coverage.

*****************
