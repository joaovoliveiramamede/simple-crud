package com.simplecrud.backend.domain.exception;

public class ProviderInternalErrorException extends RuntimeException {
    public ProviderInternalErrorException(String message, Throwable error) {
        super(message, error);
    }
    public ProviderInternalErrorException(String message) {
        super(message);
    }
}