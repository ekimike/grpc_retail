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

1. Create two directories: one for the `proto file` and related files and the other one for the service

2. Create the proto file inside the proto directory: `foo_bar.proto`. 

This file needs: `option go_package = "server/ecommerce";` because the module aid option which frees you up from setting up a home for each project.

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

7. `go.mod` file was created. here you don't need to add any extra line because dependencies will be fetched using the command: `go mod tidy`


8. Implement business logic using the generated code. Create a Go file productinfo_service.go

9. Create a Go Server

Before building the server binary run `go mod tidy` just in case. If you receive some error regarding GOPATH, double check the import statements 
on all go files, first is module name and then the fisical directories created with protoc command.

```go
go build -v -o bin/server
```


## Implementing a Java Go client


Create a gradle project, the most easy way is  using intellij

```gradle
apply plugin: 'java'
apply plugin: 'com.google.protobuf'

repositories {
    mavenCentral()
}


def grpcVersion = '1.24.1'

dependencies {
    compile "io.grpc:grpc-netty:${grpcVersion}"
    compile "io.grpc:grpc-protobuf:${grpcVersion}"
    compile "io.grpc:grpc-stub:${grpcVersion}"
    compile 'com.google.protobuf:protobuf-java:3.9.2'
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {

        classpath 'com.google.protobuf:protobuf-gradle-plugin:0.8.10'
    }
}

protobuf {
    protoc {
        artifact = 'com.google.protobuf:protoc:3.9.2'
    }
    plugins {
        grpc {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
    }
    generateProtoTasks {
        all()*.plugins {
            grpc {}
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs 'build/generated/source/proto/main/grpc'
            srcDirs 'build/generated/source/proto/main/java'
        }
    }
}

jar {
    manifest {
        attributes "Main-Class": "ecommerce.ProductInfoServer"
    }
    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}

apply plugin: 'application'

startScripts.enabled = false
```
Again, create a directory called proto at the same level of main, add the proto file and build the project.

