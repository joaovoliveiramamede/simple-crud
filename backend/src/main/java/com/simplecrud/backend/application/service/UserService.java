package com.simplecrud.backend.application.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplecrud.backend.adapter.out.persistence.ClientRepositoryJpa;
import com.simplecrud.backend.adapter.out.persistence.UserRepositoryJpa;
import com.simplecrud.backend.application.helper.ResponseHelper;
import com.simplecrud.backend.application.port.in.UserUseCase;
import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.UserResponse;

@Service
public class UserService implements UserUseCase {
    
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ResponseHelper responseHelper;

    public UserService(
        UserRepositoryJpa repositoryMongo,
        PasswordEncoder passwordEncoder,
        ClientRepositoryJpa clientRepositoryJpa,
        ResponseHelper responseHelper
    ) {
        this.repository = repositoryMongo;
        this.passwordEncoder = passwordEncoder;
        this.responseHelper = responseHelper;
    }

    @Override
    public UserResponse create(CreateUserRequest request) {
        UserModel entity = responseHelper.convertUserCreateRequestToEntity(request);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        UserResponse response = responseHelper.convertUserEntityToResponse(this.repository.save(entity));
        return response;
    }

    @Override
    public UserResponse getByUsername(String username) {
        UserModel entity = this.repository.byUsername(username);
        UserResponse response = responseHelper.convertUserEntityToResponse(entity);
        return response;
    }

    @Override
    public Map<String, Object> list(Pageable pageable) {
        Page<UserModel> userPage = this.repository.list(pageable);
        List<UserResponse> users = responseHelper.convertUserEntityToUserResponse(userPage.getContent());
        return responseHelper.convertUserResponsePage(userPage, users);
    }

}
