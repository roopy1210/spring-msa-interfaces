package com.roopy.store.controller;

import com.roopy.proto.StoreResponse;
import com.roopy.store.dto.StoreDTO;
import com.roopy.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/stores")
    public Map<String,Object> findStores(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody HashMap<String,Object> param) throws InterruptedException {

        ArrayList radius = new ArrayList(Arrays.asList(500,600,700,800,900,1000,1100,1200,1300,1400));
        int index = Integer.parseInt(RandomStringUtils.randomNumeric(1));

        String inqryType = (String) param.get("type");

        StoreDTO storeRequest = StoreDTO.builder()
                .lat((Double) param.get("lat"))
                .lot((Double) param.get("lot"))
                .radius((Integer) radius.get(index))
                .build();

        // 매장 검색
        Map<String,Object> storeResponse;

        if ("U".equals(inqryType)) {
            storeResponse = storeService.findStoresByPointWithRadiusUnary(storeRequest);
        }
        else {
            storeResponse= storeService.findStoresByPointWithRadiusBidirectional(storeRequest);
        }

        // 매장 검색결과
        Map<String,Object> retObj = new HashMap<>();

        StoreResponse storeData = (StoreResponse) storeResponse.get("data");

        // 매장검색 결과목록
        if (storeData.getStoreInfosCount() > 0) {
            List<StoreDTO> stores = new ArrayList<>();
            storeData.getStoreInfosList().forEach(store -> stores.add(StoreDTO.builder().id(store.getId())
                    .nm(store.getNm())
                    .addr(store.getAddr())
                    .lat(store.getLat())
                    .lot(store.getLot())
                    .dtnc(store.getDtnc())
                    .build()));

            retObj.put("data", stores);
        }

        retObj.put("totalCount", storeData.getStoreInfosCount());

        return retObj;
    }

    @PostMapping(value = "/stores/{id}")
    public Map<String,Object> findStore(HttpServletRequest request, HttpServletResponse response,
                            @PathVariable int id) throws InterruptedException {

        Map<String,Object> store = storeService.findStoreById(id);

        return store;
    }
}
