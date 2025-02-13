package com.simplecrud.backend.application.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.adapter.factory.JwtFactory;
import com.simplecrud.backend.application.port.in.AuthUseCase;
import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.mapper.UserMapper;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.AuthRequest;
import com.simplecrud.backend.domain.model.response.AuthResponse;
import com.simplecrud.backend.domain.model.response.UserResponse;

@Service
public class AuthService implements AuthUseCase {

    private UserRepository userRepository;
    private JwtFactory jwtFactory;

    public AuthService(
        UserRepository userRepository,
        JwtFactory jwtFactory
    ) {
        this.userRepository = userRepository;
        this.jwtFactory = jwtFactory;
    }

    @Override
    public AuthResponse signIn(AuthRequest request) {
        UserModel userEntity = this.userRepository.byUsername(request.getUsername());
        UserResponse findUser = UserMapper.convertEntityToResponse(userEntity);

        if(findUser == null) {
            throw new IllegalAccessError("User Invalid");
        }

        Map<String, Object> user = new HashMap<>();
        user.put("username", findUser.getUsername());
        String token = jwtFactory.createToken(user, "access by user");
    
        return AuthResponse.builder()
            .token(token)
            .expiration(token)
            .build();
    }
    


}
