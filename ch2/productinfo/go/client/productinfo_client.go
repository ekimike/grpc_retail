package main

import (
	"context"
	"log"
	"time"

	pb "productinfo/client/ecommerce/business/product"

	"google.golang.org/grpc"
)

const (
	address = "localhost:50051"
)

func main() {
	conn, err := grpc.Dial(address, grpc.WithInsecure())

	if err != nil {
		log.Fatal("didnt connect: %v", err)
	}

	defer conn.Close()
	c := pb.NewProductInfoClient(conn)

	name := "Pixel 3"
	description := "Nice phone"

	ctx, cancel := context.WithTimeout(context.Background(), time.Second)

	defer cancel()

	r, err := c.AddProduct(ctx,
		&pb.Product{Name: name, Description: description})

	if err != nil {
		log.Fatalf("could not add product: %v", err)
	}
	log.Printf("product id %s added", r.Value)

	product, err := c.GetProduct(ctx, &pb.ProductId{Value: r.Value})

	if err != nil {
		log.Fatalf("could not get product: %v", err)
	}

	log.Printf("Product: ", product.String())
}
