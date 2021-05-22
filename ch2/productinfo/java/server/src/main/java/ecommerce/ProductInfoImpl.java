package ecommerce;

import ecommerce.ProductInfoGrpc.ProductInfoImplBase;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static ecommerce.ProductInfoOuterClass.*;

public class ProductInfoImpl extends ProductInfoImplBase {

    private Map productMap = new HashMap<String, Product>();

    @Override
    public void addProduct(
            Product request,
            StreamObserver<ProductId> responseObserver
    ) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        productMap.put(randomUUIDString, request);

        ProductId id =
                ProductId.newBuilder().setValue(randomUUIDString).build();

        responseObserver.onNext(id);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(
            ProductId request,
            StreamObserver<Product> responseObserver
    ) {
        String id = request.getValue();

        if(productMap.containsKey(id)) {
            responseObserver.onNext((ProductInfoOuterClass.Product) productMap.get(id));
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }
}
