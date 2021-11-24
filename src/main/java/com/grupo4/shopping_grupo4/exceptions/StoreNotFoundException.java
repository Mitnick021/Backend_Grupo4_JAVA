package com.grupo4.shopping_grupo4.exceptions;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(String message){
        super(message);
    }
}
