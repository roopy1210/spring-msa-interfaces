package com.roopy.hello.service;

import com.roopy.proto.HelloRequest;
import com.roopy.proto.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class HelloService {

    @GrpcClient("hello")
    private HelloServiceGrpc.HelloServiceStub helloServiceStub;

    public Object sayHello(Map<String,Object> param) {
        CompletableFuture<Map<String, Object>> completableFuture = new CompletableFuture<>();
        OutputStreamingResponse outputStreamingResponse = new OutputStreamingResponse(
                new HashMap<>(),
                completableFuture
        );

        StreamObserver<HelloRequest> helloBiStream = this.helloServiceStub.sayHelloBidirectional(outputStreamingResponse);

        HelloRequest request = HelloRequest.newBuilder()
                        .setName((String) param.get("name"))
                        .build();

        helloBiStream.onNext(request);
        helloBiStream.onCompleted();

        return completableFuture;

    }
}
