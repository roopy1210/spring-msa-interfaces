package com.roopy.hello.service;

import com.roopy.proto.HelloResponse;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class OutputStreamingResponse implements StreamObserver<HelloResponse> {

    private final Map<String,Object> map;
    private final CompletableFuture<Map<String,Object>> completableFuture;

    public OutputStreamingResponse(Map<String, Object> map, CompletableFuture<Map<String, Object>> completableFuture) {
        this.map = map;
        this.completableFuture = completableFuture;
    }

    @Override
    public void onNext(HelloResponse output) {
        this.map.put("greeting", output.getGreeting());

    }

    @Override
    public void onError(Throwable t) {
        completableFuture.cancel(true);
    }

    @Override
    public void onCompleted() {
        completableFuture.complete(this.map);
    }
}
