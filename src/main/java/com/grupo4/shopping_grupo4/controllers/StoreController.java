package com.grupo4.shopping_grupo4.controllers;

import com.grupo4.shopping_grupo4.exceptions.StoreNotFoundException;
import com.grupo4.shopping_grupo4.models.Store;
import com.grupo4.shopping_grupo4.respositories.StoreRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class StoreController {
    private final StoreRepository storeRepository;

    public StoreController(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @GetMapping("/store/{storename}")
    Store getStore(@PathVariable String storename){
        return storeRepository.findById(storename).orElseThrow(()-> new StoreNotFoundException("No se encontro la tienda"));
    }

    @PostMapping("/Stores")
    Store newStore(@RequestBody Store store){
        return storeRepository.save((store));
    }
}
