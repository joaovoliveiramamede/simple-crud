package com.simplecrud.backend.application.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplecrud.backend.adapter.out.persistence.ClientRepositoryJpa;
import com.simplecrud.backend.adapter.out.persistence.UserRepositoryJpa;
import com.simplecrud.backend.application.helper.ResponseHelper;
import com.simplecrud.backend.application.port.in.ClientUseCase;
import com.simplecrud.backend.application.port.out.AddressRepository;
import com.simplecrud.backend.application.port.out.ClientRepository;
import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.exception.ClienteInternalErrorException;
import com.simplecrud.backend.domain.mapper.ClientMapper;
import com.simplecrud.backend.domain.model.AddressModel;
import com.simplecrud.backend.domain.model.ClientModel;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateClienteRequest;
import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.ClientResponse;

@Service
public class ClientService implements ClientUseCase {

    private final ClientRepository repository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResponseHelper responseHelper;
    private final AddressRepository addressRepository;

    public ClientService(
        ClientRepositoryJpa repositoryJpa,
        UserRepositoryJpa userRepositoryJpa,
        PasswordEncoder passwordEncoder,
        ResponseHelper responseHelper,
        AddressRepository addressRepository
    ) {
        this.repository = repositoryJpa;
        this.userRepository = userRepositoryJpa;
        this.passwordEncoder = passwordEncoder;
        this.responseHelper = responseHelper;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public ClientResponse create(CreateClienteRequest request) throws ClienteInternalErrorException {
        try {

            ClientModel client = ClientMapper.convertCreateRequestToEntity(request);
            CreateUserRequest userRequest = request.getUser();

            UserModel user = new UserModel();
            user.setUsername(userRequest.getEmail());
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

            AddressModel address = this.responseHelper.createAddressModelWithOutClient(request.getAddress());
            AddressModel savedAddress = this.addressRepository.save(address);
            UserModel savedUser = this.userRepository.save(user);
            client.setUser(savedUser);
            client.setAddress(savedAddress);           
            
            client.setEmail(savedUser.getUsername());

            ClientModel savedClient = this.repository.save(client);           
            return ClientMapper.convertEntityToResponse(savedClient);
        
        } catch (Exception exception) {
            throw new ClienteInternalErrorException("Erro to create client", exception);
        }
    }

    
}
