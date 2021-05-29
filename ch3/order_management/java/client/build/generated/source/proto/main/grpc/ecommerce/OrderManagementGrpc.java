package ecommerce;

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
    value = "by gRPC proto compiler (version 1.24.1)",
    comments = "Source: order_management.proto")
public final class OrderManagementGrpc {

  private OrderManagementGrpc() {}

  public static final String SERVICE_NAME = "ecommerce.OrderManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ecommerce.OrderManagementOuterClass.Order> getGetOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getOrder",
      requestType = com.google.protobuf.StringValue.class,
      responseType = ecommerce.OrderManagementOuterClass.Order.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ecommerce.OrderManagementOuterClass.Order> getGetOrderMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, ecommerce.OrderManagementOuterClass.Order> getGetOrderMethod;
    if ((getGetOrderMethod = OrderManagementGrpc.getGetOrderMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getGetOrderMethod = OrderManagementGrpc.getGetOrderMethod) == null) {
          OrderManagementGrpc.getGetOrderMethod = getGetOrderMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, ecommerce.OrderManagementOuterClass.Order>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ecommerce.OrderManagementOuterClass.Order.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("getOrder"))
              .build();
        }
      }
    }
    return getGetOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ecommerce.OrderManagementOuterClass.Order,
      com.google.protobuf.StringValue> getAddOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addOrder",
      requestType = ecommerce.OrderManagementOuterClass.Order.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ecommerce.OrderManagementOuterClass.Order,
      com.google.protobuf.StringValue> getAddOrderMethod() {
    io.grpc.MethodDescriptor<ecommerce.OrderManagementOuterClass.Order, com.google.protobuf.StringValue> getAddOrderMethod;
    if ((getAddOrderMethod = OrderManagementGrpc.getAddOrderMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getAddOrderMethod = OrderManagementGrpc.getAddOrderMethod) == null) {
          OrderManagementGrpc.getAddOrderMethod = getAddOrderMethod =
              io.grpc.MethodDescriptor.<ecommerce.OrderManagementOuterClass.Order, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ecommerce.OrderManagementOuterClass.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("addOrder"))
              .build();
        }
      }
    }
    return getAddOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ecommerce.OrderManagementOuterClass.Order> getSearchOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchOrders",
      requestType = com.google.protobuf.StringValue.class,
      responseType = ecommerce.OrderManagementOuterClass.Order.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ecommerce.OrderManagementOuterClass.Order> getSearchOrdersMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, ecommerce.OrderManagementOuterClass.Order> getSearchOrdersMethod;
    if ((getSearchOrdersMethod = OrderManagementGrpc.getSearchOrdersMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getSearchOrdersMethod = OrderManagementGrpc.getSearchOrdersMethod) == null) {
          OrderManagementGrpc.getSearchOrdersMethod = getSearchOrdersMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, ecommerce.OrderManagementOuterClass.Order>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ecommerce.OrderManagementOuterClass.Order.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("searchOrders"))
              .build();
        }
      }
    }
    return getSearchOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ecommerce.OrderManagementOuterClass.Order,
      com.google.protobuf.StringValue> getUpdateOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateOrders",
      requestType = ecommerce.OrderManagementOuterClass.Order.class,
      responseType = com.google.protobuf.StringValue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ecommerce.OrderManagementOuterClass.Order,
      com.google.protobuf.StringValue> getUpdateOrdersMethod() {
    io.grpc.MethodDescriptor<ecommerce.OrderManagementOuterClass.Order, com.google.protobuf.StringValue> getUpdateOrdersMethod;
    if ((getUpdateOrdersMethod = OrderManagementGrpc.getUpdateOrdersMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getUpdateOrdersMethod = OrderManagementGrpc.getUpdateOrdersMethod) == null) {
          OrderManagementGrpc.getUpdateOrdersMethod = getUpdateOrdersMethod =
              io.grpc.MethodDescriptor.<ecommerce.OrderManagementOuterClass.Order, com.google.protobuf.StringValue>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ecommerce.OrderManagementOuterClass.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("updateOrders"))
              .build();
        }
      }
    }
    return getUpdateOrdersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ecommerce.OrderManagementOuterClass.CombinedShipment> getProcessOrdersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processOrders",
      requestType = com.google.protobuf.StringValue.class,
      responseType = ecommerce.OrderManagementOuterClass.CombinedShipment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      ecommerce.OrderManagementOuterClass.CombinedShipment> getProcessOrdersMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, ecommerce.OrderManagementOuterClass.CombinedShipment> getProcessOrdersMethod;
    if ((getProcessOrdersMethod = OrderManagementGrpc.getProcessOrdersMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getProcessOrdersMethod = OrderManagementGrpc.getProcessOrdersMethod) == null) {
          OrderManagementGrpc.getProcessOrdersMethod = getProcessOrdersMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, ecommerce.OrderManagementOuterClass.CombinedShipment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "processOrders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ecommerce.OrderManagementOuterClass.CombinedShipment.getDefaultInstance()))
              .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("processOrders"))
              .build();
        }
      }
    }
    return getProcessOrdersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderManagementStub newStub(io.grpc.Channel channel) {
    return new OrderManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderManagementFutureStub(channel);
  }

  /**
   */
  public static abstract class OrderManagementImplBase implements io.grpc.BindableService {

    /**
     */
    public void getOrder(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order> responseObserver) {
      asyncUnimplementedUnaryCall(getGetOrderMethod(), responseObserver);
    }

    /**
     */
    public void addOrder(ecommerce.OrderManagementOuterClass.Order request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      asyncUnimplementedUnaryCall(getAddOrderMethod(), responseObserver);
    }

    /**
     */
    public void searchOrders(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchOrdersMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order> updateOrders(
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateOrdersMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> processOrders(
        io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.CombinedShipment> responseObserver) {
      return asyncUnimplementedStreamingCall(getProcessOrdersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                ecommerce.OrderManagementOuterClass.Order>(
                  this, METHODID_GET_ORDER)))
          .addMethod(
            getAddOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ecommerce.OrderManagementOuterClass.Order,
                com.google.protobuf.StringValue>(
                  this, METHODID_ADD_ORDER)))
          .addMethod(
            getSearchOrdersMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                ecommerce.OrderManagementOuterClass.Order>(
                  this, METHODID_SEARCH_ORDERS)))
          .addMethod(
            getUpdateOrdersMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ecommerce.OrderManagementOuterClass.Order,
                com.google.protobuf.StringValue>(
                  this, METHODID_UPDATE_ORDERS)))
          .addMethod(
            getProcessOrdersMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                ecommerce.OrderManagementOuterClass.CombinedShipment>(
                  this, METHODID_PROCESS_ORDERS)))
          .build();
    }
  }

  /**
   */
  public static final class OrderManagementStub extends io.grpc.stub.AbstractStub<OrderManagementStub> {
    private OrderManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementStub(channel, callOptions);
    }

    /**
     */
    public void getOrder(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addOrder(ecommerce.OrderManagementOuterClass.Order request,
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchOrders(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSearchOrdersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order> updateOrders(
        io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getUpdateOrdersMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> processOrders(
        io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.CombinedShipment> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getProcessOrdersMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class OrderManagementBlockingStub extends io.grpc.stub.AbstractStub<OrderManagementBlockingStub> {
    private OrderManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementBlockingStub(channel, callOptions);
    }

    /**
     */
    public ecommerce.OrderManagementOuterClass.Order getOrder(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getGetOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.StringValue addOrder(ecommerce.OrderManagementOuterClass.Order request) {
      return blockingUnaryCall(
          getChannel(), getAddOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ecommerce.OrderManagementOuterClass.Order> searchOrders(
        com.google.protobuf.StringValue request) {
      return blockingServerStreamingCall(
          getChannel(), getSearchOrdersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OrderManagementFutureStub extends io.grpc.stub.AbstractStub<OrderManagementFutureStub> {
    private OrderManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ecommerce.OrderManagementOuterClass.Order> getOrder(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.StringValue> addOrder(
        ecommerce.OrderManagementOuterClass.Order request) {
      return futureUnaryCall(
          getChannel().newCall(getAddOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ORDER = 0;
  private static final int METHODID_ADD_ORDER = 1;
  private static final int METHODID_SEARCH_ORDERS = 2;
  private static final int METHODID_UPDATE_ORDERS = 3;
  private static final int METHODID_PROCESS_ORDERS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ORDER:
          serviceImpl.getOrder((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order>) responseObserver);
          break;
        case METHODID_ADD_ORDER:
          serviceImpl.addOrder((ecommerce.OrderManagementOuterClass.Order) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
          break;
        case METHODID_SEARCH_ORDERS:
          serviceImpl.searchOrders((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.Order>) responseObserver);
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
        case METHODID_UPDATE_ORDERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.updateOrders(
              (io.grpc.stub.StreamObserver<com.google.protobuf.StringValue>) responseObserver);
        case METHODID_PROCESS_ORDERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processOrders(
              (io.grpc.stub.StreamObserver<ecommerce.OrderManagementOuterClass.CombinedShipment>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OrderManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ecommerce.OrderManagementOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderManagement");
    }
  }

  private static final class OrderManagementFileDescriptorSupplier
      extends OrderManagementBaseDescriptorSupplier {
    OrderManagementFileDescriptorSupplier() {}
  }

  private static final class OrderManagementMethodDescriptorSupplier
      extends OrderManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderManagementFileDescriptorSupplier())
              .addMethod(getGetOrderMethod())
              .addMethod(getAddOrderMethod())
              .addMethod(getSearchOrdersMethod())
              .addMethod(getUpdateOrdersMethod())
              .addMethod(getProcessOrdersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
