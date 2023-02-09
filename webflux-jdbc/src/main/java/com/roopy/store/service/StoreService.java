package com.roopy.store.service;

import com.roopy.entity.Store;
import com.roopy.store.repository.StoreRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    /**
     * 매장정보 조회
     *
     * @param id - 매장ID
     * @return Mono<Store> - 매장정보
     */
    public Mono<Store> findStoreById(int id) {
        return Mono.just(storeRepository.findById(id).get());
    }

    /**
     * 사용자의 현재위치 기준의 반경에 해당하는 매장 목록 조회
     *
     * @param param - 검색조건
     * <pre>
     *     lat - 위도
     *     lot - 경도
     *     radius - 검색 반경
     * </pre>
     * @return
     */
    public Flux<Store> findStoreWithPointAndRadius(Map<String,Object> param) {
        ArrayList radius = new ArrayList(Arrays.asList(500,600,700,800,900,1000,1100,1200,1300,1400));
        int index = Integer.parseInt(RandomStringUtils.randomNumeric(1));

        double lat = (double) param.get("lat");
        double lot = (double) param.get("lot");
        int rd = (int) radius.get(index);

        return Flux.fromIterable(storeRepository.findStoresByPointWithRadius(lat, lot, rd));
    }

}
