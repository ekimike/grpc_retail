package ecommerce;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class OrderMgtServer {

    private static final Logger logger =
            Logger.getLogger(OrderMgtServer.class.getName());

    private Server server;

    private void start() throws IOException {
        int port = 50051;

        server = ServerBuilder.forPort(port)
                .addService(new OrderMgtServiceImpl())
                .build()
                .start();

        logger.info("server started...");

        Runtime.getRuntime().addShutdownHook(
                new Thread( () -> {
                    logger.info("shutting down gRPC");
                    OrderMgtServer.this.stop();
                })
        );
    }

    private void stop() {
        if( server != null ) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if( server != null ) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        final OrderMgtServer server = new OrderMgtServer();
        server.start();
        server.blockUntilShutdown();
    }
}
