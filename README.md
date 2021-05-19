# grpc_retail

## Set GO PATH (not sure how that ~/go has appearead) 

export GO_PATH=~/go
export PATH=$PATH:/$GO_PATH/bin

## Well know protobuf types:

[Types] (https://developers.google.com/protocol-buffers/docs/reference/google.protobuf)


## Protobuf compiler

[Protocol Buffer Compiler] (https://github.com/protocolbuffers/protobuf/releases/)

## Implementing a gRPC server (service) with Go

# STUB

1. Create two directories: one for the `proto` and related files and the other one for the service

2. Create the proto file inside the proto directory: `foo_bar.proto`. 

This file needs: `option go_package = "server/ecommerce";`

3. Install gRPC library:

```go
go get -u google.golang.org/grpc
```

4. Install protoc plug-in for Go

```go
go get -u github.com/golang/protobuf/protoc-gen-go
```

5. Generate the file `xyz.pb.go`:

```bash
cd $HOME/microservice (if you list the directories you will se a couple of directories: service_directory & proto)
protoc -I proto \ (1)
 proto/product_info.proto \ (2)
 --go_out=plugins=grpc:go (3)
```

(1) Specifies the directory path where the source proto file and dependent proto file exist.
(2) Specifies the path where the proto file exists.
(3) Specifies the directory name where we want to create the file, after running the command you will see server/ecommerce.
This is because in the proto file we have defined: `option go_package = "server/ecommerce";`

6. Move inside recent directory created named: `server` and run the following command:

```go
go mod init productinfo/service
```

7. `go.mod` file was created, add the following lines:

```go
require (
  github.com/gofrs/uuid v3.2.0
  github.com/golang/protobuf v1.3.2
  github.com/google/uuid v1.1.1
  google.golang.org/grpc v1.24.0
)
```

8. Implement business logic using the generated code. Create a Go file productinfo_service.go

9. Create a Go Server

## Implementing a gRPC Go client

