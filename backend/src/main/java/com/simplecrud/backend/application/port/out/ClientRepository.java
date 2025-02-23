package com.simplecrud.backend.application.port.out;

import java.util.Optional;

import com.simplecrud.backend.domain.model.ClientModel;

public interface ClientRepository {
    ClientModel save(ClientModel entity);
    Optional<ClientModel> findById(Long id);
}
