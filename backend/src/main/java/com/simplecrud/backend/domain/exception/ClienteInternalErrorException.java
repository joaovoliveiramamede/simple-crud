package com.simplecrud.backend.domain.exception;

public class ClienteInternalErrorException extends RuntimeException {
    public ClienteInternalErrorException(String message, Throwable error) {
        super(message, error);
    }
    public ClienteInternalErrorException(String message) {
        super(message);
    }
}
