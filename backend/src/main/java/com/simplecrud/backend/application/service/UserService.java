package com.simplecrud.backend.application.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplecrud.backend.adapter.out.persistence.ClientRepositoryJpa;
import com.simplecrud.backend.adapter.out.persistence.UserRepositoryJpa;
import com.simplecrud.backend.application.port.in.UserUseCase;
import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.mapper.UserMapper;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.UserResponse;

@Service
public class UserService implements UserUseCase {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
        UserRepositoryJpa repositoryMongo,
        PasswordEncoder passwordEncoder,
        ClientRepositoryJpa clientRepositoryJpa
    ) {
        this.repository = repositoryMongo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        UserModel entity = UserMapper.convertRequestCreateToEntity(request);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        UserResponse response = UserMapper.convertEntityToResponse(this.repository.save(entity));
        return response;
    }

    @Override
    public UserResponse getByUsername(String username) {
        UserModel entity = this.repository.byUsername(username);
        UserResponse response = UserMapper.convertEntityToResponse(entity);
        return response;
    }

}
