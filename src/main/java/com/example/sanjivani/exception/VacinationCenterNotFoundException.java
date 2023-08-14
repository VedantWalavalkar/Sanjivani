package com.example.sanjivani.exception;

public class VacinationCenterNotFoundException extends RuntimeException{
    public VacinationCenterNotFoundException(String message){
        super(message);
    }
}
