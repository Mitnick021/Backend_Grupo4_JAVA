package com.grupo4.shopping_grupo4.controllers;

import com.grupo4.shopping_grupo4.exceptions.ProductNotFoundException;
import com.grupo4.shopping_grupo4.models.Product;
import com.grupo4.shopping_grupo4.respositories.ProductRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
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

    @DeleteMapping("/product/delete/{Idproduct}")
    String deleteProduct(@PathVariable String Idproduct){
        Product product = productRepository.findById(Idproduct).orElse(null);
        if (product == null){
            throw new ProductNotFoundException("El producto no existe");
        }

        productRepository.deleteById(Idproduct);
        return "Producto eliminado";
    }

    @PutMapping("/product/update")
    Product updateProduct(@RequestBody Product productUpd){
        Product product = productRepository.findById(productUpd.getIdproduct()).orElse(null);
        if (product == null){
            throw new ProductNotFoundException("El producto no existe");
        }
        product.setIdproduct(productUpd.getIdproduct());
        product.setNamestoreproduct(productUpd.getNamestoreproduct());
        product.setName(productUpd.getName());
        product.setPrecio(productUpd.getPrecio());
        product.setCategoria(productUpd.getCategoria());

        return productRepository.save(product);
    }

}
