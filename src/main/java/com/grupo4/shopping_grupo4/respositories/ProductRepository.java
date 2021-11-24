package com.grupo4.shopping_grupo4.respositories;

import com.grupo4.shopping_grupo4.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductRepository extends MongoRepository<Product, String>{
    List<Product> findByNamestoreproduct(String namestoreproduct);
}
