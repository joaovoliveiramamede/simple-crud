package com.simplecrud.backend.domain.exception;

public class UserInternalError extends RuntimeException{
    public UserInternalError(String message, Throwable error){
        super(message, error);
    }
    public UserInternalError(String message){
        super(message);
    }
}
