package com.simplecrud.backend.application.port.out;

import com.simplecrud.backend.domain.model.DeviceModel;

public interface DeviceRepository {
    void save(DeviceModel device);
}
