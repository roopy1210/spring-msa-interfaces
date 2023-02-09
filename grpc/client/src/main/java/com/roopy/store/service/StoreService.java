package com.roopy.store.service;

import com.roopy.proto.StoreInfo;
import com.roopy.proto.StoreRequest;
import com.roopy.proto.StoreResponse;
import com.roopy.proto.StoreServiceGrpc;
import com.roopy.store.dto.StoreDTO;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class StoreService {
    private List<StoreResponse> storeList = new ArrayList<>();

    @GrpcClient("store")
    private StoreServiceGrpc.StoreServiceBlockingStub storeServiceBlockingStub;

    @GrpcClient("store")
    private StoreServiceGrpc.StoreServiceStub storeServiceStub;

    public Map<String,Object> findStoresByPointWithRadiusUnary(StoreDTO storeDTO) {
        Map<String,Object> storeMap = new HashMap<>();

        StoreRequest request = StoreRequest.newBuilder()
                .setLat(storeDTO.getLat())
                .setLot(storeDTO.getLot())
                .setRadius(storeDTO.getRadius())
                .build();

        StoreResponse response = storeServiceBlockingStub.findStoreWithPointAndRadiusUnary(request);
        storeMap.put("data", response);

        return storeMap;
    }

    public Map<String,Object> findStoresByPointWithRadiusBidirectional(StoreDTO storeDTO) throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);

        Map<String,Object> storeMap = new HashMap<>();

        StreamObserver<StoreResponse> responseObserver = new StreamObserver<StoreResponse>() {
            @Override
            public void onNext(StoreResponse response) {
                storeMap.put("data", response);
            }

            @Override
            public void onError(Throwable t) {
                log.warn("findStoresByPointWithRadiusBidirectional Failed: {0}", Status.fromThrowable(t));
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("Finished findStoresByPointWithRadiusBidirectional");
                finishLatch.countDown();
            }
        };

        StreamObserver<StoreRequest> requestObserver = storeServiceStub.findStoreWithPointAndRadiusBidirectional(responseObserver);

        StoreRequest request = StoreRequest.newBuilder()
                .setLat(storeDTO.getLat())
                .setLot(storeDTO.getLot())
                .setRadius(storeDTO.getRadius())
                .build();

        try {
            requestObserver.onNext(request);
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }
        requestObserver.onCompleted();

        boolean await = finishLatch.await(1, TimeUnit.MINUTES);

        return storeMap;
    }

    public Map<String,Object>  findStoreById(int id) throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        Map<String,Object> storeInfoMap = new HashMap<>();

        StreamObserver<StoreRequest> requestObserver;

        StreamObserver<StoreInfo> responseObserver = new StreamObserver<StoreInfo>() {
            @Override
            public void onNext(StoreInfo storeInfo) {
                storeInfoMap.put("nm", storeInfo.getNm());
                storeInfoMap.put("addr", storeInfo.getAddr());
            }

            @Override
            public void onError(Throwable t) {
                log.warn("Error while reading response fromServer: " + t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        };

        requestObserver = storeServiceStub.findStoreByIdBidirectional(responseObserver);
        StoreRequest request = StoreRequest.newBuilder().setId(id).build();
        requestObserver.onNext(request);
        requestObserver.onCompleted();

        boolean await = finishLatch.await(1, TimeUnit.MINUTES);

        return await ? storeInfoMap : null;
    }


}
