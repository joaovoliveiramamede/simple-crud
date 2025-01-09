package com.simplecrud.backend.application.service;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.in.AuthUseCase;
import com.simplecrud.backend.domain.model.request.AuthRequest;
import com.simplecrud.backend.domain.model.request.LoginRequest;
import com.simplecrud.backend.domain.model.response.AuthResponse;
import com.simplecrud.backend.domain.model.response.UserResponse;

@Service
public class AuthService implements AuthUseCase {



    @Override
    public AuthResponse signIn(LoginRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'validateUser'");
    }

    @Override
    public UserResponse validateUser(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateUser'");
    }
    
}
