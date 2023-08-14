package com.example.sanjivani.exception;

public class personNotFound extends RuntimeException{
    public personNotFound(String message){
        super(message);
    }
}
