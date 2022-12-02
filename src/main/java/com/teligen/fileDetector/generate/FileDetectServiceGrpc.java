package com.teligen.fileDetector.generate;

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
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: file.proto")
public final class FileDetectServiceGrpc {

  private FileDetectServiceGrpc() {}

  public static final String SERVICE_NAME = "teligen.FileDetectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.teligen.fileDetector.generate.UndetectedFile,
      com.teligen.fileDetector.generate.DetectedFile> getDetectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "detect",
      requestType = com.teligen.fileDetector.generate.UndetectedFile.class,
      responseType = com.teligen.fileDetector.generate.DetectedFile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.teligen.fileDetector.generate.UndetectedFile,
      com.teligen.fileDetector.generate.DetectedFile> getDetectMethod() {
    io.grpc.MethodDescriptor<com.teligen.fileDetector.generate.UndetectedFile, com.teligen.fileDetector.generate.DetectedFile> getDetectMethod;
    if ((getDetectMethod = FileDetectServiceGrpc.getDetectMethod) == null) {
      synchronized (FileDetectServiceGrpc.class) {
        if ((getDetectMethod = FileDetectServiceGrpc.getDetectMethod) == null) {
          FileDetectServiceGrpc.getDetectMethod = getDetectMethod =
              io.grpc.MethodDescriptor.<com.teligen.fileDetector.generate.UndetectedFile, com.teligen.fileDetector.generate.DetectedFile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "detect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.teligen.fileDetector.generate.UndetectedFile.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.teligen.fileDetector.generate.DetectedFile.getDefaultInstance()))
              .setSchemaDescriptor(new FileDetectServiceMethodDescriptorSupplier("detect"))
              .build();
        }
      }
    }
    return getDetectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.teligen.fileDetector.generate.UndetectedFile,
      com.teligen.fileDetector.generate.DetectedFile> getStreamDetectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamDetect",
      requestType = com.teligen.fileDetector.generate.UndetectedFile.class,
      responseType = com.teligen.fileDetector.generate.DetectedFile.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.teligen.fileDetector.generate.UndetectedFile,
      com.teligen.fileDetector.generate.DetectedFile> getStreamDetectMethod() {
    io.grpc.MethodDescriptor<com.teligen.fileDetector.generate.UndetectedFile, com.teligen.fileDetector.generate.DetectedFile> getStreamDetectMethod;
    if ((getStreamDetectMethod = FileDetectServiceGrpc.getStreamDetectMethod) == null) {
      synchronized (FileDetectServiceGrpc.class) {
        if ((getStreamDetectMethod = FileDetectServiceGrpc.getStreamDetectMethod) == null) {
          FileDetectServiceGrpc.getStreamDetectMethod = getStreamDetectMethod =
              io.grpc.MethodDescriptor.<com.teligen.fileDetector.generate.UndetectedFile, com.teligen.fileDetector.generate.DetectedFile>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamDetect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.teligen.fileDetector.generate.UndetectedFile.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.teligen.fileDetector.generate.DetectedFile.getDefaultInstance()))
              .setSchemaDescriptor(new FileDetectServiceMethodDescriptorSupplier("streamDetect"))
              .build();
        }
      }
    }
    return getStreamDetectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileDetectServiceStub newStub(io.grpc.Channel channel) {
    return new FileDetectServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileDetectServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileDetectServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileDetectServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileDetectServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileDetectServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void detect(com.teligen.fileDetector.generate.UndetectedFile request,
        io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.DetectedFile> responseObserver) {
      asyncUnimplementedUnaryCall(getDetectMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.UndetectedFile> streamDetect(
        io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.DetectedFile> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamDetectMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDetectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.teligen.fileDetector.generate.UndetectedFile,
                com.teligen.fileDetector.generate.DetectedFile>(
                  this, METHODID_DETECT)))
          .addMethod(
            getStreamDetectMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.teligen.fileDetector.generate.UndetectedFile,
                com.teligen.fileDetector.generate.DetectedFile>(
                  this, METHODID_STREAM_DETECT)))
          .build();
    }
  }

  /**
   */
  public static final class FileDetectServiceStub extends io.grpc.stub.AbstractStub<FileDetectServiceStub> {
    private FileDetectServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileDetectServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileDetectServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileDetectServiceStub(channel, callOptions);
    }

    /**
     */
    public void detect(com.teligen.fileDetector.generate.UndetectedFile request,
        io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.DetectedFile> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.UndetectedFile> streamDetect(
        io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.DetectedFile> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStreamDetectMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FileDetectServiceBlockingStub extends io.grpc.stub.AbstractStub<FileDetectServiceBlockingStub> {
    private FileDetectServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileDetectServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileDetectServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileDetectServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.teligen.fileDetector.generate.DetectedFile detect(com.teligen.fileDetector.generate.UndetectedFile request) {
      return blockingUnaryCall(
          getChannel(), getDetectMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileDetectServiceFutureStub extends io.grpc.stub.AbstractStub<FileDetectServiceFutureStub> {
    private FileDetectServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileDetectServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileDetectServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileDetectServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.teligen.fileDetector.generate.DetectedFile> detect(
        com.teligen.fileDetector.generate.UndetectedFile request) {
      return futureUnaryCall(
          getChannel().newCall(getDetectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DETECT = 0;
  private static final int METHODID_STREAM_DETECT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileDetectServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileDetectServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DETECT:
          serviceImpl.detect((com.teligen.fileDetector.generate.UndetectedFile) request,
              (io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.DetectedFile>) responseObserver);
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
        case METHODID_STREAM_DETECT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamDetect(
              (io.grpc.stub.StreamObserver<com.teligen.fileDetector.generate.DetectedFile>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FileDetectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileDetectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.teligen.fileDetector.generate.File.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileDetectService");
    }
  }

  private static final class FileDetectServiceFileDescriptorSupplier
      extends FileDetectServiceBaseDescriptorSupplier {
    FileDetectServiceFileDescriptorSupplier() {}
  }

  private static final class FileDetectServiceMethodDescriptorSupplier
      extends FileDetectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileDetectServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FileDetectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileDetectServiceFileDescriptorSupplier())
              .addMethod(getDetectMethod())
              .addMethod(getStreamDetectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
