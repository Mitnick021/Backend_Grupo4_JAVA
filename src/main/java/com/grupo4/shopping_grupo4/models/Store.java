package com.grupo4.shopping_grupo4.models;

import org.springframework.data.annotation.Id;

public class Store {

    @Id
    private String storename;
    private String detail;
    private String adress;
    private Integer idcliente;

    public Store(String storename, String detail, String adress, Integer idcliente) {
        this.storename = storename;
        this.detail = detail;
        this.adress = adress;
        this.idcliente = idcliente;
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

    public Integer getIdcliente() {return idcliente;}

    public void setIdcliente(Integer idcliente) {this.idcliente = idcliente;}
}
