package ondewo.csi;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationsGrpc {

  private ConversationsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "ondewo.csi.Conversations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipeline,
      com.google.protobuf.Empty> getCreateS2sPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateS2sPipeline",
      requestType = ondewo.csi.Conversation.S2sPipeline.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipeline,
      com.google.protobuf.Empty> getCreateS2sPipelineMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipeline, com.google.protobuf.Empty> getCreateS2sPipelineMethod;
    if ((getCreateS2sPipelineMethod = ConversationsGrpc.getCreateS2sPipelineMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getCreateS2sPipelineMethod = ConversationsGrpc.getCreateS2sPipelineMethod) == null) {
          ConversationsGrpc.getCreateS2sPipelineMethod = getCreateS2sPipelineMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.S2sPipeline, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateS2sPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sPipeline.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("CreateS2sPipeline"))
              .build();
        }
      }
    }
    return getCreateS2sPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipelineId,
      ondewo.csi.Conversation.S2sPipeline> getGetS2sPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetS2sPipeline",
      requestType = ondewo.csi.Conversation.S2sPipelineId.class,
      responseType = ondewo.csi.Conversation.S2sPipeline.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipelineId,
      ondewo.csi.Conversation.S2sPipeline> getGetS2sPipelineMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipelineId, ondewo.csi.Conversation.S2sPipeline> getGetS2sPipelineMethod;
    if ((getGetS2sPipelineMethod = ConversationsGrpc.getGetS2sPipelineMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getGetS2sPipelineMethod = ConversationsGrpc.getGetS2sPipelineMethod) == null) {
          ConversationsGrpc.getGetS2sPipelineMethod = getGetS2sPipelineMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.S2sPipelineId, ondewo.csi.Conversation.S2sPipeline>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetS2sPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sPipelineId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sPipeline.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("GetS2sPipeline"))
              .build();
        }
      }
    }
    return getGetS2sPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipeline,
      com.google.protobuf.Empty> getUpdateS2sPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateS2sPipeline",
      requestType = ondewo.csi.Conversation.S2sPipeline.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipeline,
      com.google.protobuf.Empty> getUpdateS2sPipelineMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipeline, com.google.protobuf.Empty> getUpdateS2sPipelineMethod;
    if ((getUpdateS2sPipelineMethod = ConversationsGrpc.getUpdateS2sPipelineMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getUpdateS2sPipelineMethod = ConversationsGrpc.getUpdateS2sPipelineMethod) == null) {
          ConversationsGrpc.getUpdateS2sPipelineMethod = getUpdateS2sPipelineMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.S2sPipeline, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateS2sPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sPipeline.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("UpdateS2sPipeline"))
              .build();
        }
      }
    }
    return getUpdateS2sPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipelineId,
      com.google.protobuf.Empty> getDeleteS2sPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteS2sPipeline",
      requestType = ondewo.csi.Conversation.S2sPipelineId.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipelineId,
      com.google.protobuf.Empty> getDeleteS2sPipelineMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sPipelineId, com.google.protobuf.Empty> getDeleteS2sPipelineMethod;
    if ((getDeleteS2sPipelineMethod = ConversationsGrpc.getDeleteS2sPipelineMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getDeleteS2sPipelineMethod = ConversationsGrpc.getDeleteS2sPipelineMethod) == null) {
          ConversationsGrpc.getDeleteS2sPipelineMethod = getDeleteS2sPipelineMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.S2sPipelineId, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteS2sPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sPipelineId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("DeleteS2sPipeline"))
              .build();
        }
      }
    }
    return getDeleteS2sPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.ListS2sPipelinesRequest,
      ondewo.csi.Conversation.ListS2sPipelinesResponse> getListS2sPipelinesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListS2sPipelines",
      requestType = ondewo.csi.Conversation.ListS2sPipelinesRequest.class,
      responseType = ondewo.csi.Conversation.ListS2sPipelinesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.ListS2sPipelinesRequest,
      ondewo.csi.Conversation.ListS2sPipelinesResponse> getListS2sPipelinesMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.ListS2sPipelinesRequest, ondewo.csi.Conversation.ListS2sPipelinesResponse> getListS2sPipelinesMethod;
    if ((getListS2sPipelinesMethod = ConversationsGrpc.getListS2sPipelinesMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getListS2sPipelinesMethod = ConversationsGrpc.getListS2sPipelinesMethod) == null) {
          ConversationsGrpc.getListS2sPipelinesMethod = getListS2sPipelinesMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.ListS2sPipelinesRequest, ondewo.csi.Conversation.ListS2sPipelinesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListS2sPipelines"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.ListS2sPipelinesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.ListS2sPipelinesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("ListS2sPipelines"))
              .build();
        }
      }
    }
    return getListS2sPipelinesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sStreamRequest,
      ondewo.csi.Conversation.S2sStreamResponse> getS2sStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "S2sStream",
      requestType = ondewo.csi.Conversation.S2sStreamRequest.class,
      responseType = ondewo.csi.Conversation.S2sStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sStreamRequest,
      ondewo.csi.Conversation.S2sStreamResponse> getS2sStreamMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.S2sStreamRequest, ondewo.csi.Conversation.S2sStreamResponse> getS2sStreamMethod;
    if ((getS2sStreamMethod = ConversationsGrpc.getS2sStreamMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getS2sStreamMethod = ConversationsGrpc.getS2sStreamMethod) == null) {
          ConversationsGrpc.getS2sStreamMethod = getS2sStreamMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.S2sStreamRequest, ondewo.csi.Conversation.S2sStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "S2sStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.S2sStreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("S2sStream"))
              .build();
        }
      }
    }
    return getS2sStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ondewo.csi.Conversation.CheckUpstreamHealthResponse> getCheckUpstreamHealthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckUpstreamHealth",
      requestType = com.google.protobuf.Empty.class,
      responseType = ondewo.csi.Conversation.CheckUpstreamHealthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ondewo.csi.Conversation.CheckUpstreamHealthResponse> getCheckUpstreamHealthMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ondewo.csi.Conversation.CheckUpstreamHealthResponse> getCheckUpstreamHealthMethod;
    if ((getCheckUpstreamHealthMethod = ConversationsGrpc.getCheckUpstreamHealthMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getCheckUpstreamHealthMethod = ConversationsGrpc.getCheckUpstreamHealthMethod) == null) {
          ConversationsGrpc.getCheckUpstreamHealthMethod = getCheckUpstreamHealthMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ondewo.csi.Conversation.CheckUpstreamHealthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckUpstreamHealth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.CheckUpstreamHealthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("CheckUpstreamHealth"))
              .build();
        }
      }
    }
    return getCheckUpstreamHealthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.ControlStreamRequest,
      ondewo.csi.Conversation.ControlStreamResponse> getGetControlStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetControlStream",
      requestType = ondewo.csi.Conversation.ControlStreamRequest.class,
      responseType = ondewo.csi.Conversation.ControlStreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.ControlStreamRequest,
      ondewo.csi.Conversation.ControlStreamResponse> getGetControlStreamMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.ControlStreamRequest, ondewo.csi.Conversation.ControlStreamResponse> getGetControlStreamMethod;
    if ((getGetControlStreamMethod = ConversationsGrpc.getGetControlStreamMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getGetControlStreamMethod = ConversationsGrpc.getGetControlStreamMethod) == null) {
          ConversationsGrpc.getGetControlStreamMethod = getGetControlStreamMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.ControlStreamRequest, ondewo.csi.Conversation.ControlStreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetControlStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.ControlStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.ControlStreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("GetControlStream"))
              .build();
        }
      }
    }
    return getGetControlStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ondewo.csi.Conversation.SetControlStatusRequest,
      ondewo.csi.Conversation.SetControlStatusResponse> getSetControlStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetControlStatus",
      requestType = ondewo.csi.Conversation.SetControlStatusRequest.class,
      responseType = ondewo.csi.Conversation.SetControlStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ondewo.csi.Conversation.SetControlStatusRequest,
      ondewo.csi.Conversation.SetControlStatusResponse> getSetControlStatusMethod() {
    io.grpc.MethodDescriptor<ondewo.csi.Conversation.SetControlStatusRequest, ondewo.csi.Conversation.SetControlStatusResponse> getSetControlStatusMethod;
    if ((getSetControlStatusMethod = ConversationsGrpc.getSetControlStatusMethod) == null) {
      synchronized (ConversationsGrpc.class) {
        if ((getSetControlStatusMethod = ConversationsGrpc.getSetControlStatusMethod) == null) {
          ConversationsGrpc.getSetControlStatusMethod = getSetControlStatusMethod =
              io.grpc.MethodDescriptor.<ondewo.csi.Conversation.SetControlStatusRequest, ondewo.csi.Conversation.SetControlStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetControlStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.SetControlStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ondewo.csi.Conversation.SetControlStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationsMethodDescriptorSupplier("SetControlStatus"))
              .build();
        }
      }
    }
    return getSetControlStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConversationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationsStub>() {
        @java.lang.Override
        public ConversationsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationsStub(channel, callOptions);
        }
      };
    return ConversationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static ConversationsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationsBlockingV2Stub>() {
        @java.lang.Override
        public ConversationsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationsBlockingV2Stub(channel, callOptions);
        }
      };
    return ConversationsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationsBlockingStub>() {
        @java.lang.Override
        public ConversationsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationsBlockingStub(channel, callOptions);
        }
      };
    return ConversationsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConversationsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationsFutureStub>() {
        @java.lang.Override
        public ConversationsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationsFutureStub(channel, callOptions);
        }
      };
    return ConversationsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * &lt;p&gt;Create the S2S pipeline specified in the request message. The pipeline with the specified ID must not exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.CreateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    default void createS2sPipeline(ondewo.csi.Conversation.S2sPipeline request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateS2sPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Retrieve the S2S pipeline with the ID specified in the request message.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.GetS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }
     * &lt;/samp&gt;
     * </pre>
     */
    default void getS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sPipeline> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetS2sPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Update the S2S pipeline specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "en",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.UpdateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    default void updateS2sPipeline(ondewo.csi.Conversation.S2sPipeline request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateS2sPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete the S2S pipeline with the ID specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.DeleteS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    default void deleteS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteS2sPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;List all S2S pipelines of the server.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.ListS2sPipelines
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "pipelines": [
     *     {
     *       "id": "pizza",
     *       "s2t_pipeline_id": "default_german",
     *       "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *       "nlu_language_code": "de",
     *       "t2s_pipeline_id": "default_german"
     *     }
     *   ]
     * }&lt;/samp&gt;
     * </pre>
     */
    default void listS2sPipelines(ondewo.csi.Conversation.ListS2sPipelinesRequest request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.ListS2sPipelinesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListS2sPipelinesMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Processes a natural language query in audio format in a streaming fashion and returns structured, actionable data as a result.&lt;/p&gt;
     * </pre>
     */
    default io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sStreamRequest> s2sStream(
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sStreamResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getS2sStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Check the health of S2T, NLU and T2S servers.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.CheckUpstreamHealth
     * &lt;/pre&gt;
     * All upstreams healthy:
     * &lt;samp&gt;{}&lt;/samp&gt;
     * All upstreams unhealthy:
     * &lt;samp&gt;{
     *   "s2t_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "nlu_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "t2s_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   }
     * }&lt;/samp&gt;
     * </pre>
     */
    default void checkUpstreamHealth(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.CheckUpstreamHealthResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckUpstreamHealthMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Get the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    default void getControlStream(ondewo.csi.Conversation.ControlStreamRequest request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.ControlStreamResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetControlStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Send a message on the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    default void setControlStatus(ondewo.csi.Conversation.SetControlStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.SetControlStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetControlStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Conversations.
   * <pre>
   * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
   * </pre>
   */
  public static abstract class ConversationsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ConversationsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Conversations.
   * <pre>
   * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
   * </pre>
   */
  public static final class ConversationsStub
      extends io.grpc.stub.AbstractAsyncStub<ConversationsStub> {
    private ConversationsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create the S2S pipeline specified in the request message. The pipeline with the specified ID must not exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.CreateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public void createS2sPipeline(ondewo.csi.Conversation.S2sPipeline request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateS2sPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Retrieve the S2S pipeline with the ID specified in the request message.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.GetS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }
     * &lt;/samp&gt;
     * </pre>
     */
    public void getS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sPipeline> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetS2sPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Update the S2S pipeline specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "en",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.UpdateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public void updateS2sPipeline(ondewo.csi.Conversation.S2sPipeline request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateS2sPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete the S2S pipeline with the ID specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.DeleteS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public void deleteS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteS2sPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;List all S2S pipelines of the server.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.ListS2sPipelines
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "pipelines": [
     *     {
     *       "id": "pizza",
     *       "s2t_pipeline_id": "default_german",
     *       "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *       "nlu_language_code": "de",
     *       "t2s_pipeline_id": "default_german"
     *     }
     *   ]
     * }&lt;/samp&gt;
     * </pre>
     */
    public void listS2sPipelines(ondewo.csi.Conversation.ListS2sPipelinesRequest request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.ListS2sPipelinesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListS2sPipelinesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Processes a natural language query in audio format in a streaming fashion and returns structured, actionable data as a result.&lt;/p&gt;
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sStreamRequest> s2sStream(
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sStreamResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getS2sStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Check the health of S2T, NLU and T2S servers.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.CheckUpstreamHealth
     * &lt;/pre&gt;
     * All upstreams healthy:
     * &lt;samp&gt;{}&lt;/samp&gt;
     * All upstreams unhealthy:
     * &lt;samp&gt;{
     *   "s2t_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "nlu_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "t2s_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   }
     * }&lt;/samp&gt;
     * </pre>
     */
    public void checkUpstreamHealth(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.CheckUpstreamHealthResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckUpstreamHealthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Get the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    public void getControlStream(ondewo.csi.Conversation.ControlStreamRequest request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.ControlStreamResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetControlStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * &lt;p&gt;Send a message on the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    public void setControlStatus(ondewo.csi.Conversation.SetControlStatusRequest request,
        io.grpc.stub.StreamObserver<ondewo.csi.Conversation.SetControlStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetControlStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Conversations.
   * <pre>
   * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
   * </pre>
   */
  public static final class ConversationsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ConversationsBlockingV2Stub> {
    private ConversationsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create the S2S pipeline specified in the request message. The pipeline with the specified ID must not exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.CreateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.protobuf.Empty createS2sPipeline(ondewo.csi.Conversation.S2sPipeline request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Retrieve the S2S pipeline with the ID specified in the request message.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.GetS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }
     * &lt;/samp&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.S2sPipeline getS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Update the S2S pipeline specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "en",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.UpdateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.protobuf.Empty updateS2sPipeline(ondewo.csi.Conversation.S2sPipeline request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete the S2S pipeline with the ID specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.DeleteS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.protobuf.Empty deleteS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;List all S2S pipelines of the server.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.ListS2sPipelines
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "pipelines": [
     *     {
     *       "id": "pizza",
     *       "s2t_pipeline_id": "default_german",
     *       "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *       "nlu_language_code": "de",
     *       "t2s_pipeline_id": "default_german"
     *     }
     *   ]
     * }&lt;/samp&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.ListS2sPipelinesResponse listS2sPipelines(ondewo.csi.Conversation.ListS2sPipelinesRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListS2sPipelinesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Processes a natural language query in audio format in a streaming fashion and returns structured, actionable data as a result.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<ondewo.csi.Conversation.S2sStreamRequest, ondewo.csi.Conversation.S2sStreamResponse>
        s2sStream() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getS2sStreamMethod(), getCallOptions());
    }

    /**
     * <pre>
     * &lt;p&gt;Check the health of S2T, NLU and T2S servers.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.CheckUpstreamHealth
     * &lt;/pre&gt;
     * All upstreams healthy:
     * &lt;samp&gt;{}&lt;/samp&gt;
     * All upstreams unhealthy:
     * &lt;samp&gt;{
     *   "s2t_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "nlu_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "t2s_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   }
     * }&lt;/samp&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.CheckUpstreamHealthResponse checkUpstreamHealth(com.google.protobuf.Empty request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCheckUpstreamHealthMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, ondewo.csi.Conversation.ControlStreamResponse>
        getControlStream(ondewo.csi.Conversation.ControlStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getGetControlStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Send a message on the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.SetControlStatusResponse setControlStatus(ondewo.csi.Conversation.SetControlStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetControlStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Conversations.
   * <pre>
   * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
   * </pre>
   */
  public static final class ConversationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConversationsBlockingStub> {
    private ConversationsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create the S2S pipeline specified in the request message. The pipeline with the specified ID must not exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.CreateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.protobuf.Empty createS2sPipeline(ondewo.csi.Conversation.S2sPipeline request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Retrieve the S2S pipeline with the ID specified in the request message.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.GetS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }
     * &lt;/samp&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.S2sPipeline getS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Update the S2S pipeline specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "en",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.UpdateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.protobuf.Empty updateS2sPipeline(ondewo.csi.Conversation.S2sPipeline request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete the S2S pipeline with the ID specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.DeleteS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.protobuf.Empty deleteS2sPipeline(ondewo.csi.Conversation.S2sPipelineId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteS2sPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;List all S2S pipelines of the server.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.ListS2sPipelines
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "pipelines": [
     *     {
     *       "id": "pizza",
     *       "s2t_pipeline_id": "default_german",
     *       "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *       "nlu_language_code": "de",
     *       "t2s_pipeline_id": "default_german"
     *     }
     *   ]
     * }&lt;/samp&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.ListS2sPipelinesResponse listS2sPipelines(ondewo.csi.Conversation.ListS2sPipelinesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListS2sPipelinesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Check the health of S2T, NLU and T2S servers.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.CheckUpstreamHealth
     * &lt;/pre&gt;
     * All upstreams healthy:
     * &lt;samp&gt;{}&lt;/samp&gt;
     * All upstreams unhealthy:
     * &lt;samp&gt;{
     *   "s2t_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "nlu_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "t2s_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   }
     * }&lt;/samp&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.CheckUpstreamHealthResponse checkUpstreamHealth(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckUpstreamHealthMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Get the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    public java.util.Iterator<ondewo.csi.Conversation.ControlStreamResponse> getControlStream(
        ondewo.csi.Conversation.ControlStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetControlStreamMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Send a message on the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    public ondewo.csi.Conversation.SetControlStatusResponse setControlStatus(ondewo.csi.Conversation.SetControlStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetControlStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Conversations.
   * <pre>
   * &lt;p&gt;Endpoints of CSI service.&lt;/p&gt;
   * </pre>
   */
  public static final class ConversationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConversationsFutureStub> {
    private ConversationsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * &lt;p&gt;Create the S2S pipeline specified in the request message. The pipeline with the specified ID must not exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.CreateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> createS2sPipeline(
        ondewo.csi.Conversation.S2sPipeline request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateS2sPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Retrieve the S2S pipeline with the ID specified in the request message.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.GetS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "de",
     *   "t2s_pipeline_id": "default_german"
     * }
     * &lt;/samp&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.csi.Conversation.S2sPipeline> getS2sPipeline(
        ondewo.csi.Conversation.S2sPipelineId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetS2sPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Update the S2S pipeline specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{
     *   "id": "pizza",
     *   "s2t_pipeline_id": "default_german",
     *   "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *   "nlu_language_code": "en",
     *   "t2s_pipeline_id": "default_german"
     * }' localhost:50051 ondewo.csi.Conversations.UpdateS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateS2sPipeline(
        ondewo.csi.Conversation.S2sPipeline request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateS2sPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Delete the S2S pipeline with the ID specified in the request message. The pipeline must exist.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext -d '{"id": "pizza"}' localhost:50051 ondewo.csi.Conversations.DeleteS2sPipeline
     * &lt;/pre&gt;
     * &lt;samp&gt;{}&lt;/samp&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteS2sPipeline(
        ondewo.csi.Conversation.S2sPipelineId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteS2sPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;List all S2S pipelines of the server.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.ListS2sPipelines
     * &lt;/pre&gt;
     * &lt;samp&gt;{
     *   "pipelines": [
     *     {
     *       "id": "pizza",
     *       "s2t_pipeline_id": "default_german",
     *       "nlu_project_id": "1f3425d2-41fd-4970-87e6-88e8e121bb49",
     *       "nlu_language_code": "de",
     *       "t2s_pipeline_id": "default_german"
     *     }
     *   ]
     * }&lt;/samp&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.csi.Conversation.ListS2sPipelinesResponse> listS2sPipelines(
        ondewo.csi.Conversation.ListS2sPipelinesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListS2sPipelinesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Check the health of S2T, NLU and T2S servers.&lt;/p&gt;
     * &lt;p&gt;Examples:&lt;/p&gt;
     * &lt;pre&gt;
     * grpcurl -plaintext localhost:50051 ondewo.csi.Conversations.CheckUpstreamHealth
     * &lt;/pre&gt;
     * All upstreams healthy:
     * &lt;samp&gt;{}&lt;/samp&gt;
     * All upstreams unhealthy:
     * &lt;samp&gt;{
     *   "s2t_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "nlu_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   },
     *   "t2s_status": {
     *     "code": 14,
     *     "message": "failed to connect to all addresses"
     *   }
     * }&lt;/samp&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.csi.Conversation.CheckUpstreamHealthResponse> checkUpstreamHealth(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckUpstreamHealthMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * &lt;p&gt;Send a message on the control stream to control sip, t2s, s2t etc. during a conversation.&lt;/p&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ondewo.csi.Conversation.SetControlStatusResponse> setControlStatus(
        ondewo.csi.Conversation.SetControlStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetControlStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_S2S_PIPELINE = 0;
  private static final int METHODID_GET_S2S_PIPELINE = 1;
  private static final int METHODID_UPDATE_S2S_PIPELINE = 2;
  private static final int METHODID_DELETE_S2S_PIPELINE = 3;
  private static final int METHODID_LIST_S2S_PIPELINES = 4;
  private static final int METHODID_CHECK_UPSTREAM_HEALTH = 5;
  private static final int METHODID_GET_CONTROL_STREAM = 6;
  private static final int METHODID_SET_CONTROL_STATUS = 7;
  private static final int METHODID_S2S_STREAM = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_S2S_PIPELINE:
          serviceImpl.createS2sPipeline((ondewo.csi.Conversation.S2sPipeline) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_S2S_PIPELINE:
          serviceImpl.getS2sPipeline((ondewo.csi.Conversation.S2sPipelineId) request,
              (io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sPipeline>) responseObserver);
          break;
        case METHODID_UPDATE_S2S_PIPELINE:
          serviceImpl.updateS2sPipeline((ondewo.csi.Conversation.S2sPipeline) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_S2S_PIPELINE:
          serviceImpl.deleteS2sPipeline((ondewo.csi.Conversation.S2sPipelineId) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_S2S_PIPELINES:
          serviceImpl.listS2sPipelines((ondewo.csi.Conversation.ListS2sPipelinesRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.csi.Conversation.ListS2sPipelinesResponse>) responseObserver);
          break;
        case METHODID_CHECK_UPSTREAM_HEALTH:
          serviceImpl.checkUpstreamHealth((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<ondewo.csi.Conversation.CheckUpstreamHealthResponse>) responseObserver);
          break;
        case METHODID_GET_CONTROL_STREAM:
          serviceImpl.getControlStream((ondewo.csi.Conversation.ControlStreamRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.csi.Conversation.ControlStreamResponse>) responseObserver);
          break;
        case METHODID_SET_CONTROL_STATUS:
          serviceImpl.setControlStatus((ondewo.csi.Conversation.SetControlStatusRequest) request,
              (io.grpc.stub.StreamObserver<ondewo.csi.Conversation.SetControlStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_S2S_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.s2sStream(
              (io.grpc.stub.StreamObserver<ondewo.csi.Conversation.S2sStreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateS2sPipelineMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.csi.Conversation.S2sPipeline,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE_S2S_PIPELINE)))
        .addMethod(
          getGetS2sPipelineMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.csi.Conversation.S2sPipelineId,
              ondewo.csi.Conversation.S2sPipeline>(
                service, METHODID_GET_S2S_PIPELINE)))
        .addMethod(
          getUpdateS2sPipelineMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.csi.Conversation.S2sPipeline,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_S2S_PIPELINE)))
        .addMethod(
          getDeleteS2sPipelineMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.csi.Conversation.S2sPipelineId,
              com.google.protobuf.Empty>(
                service, METHODID_DELETE_S2S_PIPELINE)))
        .addMethod(
          getListS2sPipelinesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.csi.Conversation.ListS2sPipelinesRequest,
              ondewo.csi.Conversation.ListS2sPipelinesResponse>(
                service, METHODID_LIST_S2S_PIPELINES)))
        .addMethod(
          getS2sStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              ondewo.csi.Conversation.S2sStreamRequest,
              ondewo.csi.Conversation.S2sStreamResponse>(
                service, METHODID_S2S_STREAM)))
        .addMethod(
          getCheckUpstreamHealthMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              ondewo.csi.Conversation.CheckUpstreamHealthResponse>(
                service, METHODID_CHECK_UPSTREAM_HEALTH)))
        .addMethod(
          getGetControlStreamMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              ondewo.csi.Conversation.ControlStreamRequest,
              ondewo.csi.Conversation.ControlStreamResponse>(
                service, METHODID_GET_CONTROL_STREAM)))
        .addMethod(
          getSetControlStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ondewo.csi.Conversation.SetControlStatusRequest,
              ondewo.csi.Conversation.SetControlStatusResponse>(
                service, METHODID_SET_CONTROL_STATUS)))
        .build();
  }

  private static abstract class ConversationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ondewo.csi.Conversation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Conversations");
    }
  }

  private static final class ConversationsFileDescriptorSupplier
      extends ConversationsBaseDescriptorSupplier {
    ConversationsFileDescriptorSupplier() {}
  }

  private static final class ConversationsMethodDescriptorSupplier
      extends ConversationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConversationsMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConversationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConversationsFileDescriptorSupplier())
              .addMethod(getCreateS2sPipelineMethod())
              .addMethod(getGetS2sPipelineMethod())
              .addMethod(getUpdateS2sPipelineMethod())
              .addMethod(getDeleteS2sPipelineMethod())
              .addMethod(getListS2sPipelinesMethod())
              .addMethod(getS2sStreamMethod())
              .addMethod(getCheckUpstreamHealthMethod())
              .addMethod(getGetControlStreamMethod())
              .addMethod(getSetControlStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
