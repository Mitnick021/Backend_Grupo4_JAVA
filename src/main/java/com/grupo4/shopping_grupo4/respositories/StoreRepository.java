package com.grupo4.shopping_grupo4.respositories;

import com.grupo4.shopping_grupo4.models.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store, String>{
}
