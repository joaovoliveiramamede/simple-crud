package com.simplecrud.backend.domain.exception;

public class UserNotFoundError extends RuntimeException{
    public UserNotFoundError(String message, Throwable error){
        super(message, error);
    }
    
}
