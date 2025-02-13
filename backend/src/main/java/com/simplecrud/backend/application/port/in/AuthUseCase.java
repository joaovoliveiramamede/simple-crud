package com.simplecrud.backend.application.port.in;

import com.simplecrud.backend.domain.model.request.AuthRequest;
import com.simplecrud.backend.domain.model.response.AuthResponse;

public interface AuthUseCase {
    AuthResponse signIn(AuthRequest request);
}
