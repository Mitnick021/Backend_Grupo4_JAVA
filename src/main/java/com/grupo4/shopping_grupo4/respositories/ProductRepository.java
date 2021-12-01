package com.grupo4.shopping_grupo4.respositories;

import com.grupo4.shopping_grupo4.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{ }
