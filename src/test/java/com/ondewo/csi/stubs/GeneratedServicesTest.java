package com.ondewo.csi.stubs;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ondewo.csi.auth.BearerToken;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerInterceptors;
import io.grpc.ServiceDescriptor;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.stub.StreamObserver;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import ondewo.csi.Conversation;
import ondewo.csi.ConversationsGrpc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exercises the generated gRPC service stubs: their descriptors, every stub flavour, and one
 * real request/response round trip over the in-process transport - no socket, no network, but
 * the real generated marshallers on both ends.
 */
class GeneratedServicesTest {

    /**
     * Number of {@code *Grpc} classes protoc must emit for this product: {@code
     * ondewo.csi.Conversations} plus the 16 ondewo.nlu services, {@code ondewo.s2t.Speech2Text}
     * and {@code ondewo.t2s.Text2Speech} - ondewo-csi-api vendors those three apis. Bump it
     * when the api adds or drops a service - that is exactly the kind of silent generator
     * regression this test exists to catch.
     */
    private static final int EXPECTED_SERVICE_COUNT = 19;

    private static final Metadata.Key<String> AUTHORIZATION =
            Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);

    private final AtomicReference<Metadata> receivedHeaders = new AtomicReference<>();

    private Server server;
    private ManagedChannel channel;

    @BeforeEach
    void startServer() throws Exception {
        final ConversationsGrpc.ConversationsImplBase service =
                new ConversationsGrpc.ConversationsImplBase() {
                    @Override
                    public void getS2sPipeline(
                            final Conversation.S2sPipelineId request,
                            final StreamObserver<Conversation.S2sPipeline> responseObserver) {
                        responseObserver.onNext(
                                Conversation.S2sPipeline.newBuilder()
                                        .setId(request.getId())
                                        .setS2TPipelineId("served-" + request.getId())
                                        .build());
                        responseObserver.onCompleted();
                    }
                };

        final ServerInterceptor headerCapture =
                new ServerInterceptor() {
                    @Override
                    public <Q, S> ServerCall.Listener<Q> interceptCall(
                            final ServerCall<Q, S> call,
                            final Metadata headers,
                            final ServerCallHandler<Q, S> next) {
                        receivedHeaders.set(headers);
                        return next.startCall(call, headers);
                    }
                };

        final String name = InProcessServerBuilder.generateName();
        server =
                InProcessServerBuilder.forName(name)
                        .directExecutor()
                        .addService(ServerInterceptors.intercept(service, headerCapture))
                        .build()
                        .start();
        channel = InProcessChannelBuilder.forName(name).build();
    }

    @AfterEach
    void stopServer() throws Exception {
        channel.shutdownNow();
        server.shutdownNow();
        channel.awaitTermination(10, TimeUnit.SECONDS);
        server.awaitTermination(10, TimeUnit.SECONDS);
    }

    @Test
    void exposesTheExpectedServiceDescriptor() {
        final ServiceDescriptor descriptor = ConversationsGrpc.getServiceDescriptor();

        final List<String> methods =
                descriptor.getMethods().stream()
                        .map(MethodDescriptor::getBareMethodName)
                        .collect(toList());

        assertEquals("ondewo.csi.Conversations", descriptor.getName());
        assertTrue(
                methods.containsAll(
                        List.of(
                                "CreateS2sPipeline",
                                "GetS2sPipeline",
                                "UpdateS2sPipeline",
                                "DeleteS2sPipeline",
                                "ListS2sPipelines")),
                "missing rpcs, got " + methods);
        assertEquals(
                MethodDescriptor.MethodType.UNARY,
                ConversationsGrpc.getGetS2sPipelineMethod().getType());
        assertEquals(
                "ondewo.csi.Conversations/GetS2sPipeline",
                ConversationsGrpc.getGetS2sPipelineMethod().getFullMethodName());
        // S2sStream is the product's bidirectional streaming rpc - the generated descriptor has
        // to carry that method type, not collapse it to a unary call.
        assertEquals(
                MethodDescriptor.MethodType.BIDI_STREAMING,
                ConversationsGrpc.getS2sStreamMethod().getType());
    }

    /**
     * Every generated service class, found on the compiled classpath rather than listed by
     * hand, so a service added to the api is picked up without touching this test.
     */
    @Test
    void everyGeneratedServiceHasAUsableDescriptor() throws Exception {
        final Path classesRoot =
                Paths.get(
                        ConversationsGrpc.class
                                .getProtectionDomain()
                                .getCodeSource()
                                .getLocation()
                                .toURI());
        assertTrue(Files.isDirectory(classesRoot), "expected compiled classes at " + classesRoot);

        final List<String> serviceClasses;
        try (Stream<Path> tree = Files.walk(classesRoot)) {
            serviceClasses =
                    tree.filter(Files::isRegularFile)
                            .map(path -> classesRoot.relativize(path).toString())
                            .filter(name -> name.endsWith("Grpc.class"))
                            .map(name -> name.substring(0, name.length() - ".class".length()))
                            .map(name -> name.replace(java.io.File.separatorChar, '.'))
                            .sorted()
                            .collect(toList());
        }

        assertEquals(EXPECTED_SERVICE_COUNT, serviceClasses.size(), "found " + serviceClasses);

        for (final String className : serviceClasses) {
            final ServiceDescriptor descriptor =
                    (ServiceDescriptor)
                            Class.forName(className).getMethod("getServiceDescriptor").invoke(null);

            assertTrue(
                    descriptor.getName().startsWith("ondewo."),
                    className + " serves " + descriptor.getName());
            assertTrue(
                    descriptor.getMethods().iterator().hasNext(),
                    className + " declares no rpc");
        }
    }

    @Test
    void servesAUnaryCallOverTheGeneratedMarshallers() {
        final ConversationsGrpc.ConversationsBlockingStub stub =
                new BearerToken("s3cr3t").attachTo(ConversationsGrpc.newBlockingStub(channel));

        final Conversation.S2sPipeline pipeline =
                stub.getS2sPipeline(
                        Conversation.S2sPipelineId.newBuilder().setId("pizza").build());

        assertEquals("pizza", pipeline.getId());
        assertEquals("served-pizza", pipeline.getS2TPipelineId());
        assertEquals("Bearer s3cr3t", receivedHeaders.get().get(AUTHORIZATION));
    }

    /**
     * The published library declares grpc-netty-shaded, so a consumer can open a channel from
     * a plain target string without adding a transport. Nothing is dialled: gRPC connects
     * lazily, on the first call.
     */
    @Test
    void buildsEveryStubFlavourAgainstAPlainTargetChannel() {
        final ManagedChannel dummy =
                ManagedChannelBuilder.forTarget("localhost:50051").usePlaintext().build();
        try {
            assertNotNull(ConversationsGrpc.newBlockingStub(dummy));
            assertNotNull(ConversationsGrpc.newFutureStub(dummy));
            assertNotNull(ConversationsGrpc.newStub(dummy));
        } finally {
            dummy.shutdownNow();
        }
    }
}
