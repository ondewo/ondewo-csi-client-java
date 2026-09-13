package com.ondewo.csi.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.protobuf.Timestamp;
import com.ondewo.nlu.AudioEncoding;
import com.ondewo.nlu.Context;
import java.util.stream.Stream;
import ondewo.csi.Conversation;
import ondewo.nlu.Rag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Exercises the committed protoc output. These are the tests that catch a broken generator:
 * they build a message, push it through the real binary marshaller and read it back.
 *
 * <p>The protos of this product come in two java flavours and both are covered here: the
 * ondewo-nlu-api protos that ondewo-csi-api vendors and that set {@code java_multiple_files}
 * (context.proto, entity_type.proto, session.proto, common.proto) produce top-level classes in
 * {@code com.ondewo.nlu}, all the others - conversation.proto included - nest their messages in
 * an outer class in {@code ondewo.<api>}.
 */
class GeneratedMessagesTest {

    @Test
    void roundTripsAMultiFileMessage() throws Exception {
        final Context original =
                Context.newBuilder()
                        .setName("welcome")
                        .setLifespanCount(5)
                        .putParameters(
                                "city",
                                Context.Parameter.newBuilder()
                                        .setName("city")
                                        .setDisplayName("City")
                                        .setValue("Vienna")
                                        .setCreatedAt(Timestamp.newBuilder().setSeconds(1_700_000_000L).build())
                                        .build())
                        .setCreatedBy("6a1b2c3d-0000-4000-8000-000000000000")
                        .build();

        final byte[] wire = original.toByteArray();
        final Context parsed = Context.parseFrom(wire);

        assertEquals(original, parsed);
        assertEquals("welcome", parsed.getName());
        assertEquals(5, parsed.getLifespanCount());
        assertEquals("Vienna", parsed.getParametersOrThrow("city").getValue());
        assertEquals(1_700_000_000L, parsed.getParametersOrThrow("city").getCreatedAt().getSeconds());
        assertTrue(wire.length > 0);
    }

    @Test
    void roundTripsAnOuterClassMessage() throws Exception {
        final Conversation.S2sPipeline original =
                Conversation.S2sPipeline.newBuilder()
                        .setId("pizza")
                        .setS2TPipelineId("default_german")
                        .setNluProjectId("6a1b2c3d-0000-4000-8000-000000000000")
                        .setNluLanguageCode("de")
                        .setT2SPipelineId("kerstin")
                        .build();

        final Conversation.S2sPipeline parsed =
                Conversation.S2sPipeline.parseFrom(original.toByteArray());

        assertEquals(original, parsed);
        assertEquals("pizza", parsed.getId());
        assertEquals("default_german", parsed.getS2TPipelineId());
        assertEquals("kerstin", parsed.getT2SPipelineId());
    }

    /**
     * {@code optional int32 auto_keywords = 1} in ondewo/nlu/rag.proto. Explicit presence is
     * what lets a client send the zero value; losing it is the exact regression that broke the
     * angular target, so it is asserted on the wire here.
     */
    @Test
    void keepsExplicitPresenceOfAnOptionalScalar() throws Exception {
        final Rag.RagParserConfig unset = Rag.RagParserConfig.newBuilder().setDelimiter("\n").build();
        final Rag.RagParserConfig explicitZero =
                Rag.RagParserConfig.newBuilder().setDelimiter("\n").setAutoKeywords(0).build();

        assertFalse(Rag.RagParserConfig.parseFrom(unset.toByteArray()).hasAutoKeywords());
        assertTrue(Rag.RagParserConfig.parseFrom(explicitZero.toByteArray()).hasAutoKeywords());
        assertEquals(0, Rag.RagParserConfig.parseFrom(explicitZero.toByteArray()).getAutoKeywords());
        // An explicitly set zero has to reach the wire, an unset field must not.
        assertTrue(explicitZero.toByteArray().length > unset.toByteArray().length);
    }

    @Test
    void keepsTheProtoPackageInTheDescriptor() {
        // The java_package of the vendored nlu protos is rewritten to com.ondewo.nlu by the
        // compiler image, but the PROTO package - what goes on the wire - must stay ondewo.nlu,
        // and this product's own messages must stay ondewo.csi.
        assertEquals("ondewo.nlu.Context", Context.getDescriptor().getFullName());
        assertEquals("ondewo.nlu.RagParserConfig", Rag.RagParserConfig.getDescriptor().getFullName());
        assertEquals(
                "ondewo.csi.S2sPipeline", Conversation.S2sPipeline.getDescriptor().getFullName());
    }

    @ParameterizedTest(name = "{0} has the zero value {1}")
    @MethodSource("zeroValues")
    void everyEnumDeclaresItsDefaultAtZero(final String name, final int number, final Object zeroValue) {
        assertEquals(0, number, name);
        assertEquals(name, zeroValue.toString());
    }

    /**
     * The vendored nlu enums spell their default {@code *_UNSPECIFIED}; the csi enums predate
     * that convention and name theirs {@code OK} / {@code UNKNOWNNAME}. Either way the member
     * that carries number 0 is the one a proto3 field falls back to, so that is what is pinned.
     */
    private static Stream<Arguments> zeroValues() {
        return Stream.of(
                Arguments.of(
                        "AUDIO_ENCODING_UNSPECIFIED",
                        AudioEncoding.AUDIO_ENCODING_UNSPECIFIED.getNumber(),
                        AudioEncoding.forNumber(0)),
                Arguments.of(
                        "OK",
                        Conversation.ControlStatus.OK.getNumber(),
                        Conversation.ControlStatus.forNumber(0)),
                Arguments.of(
                        "UNKNOWNNAME",
                        Conversation.ControlMessageServiceName.UNKNOWNNAME.getNumber(),
                        Conversation.ControlMessageServiceName.forNumber(0)));
    }

    @Test
    void defaultInstancesAreEmpty() {
        assertEquals("", Conversation.S2sPipeline.getDefaultInstance().getId());
        assertEquals("", Conversation.S2sPipeline.getDefaultInstance().getT2SPipelineId());
        assertFalse(Rag.RagParserConfig.getDefaultInstance().hasAutoKeywords());
        assertEquals(0, Conversation.S2sPipeline.getDefaultInstance().getSerializedSize());
    }
}
