package com.example.forutec.exceptions;

public class UniqueResourceAlreadyExist extends RuntimeException{
    public UniqueResourceAlreadyExist(String message) {
        super(message);
    }
}
