package com.simplecrud.backend.application.port.in;

import com.simplecrud.backend.domain.exception.UserInternalError;
import com.simplecrud.backend.domain.model.dto.UserCreateRequest;
import com.simplecrud.backend.domain.model.dto.UserResponse;

public interface UserCommand {
    UserResponse create(UserCreateRequest request) throws UserInternalError;
} 
