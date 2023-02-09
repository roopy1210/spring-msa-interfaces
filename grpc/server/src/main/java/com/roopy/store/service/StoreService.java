package com.roopy.store.service;

import com.google.common.collect.Lists;
import com.roopy.entity.Store2;
import com.roopy.proto.StoreInfo;
import com.roopy.proto.StoreRequest;
import com.roopy.proto.StoreResponse;
import com.roopy.proto.StoreServiceGrpc;
import com.roopy.store.repository.StoreRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@GrpcService
public class StoreService extends StoreServiceGrpc.StoreServiceImplBase {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public StreamObserver<StoreRequest> findStoreByIdBidirectional(StreamObserver<StoreInfo> responseObserver) {
        return new StreamObserver<StoreRequest>() {
            @Override
            public void onNext(StoreRequest request) {
                responseObserver.onNext(findStoreById(request));
            }

            @Override
            public void onError(Throwable t) {
                log.warn("error:{}", t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void findStoreWithPointAndRadiusUnary(StoreRequest request, StreamObserver<StoreResponse> responseObserver) {
        // 1.매장 조회
        List<Store2> store2s = findStoresByPointWithRadius(request);

        // 2.proto 규약에 맞게 데이터 설정
        StoreInfo storeInfo;
        StoreResponse response;

        List<StoreInfo> storeInfos = new ArrayList<>();
        for (Store2 store2 : store2s) {
            storeInfo = StoreInfo.newBuilder()
                    .setId(store2.getId())
                    .setNm(store2.getNm())
                    .setAddr(store2.getAddr())
                    .setLat(store2.getLat())
                    .setLot(store2.getLot())
                    .setDtnc(store2.getDtnc()).build();
            storeInfos.add(storeInfo);
        }

        // 3.응답메세지 설정
        response = StoreResponse.newBuilder().addAllStoreInfos(Lists.newArrayList(storeInfos)).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public StreamObserver<StoreRequest> findStoreWithPointAndRadiusBidirectional(StreamObserver<StoreResponse> responseObserver) {
        return new StreamObserver<StoreRequest>() {
            @Override
            public void onNext(StoreRequest request) {

                List<StoreInfo> storeInfos = new ArrayList<>();

                // 매장 조회
                List<Store2> store2s = findStoresByPointWithRadius(request);

                for (Store2 store2 : store2s) {
                    StoreInfo storeInfo = StoreInfo.newBuilder()
                            .setId(store2.getId())
                            .setNm(store2.getNm())
                            .setAddr(store2.getAddr())
                            .build();

                    storeInfos.add(storeInfo);
                }

                responseObserver.onNext(StoreResponse.newBuilder().addAllStoreInfos(Lists.newArrayList(storeInfos)).build());

            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    public List<Store2> findStoresByPointWithRadius(StoreRequest request) {
        // Set Parameter
        int radius = request.getRadius();

        return storeRepository.findStoresByPointWithRadius(request.getLat(), request.getLot(), request.getRadius());
    }

    public StoreInfo findStoreById(StoreRequest request) {

        StoreInfo retObj = null;

        Optional<Store2> inqryStore = storeRepository.findById(request.getId());
        if (inqryStore.isPresent()) {
            Store2 store2 = inqryStore.get();

            retObj = StoreInfo.newBuilder().setId(store2.getId())
                    .setNm(store2.getNm())
                    .setAddr(store2.getAddr())
                    .build();
        }

        return retObj;
    }
}
