package main

import (
	"context"
	"log"
	pb "microservice/service/ecommerce/service"
	"time"

	wrapper "github.com/golang/protobuf/ptypes/wrappers"

	"google.golang.org/grpc"
)

const (
	address = "localhost:50051"
)

func main() {

	conn, err := grpc.Dial(address, grpc.WithInsecure())

	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}

	defer conn.Close()

	client := pb.NewOrderManagementClient(conn)
	ctx, cancel := context.WithTimeout(context.Background(), time.Second*5)

	defer cancel()

	//add order
	order1 := pb.Order{Id: "101", Items: []string{"iPhone XS", "MacBook Pro"}, Destination: "San Jose", Price: 2300.00}
	res, _ := client.AddOrder(ctx, &order1)

	if res != nil {
		log.Print("AddOrder Response -> ", res.Value)
	}

	//get order
	retrievedOrder, err := client.GetOrder(ctx, &wrapper.StringValue{Value: "101"})
	log.Print("GetOrder Response -> ", retrievedOrder)

}
