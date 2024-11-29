package com.simplecrud.backend.application.service;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.in.UserCommand;
import com.simplecrud.backend.domain.exception.UserInternalError;
import com.simplecrud.backend.domain.model.dto.UserCreateRequest;
import com.simplecrud.backend.domain.model.dto.UserResponse;

@Service
public class UserService implements UserCommand{

    @Override
    public UserResponse create(UserCreateRequest request) throws UserInternalError {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    
}
