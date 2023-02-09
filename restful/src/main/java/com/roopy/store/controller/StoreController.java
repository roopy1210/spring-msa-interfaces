package com.roopy.store.controller;

import com.roopy.entity.Store3;
import com.roopy.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/{id}")
    public Store3 findStoreById(@PathVariable int id) {
        return storeService.findStoreById(id);
    }

    @PostMapping
    public List<Store3> findStoreWithPointAndRadius(@RequestBody Map<String,Object> param) {
        return storeService.findStoreWithPointAndRadius(param);
    }
}
