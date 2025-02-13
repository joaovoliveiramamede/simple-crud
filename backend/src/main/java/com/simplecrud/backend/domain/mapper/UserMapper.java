package com.simplecrud.backend.domain.mapper;

import org.modelmapper.ModelMapper;

import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.UserResponse;

public class UserMapper {
    
    private static final ModelMapper mapper = new ModelMapper();

    public static UserModel convertRequestCreateToEntity(CreateUserRequest request) {
        return mapper.map(request, UserModel.class);
    }

    public static UserResponse convertEntityToResponse(UserModel entity) {
        return mapper.map(entity, UserResponse.class);
    }

}
