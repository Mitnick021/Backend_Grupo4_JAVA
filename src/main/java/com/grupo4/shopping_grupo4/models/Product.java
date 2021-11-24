package com.grupo4.shopping_grupo4.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Product {

    @Id
    private String Idproduct;
    private String namestoreproduct;
    private String productname;
    private Integer precio;
    private String categoria;

    public Product(String idproduct, String namestoreproduct, String productname, Integer precio, String categoria) {
        Idproduct = idproduct;
        this.namestoreproduct = namestoreproduct;
        this.productname = productname;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getName() {
        return productname;
    }

    public void setName(String name) {
        this.productname = name;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPrecio() {return precio;}

    public void setPrecio(Integer precio) {this.precio = precio;}

    public String getIdproduct() {return Idproduct;}

    public void setIdproduct(String idproduct) {this.Idproduct = idproduct;}


    public String getNamestoreproduct() {return namestoreproduct;}

    public void setNamestoreproduct(String namestoreproduct) {this.namestoreproduct = namestoreproduct;}
}
