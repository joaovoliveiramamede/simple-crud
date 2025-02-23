package com.simplecrud.backend.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.out.ClientRepository;
import com.simplecrud.backend.domain.model.ClientModel;

@Service
public class ClientRepositoryJpa implements ClientRepository {

    private final SpringJpaClientRepository repository;

    public ClientRepositoryJpa(
        SpringJpaClientRepository springJpaClientRepository
    ) {
        this.repository = springJpaClientRepository;
    }

    @Override
    public ClientModel save(ClientModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Optional<ClientModel> findById(Long id) {
        ClientModel response = this.repository.getReferenceById(id);
        return Optional.of(response);
    }
    
}
