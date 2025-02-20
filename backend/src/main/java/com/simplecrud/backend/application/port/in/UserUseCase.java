package com.simplecrud.backend.application.port.in;

import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.UserResponse;

public interface UserUseCase {
    UserResponse create(CreateUserRequest request);
    UserResponse getByUsername(String username);
    Map<String, Object>  list(Pageable pageable);
}
