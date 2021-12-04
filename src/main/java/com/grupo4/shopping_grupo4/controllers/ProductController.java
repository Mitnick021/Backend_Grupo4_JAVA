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

    @GetMapping("/product/{codeproduct}")
    Product getProduct(@PathVariable String codeproduct){
        return productRepository.findById(codeproduct).orElseThrow(()-> new ProductNotFoundException("No se encontro el producto"));
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping("/product/delete/{codeproduct}")
    String deleteProduct(@PathVariable String codeproduct){
        Product product = productRepository.findById(codeproduct).orElse(null);
        if (product == null){
            throw new ProductNotFoundException("El producto no existe");
        }

        productRepository.deleteById(codeproduct);
        return "Producto eliminado";
    }

    @PutMapping("/product/update")
    Product updateProduct(@RequestBody Product productUpd){
        Product product = productRepository.findById(productUpd.getCodeproduct()).orElse(null);
        if (product == null){
            throw new ProductNotFoundException("El producto no existe");
        }
        product.setCodeproduct(productUpd.getProductname());
        product.setNamestoreproduct(productUpd.getNamestoreproduct());
        product.setProductname(productUpd.getProductname());
        product.setPrecio(productUpd.getPrecio());
        product.setCategoria(productUpd.getCategoria());

        return productRepository.save(product);
    }

}
