package com.simplecrud.backend.application.port.out;

import com.simplecrud.backend.domain.exception.DeviceTransactionalError;
import com.simplecrud.backend.domain.model.DeviceModel;

public interface DeviceRepository {
    DeviceModel save(DeviceModel device) throws DeviceTransactionalError;
}
