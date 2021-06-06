package ecommerce;


import com.google.protobuf.StringValue;
import io.grpc.stub.StreamObserver;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderMgtServiceImpl extends OrderManagementGrpc.OrderManagementImplBase {

    private static final Logger logger =
            Logger.getLogger(OrderMgtServiceImpl.class.getName());


    private OrderManagementOuterClass.Order o1 =
            OrderManagementOuterClass.Order.newBuilder()
            .setId("102")
            .addItems("Google Pixel").addItems("MBP")
            .setDestination("Mountain View")
            .setPrice(1800)
            .build();

    private OrderManagementOuterClass.Order o2 =
            OrderManagementOuterClass.Order.newBuilder()
            .setId("103")
            .addItems("Apple Watch")
            .setDestination("San jose")
            .setPrice(400)
            .build();

    private OrderManagementOuterClass.Order o3 =
            OrderManagementOuterClass.Order.newBuilder()
            .setId("104")
            .addItems("Google Mini").addItems("Google Hub")
            .setDestination("Mountain View")
            .setPrice(400)
            .build();

    private Map<String, OrderManagementOuterClass.Order> orderMap =
            Stream.of(
                    new AbstractMap.SimpleEntry<>(o1.getId(), o1),
                    new AbstractMap.SimpleEntry<>(o2.getId(), o2),
                    new AbstractMap.SimpleEntry<>(o3.getId(), o3)
            ).collect(
                    Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)
            );

    private Map<String, OrderManagementOuterClass.CombinedShipment> combinedShipmentMap =
            new HashMap<>();

    public static final int BATCH_SIZE = 3;

    //unary request
    @Override
    public void addOrder(OrderManagementOuterClass.Order order,
                         StreamObserver<StringValue> response) {

        logger.info("Order added: " + order.getId() + " - Destination: " + order.getDestination());
        orderMap.put(order.getId(), order);

        StringValue id = StringValue.newBuilder().setValue("100500").build();

        response.onNext(id);
        response.onCompleted();
    }

    //unary response
    @Override
    public void getOrder(StringValue request,
                         StreamObserver<OrderManagementOuterClass.Order> response) {

        OrderManagementOuterClass.Order order =
                orderMap.get(request.getValue());

        if ( order != null ) {
            logger.info("order retrieved: " + order.getId());
            response.onNext(order);
            response.onCompleted();
        } else {
            logger.info("Order not found: " + request.getValue());
        }
    }

    //server streaming
    @Override
    public void searchOrders(StringValue request,
                             StreamObserver<OrderManagementOuterClass.Order> response) {

        for( Map.Entry<String, OrderManagementOuterClass.Order> orderEntry :
                orderMap.entrySet() ) {

            OrderManagementOuterClass.Order order =  orderEntry.getValue();
            int itemsCount = order.getItemsCount();

            for ( int index = 0; index < itemsCount; index++ ) {
                String item =  order.getItems(index);

                if( item.contains((request.getValue())) ) {
                    logger.info("item found");
                    response.onNext(order);
                    break;
                }
            }
        }
        response.onCompleted();
    }

    //client streaming
    @Override
    public StreamObserver<OrderManagementOuterClass.Order> updateOrders(StreamObserver<StringValue> response) {

        return new StreamObserver<OrderManagementOuterClass.Order>() {

            StringBuilder updatedOrderStrBuilder =
                    new StringBuilder().append("updated order: ");

            @Override
            public void onNext(OrderManagementOuterClass.Order value) {
                if( value != null ) {
                    orderMap.put(value.getId(), value);
                    updatedOrderStrBuilder.append(value.getId()).append(", ");
                    logger.info("updated: " + value.getId());
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.info("update error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("completed to update");
                StringValue updatedOrders =
                        StringValue.newBuilder().setValue(updatedOrderStrBuilder.toString()).build();
                response.onNext(updatedOrders);
                response.onCompleted();
            }
        };
    }

    //bi di streaming
    @Override
    public StreamObserver<StringValue> processOrders(StreamObserver<OrderManagementOuterClass.CombinedShipment> response) {

        return new StreamObserver<StringValue>() {

            int batchMarker = 0;

            @Override
            public void onNext(StringValue value) {
                logger.info("order proc: " + value.getValue());
                OrderManagementOuterClass.Order currentOrder =
                        orderMap.get(value.getValue());

                if( currentOrder == null ) {
                    logger.info("no order found: " + value.getValue());
                    return;
                }

                batchMarker++;
                String orderDestination = currentOrder.getDestination();
                OrderManagementOuterClass.CombinedShipment existingShipment =
                        combinedShipmentMap.get(orderDestination);

                if ( existingShipment != null ) {
                    existingShipment =
                            OrderManagementOuterClass
                                    .CombinedShipment
                                    .newBuilder(existingShipment)
                                    .addOrdersList(currentOrder)
                                    .build();

                    combinedShipmentMap.put(orderDestination, existingShipment);
                } else {
                    OrderManagementOuterClass.CombinedShipment shipment =
                            OrderManagementOuterClass.CombinedShipment.newBuilder().build();
                    shipment = shipment.newBuilderForType()
                            .addOrdersList(currentOrder)
                            .setId("CMB-" + new Random().nextInt(1000) + ":" + currentOrder.getDestination())
                            .setStatus("Processed!")
                            .build();
                    combinedShipmentMap.put(currentOrder.getDestination(), shipment);
                }

                if (batchMarker == BATCH_SIZE) {
                    for (Map.Entry<String, OrderManagementOuterClass.CombinedShipment> entry : combinedShipmentMap.entrySet()) {
                        response.onNext(entry.getValue());
                    }
                    batchMarker = 0;
                    combinedShipmentMap.clear();
                }
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }
}
