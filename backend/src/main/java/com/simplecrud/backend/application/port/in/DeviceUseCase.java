package com.simplecrud.backend.application.port.in;

import com.simplecrud.backend.domain.exception.DeviceInternalError;
import com.simplecrud.backend.domain.model.dto.DeviceCreateRequest;
import com.simplecrud.backend.domain.model.dto.DeviceResponse;

public interface DeviceUseCase {
    DeviceResponse create(DeviceCreateRequest request) throws DeviceInternalError;
}
