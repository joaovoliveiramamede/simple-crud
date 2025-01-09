package com.simplecrud.backend.application.port.in;

import com.simplecrud.backend.domain.model.request.LoginRequest;
import com.simplecrud.backend.domain.model.response.AuthResponse;
import com.simplecrud.backend.domain.model.response.UserResponse;

public interface AuthUseCase {
    AuthResponse signIn(LoginRequest request);
    UserResponse validateUser(String username, String password);
}
