package com.simplecrud.backend.domain.mapper;

import org.modelmapper.ModelMapper;

import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.dto.UserCreateRequest;
import com.simplecrud.backend.domain.model.dto.UserResponse;

public class UserMapper {
    public static final ModelMapper modelmapper = new ModelMapper();

    public static UserModel convertCreateRequestToEntity(UserCreateRequest request){
        return modelmapper.map(request, UserModel.class);
    }
    public static UserResponse convertEntityToResponse(UserModel entity){
        return modelmapper.map(entity, UserResponse.class);
    }
}
