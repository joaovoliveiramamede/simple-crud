package com.simplecrud.backend.application.port.out;

import com.simplecrud.backend.domain.model.ClientModel;

public interface ClientRepository {
    ClientModel save(ClientModel entity);
}
