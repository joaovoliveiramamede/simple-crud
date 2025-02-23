package com.simplecrud.backend.domain.exception;

public class ProviderTransactionalErrorException  extends RuntimeException {
    public ProviderTransactionalErrorException(String message, Throwable error) {
        super(message, error);
    }
}
