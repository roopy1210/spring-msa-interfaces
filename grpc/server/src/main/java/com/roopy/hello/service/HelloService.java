package com.roopy.hello.service;

import com.roopy.proto.HelloRequest;
import com.roopy.proto.HelloResponse;
import com.roopy.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {


    @Override
    public StreamObserver<HelloRequest> sayHelloBidirectional(StreamObserver<HelloResponse> responseObserver) {

        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest request) {
                HelloResponse response = HelloResponse.newBuilder()
                        .setGreeting("Hello " + request.getName() + "!!!!")
                        .build();

                responseObserver.onNext(response);

            }

            @Override
            public void onError(Throwable throwable) {
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
