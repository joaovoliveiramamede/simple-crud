package com.simplecrud.backend.domain.exception;

public class UserTransactionalError extends RuntimeException {
    public UserTransactionalError(String message, Throwable error){
        
        super(message,error);
    }
}
