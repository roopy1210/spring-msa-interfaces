package com.roopy.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: store.proto")
public final class StoreServiceGrpc {

  private StoreServiceGrpc() {}

  public static final String SERVICE_NAME = "StoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest,
      com.roopy.proto.StoreResponse> getFindStoreWithPointAndRadiusUnaryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findStoreWithPointAndRadiusUnary",
      requestType = com.roopy.proto.StoreRequest.class,
      responseType = com.roopy.proto.StoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest,
      com.roopy.proto.StoreResponse> getFindStoreWithPointAndRadiusUnaryMethod() {
    io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest, com.roopy.proto.StoreResponse> getFindStoreWithPointAndRadiusUnaryMethod;
    if ((getFindStoreWithPointAndRadiusUnaryMethod = StoreServiceGrpc.getFindStoreWithPointAndRadiusUnaryMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getFindStoreWithPointAndRadiusUnaryMethod = StoreServiceGrpc.getFindStoreWithPointAndRadiusUnaryMethod) == null) {
          StoreServiceGrpc.getFindStoreWithPointAndRadiusUnaryMethod = getFindStoreWithPointAndRadiusUnaryMethod = 
              io.grpc.MethodDescriptor.<com.roopy.proto.StoreRequest, com.roopy.proto.StoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "StoreService", "findStoreWithPointAndRadiusUnary"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.roopy.proto.StoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.roopy.proto.StoreResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("findStoreWithPointAndRadiusUnary"))
                  .build();
          }
        }
     }
     return getFindStoreWithPointAndRadiusUnaryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest,
      com.roopy.proto.StoreResponse> getFindStoreWithPointAndRadiusBidirectionalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findStoreWithPointAndRadiusBidirectional",
      requestType = com.roopy.proto.StoreRequest.class,
      responseType = com.roopy.proto.StoreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest,
      com.roopy.proto.StoreResponse> getFindStoreWithPointAndRadiusBidirectionalMethod() {
    io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest, com.roopy.proto.StoreResponse> getFindStoreWithPointAndRadiusBidirectionalMethod;
    if ((getFindStoreWithPointAndRadiusBidirectionalMethod = StoreServiceGrpc.getFindStoreWithPointAndRadiusBidirectionalMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getFindStoreWithPointAndRadiusBidirectionalMethod = StoreServiceGrpc.getFindStoreWithPointAndRadiusBidirectionalMethod) == null) {
          StoreServiceGrpc.getFindStoreWithPointAndRadiusBidirectionalMethod = getFindStoreWithPointAndRadiusBidirectionalMethod = 
              io.grpc.MethodDescriptor.<com.roopy.proto.StoreRequest, com.roopy.proto.StoreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StoreService", "findStoreWithPointAndRadiusBidirectional"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.roopy.proto.StoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.roopy.proto.StoreResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("findStoreWithPointAndRadiusBidirectional"))
                  .build();
          }
        }
     }
     return getFindStoreWithPointAndRadiusBidirectionalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest,
      com.roopy.proto.StoreInfo> getFindStoreByIdBidirectionalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "findStoreByIdBidirectional",
      requestType = com.roopy.proto.StoreRequest.class,
      responseType = com.roopy.proto.StoreInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest,
      com.roopy.proto.StoreInfo> getFindStoreByIdBidirectionalMethod() {
    io.grpc.MethodDescriptor<com.roopy.proto.StoreRequest, com.roopy.proto.StoreInfo> getFindStoreByIdBidirectionalMethod;
    if ((getFindStoreByIdBidirectionalMethod = StoreServiceGrpc.getFindStoreByIdBidirectionalMethod) == null) {
      synchronized (StoreServiceGrpc.class) {
        if ((getFindStoreByIdBidirectionalMethod = StoreServiceGrpc.getFindStoreByIdBidirectionalMethod) == null) {
          StoreServiceGrpc.getFindStoreByIdBidirectionalMethod = getFindStoreByIdBidirectionalMethod = 
              io.grpc.MethodDescriptor.<com.roopy.proto.StoreRequest, com.roopy.proto.StoreInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "StoreService", "findStoreByIdBidirectional"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.roopy.proto.StoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.roopy.proto.StoreInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new StoreServiceMethodDescriptorSupplier("findStoreByIdBidirectional"))
                  .build();
          }
        }
     }
     return getFindStoreByIdBidirectionalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StoreServiceStub newStub(io.grpc.Channel channel) {
    return new StoreServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StoreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StoreServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StoreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StoreServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StoreServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void findStoreWithPointAndRadiusUnary(com.roopy.proto.StoreRequest request,
        io.grpc.stub.StreamObserver<com.roopy.proto.StoreResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getFindStoreWithPointAndRadiusUnaryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.roopy.proto.StoreRequest> findStoreWithPointAndRadiusBidirectional(
        io.grpc.stub.StreamObserver<com.roopy.proto.StoreResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindStoreWithPointAndRadiusBidirectionalMethod(), responseObserver);
    }

    /**
     * <pre>
     * Single Bidirectional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.roopy.proto.StoreRequest> findStoreByIdBidirectional(
        io.grpc.stub.StreamObserver<com.roopy.proto.StoreInfo> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindStoreByIdBidirectionalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindStoreWithPointAndRadiusUnaryMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.roopy.proto.StoreRequest,
                com.roopy.proto.StoreResponse>(
                  this, METHODID_FIND_STORE_WITH_POINT_AND_RADIUS_UNARY)))
          .addMethod(
            getFindStoreWithPointAndRadiusBidirectionalMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.roopy.proto.StoreRequest,
                com.roopy.proto.StoreResponse>(
                  this, METHODID_FIND_STORE_WITH_POINT_AND_RADIUS_BIDIRECTIONAL)))
          .addMethod(
            getFindStoreByIdBidirectionalMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.roopy.proto.StoreRequest,
                com.roopy.proto.StoreInfo>(
                  this, METHODID_FIND_STORE_BY_ID_BIDIRECTIONAL)))
          .build();
    }
  }

  /**
   */
  public static final class StoreServiceStub extends io.grpc.stub.AbstractStub<StoreServiceStub> {
    private StoreServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StoreServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StoreServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public void findStoreWithPointAndRadiusUnary(com.roopy.proto.StoreRequest request,
        io.grpc.stub.StreamObserver<com.roopy.proto.StoreResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindStoreWithPointAndRadiusUnaryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.roopy.proto.StoreRequest> findStoreWithPointAndRadiusBidirectional(
        io.grpc.stub.StreamObserver<com.roopy.proto.StoreResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFindStoreWithPointAndRadiusBidirectionalMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Single Bidirectional
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.roopy.proto.StoreRequest> findStoreByIdBidirectional(
        io.grpc.stub.StreamObserver<com.roopy.proto.StoreInfo> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFindStoreByIdBidirectionalMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StoreServiceBlockingStub extends io.grpc.stub.AbstractStub<StoreServiceBlockingStub> {
    private StoreServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StoreServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StoreServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.roopy.proto.StoreResponse findStoreWithPointAndRadiusUnary(com.roopy.proto.StoreRequest request) {
      return blockingUnaryCall(
          getChannel(), getFindStoreWithPointAndRadiusUnaryMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StoreServiceFutureStub extends io.grpc.stub.AbstractStub<StoreServiceFutureStub> {
    private StoreServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StoreServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StoreServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StoreServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.roopy.proto.StoreResponse> findStoreWithPointAndRadiusUnary(
        com.roopy.proto.StoreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFindStoreWithPointAndRadiusUnaryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_STORE_WITH_POINT_AND_RADIUS_UNARY = 0;
  private static final int METHODID_FIND_STORE_WITH_POINT_AND_RADIUS_BIDIRECTIONAL = 1;
  private static final int METHODID_FIND_STORE_BY_ID_BIDIRECTIONAL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StoreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StoreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_STORE_WITH_POINT_AND_RADIUS_UNARY:
          serviceImpl.findStoreWithPointAndRadiusUnary((com.roopy.proto.StoreRequest) request,
              (io.grpc.stub.StreamObserver<com.roopy.proto.StoreResponse>) responseObserver);
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
        case METHODID_FIND_STORE_WITH_POINT_AND_RADIUS_BIDIRECTIONAL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findStoreWithPointAndRadiusBidirectional(
              (io.grpc.stub.StreamObserver<com.roopy.proto.StoreResponse>) responseObserver);
        case METHODID_FIND_STORE_BY_ID_BIDIRECTIONAL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findStoreByIdBidirectional(
              (io.grpc.stub.StreamObserver<com.roopy.proto.StoreInfo>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.roopy.proto.Store.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StoreService");
    }
  }

  private static final class StoreServiceFileDescriptorSupplier
      extends StoreServiceBaseDescriptorSupplier {
    StoreServiceFileDescriptorSupplier() {}
  }

  private static final class StoreServiceMethodDescriptorSupplier
      extends StoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StoreServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StoreServiceFileDescriptorSupplier())
              .addMethod(getFindStoreWithPointAndRadiusUnaryMethod())
              .addMethod(getFindStoreWithPointAndRadiusBidirectionalMethod())
              .addMethod(getFindStoreByIdBidirectionalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
