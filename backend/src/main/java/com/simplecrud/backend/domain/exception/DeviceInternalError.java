package com.simplecrud.backend.domain.exception;

public class DeviceInternalError extends RuntimeException {
    public DeviceInternalError(String message, Throwable error) {
        super(message, error);
    }
    public DeviceInternalError(String message) {
        super(message);
    }
}
