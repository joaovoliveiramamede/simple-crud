package com.simplecrud.backend.application.service;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.adapter.out.persistence.ClientRepositoryJpa;
import com.simplecrud.backend.adapter.out.persistence.UserRepositoryMongo;
import com.simplecrud.backend.application.port.in.ClientUseCase;
import com.simplecrud.backend.application.port.out.ClientRepository;
import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.exception.ClienteInternalErrorException;
import com.simplecrud.backend.domain.mapper.ClientMapper;
import com.simplecrud.backend.domain.model.ClientModel;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateClienteRequest;
import com.simplecrud.backend.domain.model.response.ClientResponse;

@Service
public class ClientService implements ClientUseCase {

    private final ClientRepository repository;
    private final UserRepository userRepository;

    public ClientService(
        ClientRepositoryJpa repositoryJpa,
        UserRepositoryMongo userRepositoryMongo
    ) {
        this.repository = repositoryJpa;
        this.userRepository = userRepositoryMongo;
    }

    @Override
    public ClientResponse create(CreateClienteRequest request) throws ClienteInternalErrorException {
        try {
            UserModel user = userRepository.byUsername(request.getUsername());
            ClientModel client = ClientMapper.convertCreateRequestToEntity(request);
            client.setUserId(user.getId());
            ClientModel response = this.repository.save(client);
            return ClientMapper.convertEntityToResponse(response);
        } catch (Exception exception) {
            throw new ClienteInternalErrorException("Erro to create client", exception);
        }
    }

    
}
