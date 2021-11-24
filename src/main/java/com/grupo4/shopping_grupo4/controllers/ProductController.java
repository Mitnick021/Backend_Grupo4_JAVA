package com.grupo4.shopping_grupo4.controllers;

import com.grupo4.shopping_grupo4.exceptions.ProductNotFoundException;
import com.grupo4.shopping_grupo4.models.Product;
import com.grupo4.shopping_grupo4.respositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import com.grupo4.shopping_grupo4.exceptions.StoreNotFoundException;
import com.grupo4.shopping_grupo4.models.Store;
import com.grupo4.shopping_grupo4.respositories.StoreRepository;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    public ProductController(ProductRepository productRepository, StoreRepository storeRepository){
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @GetMapping("/")
    String checkMessage(){
        return "¡¡CONEXION EXITOSA!!";
    }

    @GetMapping("/product/{Idproduct}")
    Product getProduct(@PathVariable String Idproduct){
        return productRepository.findById(Idproduct).orElseThrow(()-> new ProductNotFoundException("No se encontro el producto"));
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products/{storename}")
    List<Product> storeProduct(@PathVariable String storename){
        Store userStore = storeRepository.findById(storename).orElse(null);

        if(userStore == null){
            throw new StoreNotFoundException("La tienda no existe");
        }

        List<Product> productStore = productRepository.findByNamestoreproduct(storename);
        return  productStore;
    }

}
