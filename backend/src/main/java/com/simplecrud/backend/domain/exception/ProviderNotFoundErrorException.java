package com.simplecrud.backend.domain.exception;

public class ProviderNotFoundErrorException extends RuntimeException {
    public ProviderNotFoundErrorException(String message, Throwable error) {
        super(message, error);
    }
    public ProviderNotFoundErrorException(String message) {
        super(message);
    }
}
