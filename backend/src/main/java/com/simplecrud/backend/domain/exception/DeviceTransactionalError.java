package com.simplecrud.backend.domain.exception;

public class DeviceTransactionalError extends RuntimeException {
    public DeviceTransactionalError(String message, Throwable error) {
        super(message, error);
    }
    public DeviceTransactionalError(String message) {
        super(message);
    }
}
