package com.roopy.store.controller;

import com.roopy.entity.Store;
import com.roopy.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Store>> findStoreById(@PathVariable int id) {
        return storeService.findStoreById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Flux<Store> findStoreWithPointAndRadius(@RequestBody Map<String,Object> param) {
        return storeService.findStoreWithPointAndRadius(param);
    }
}
