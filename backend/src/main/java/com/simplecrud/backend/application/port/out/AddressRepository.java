package com.simplecrud.backend.application.port.out;

import com.simplecrud.backend.domain.model.AddressModel;

public interface AddressRepository {
    AddressModel save(AddressModel entity);
}
