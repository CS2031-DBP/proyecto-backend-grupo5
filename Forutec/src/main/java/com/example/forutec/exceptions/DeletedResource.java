package com.example.forutec.exceptions;

public class DeletedResource extends RuntimeException{
    public DeletedResource(String message) {
        super(message);
    }
}
