package com.grupo4.shopping_grupo4.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Store {

    @Id
    private String storename;
    private String detail;
    private  String adress;
    private Integer idcliente;
    private List<Product> productos;

    public Store(String storename, String detail, String adress, Integer idcliente, List<Product> productos) {
        this.storename = storename;
        this.detail = detail;
        this.adress = adress;
        this.idcliente = idcliente;
        this.productos = productos;
    }

    public String getName() {
        return storename;
    }

    public void setName(String name) {
        this.storename = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Product> getProductos() {return productos;}

    public void setProductos(List<Product> productos) {this.productos = productos;}

    public Integer getIdcliente() {return idcliente;}

    public void setIdcliente(Integer idcliente) {this.idcliente = idcliente;}
}
