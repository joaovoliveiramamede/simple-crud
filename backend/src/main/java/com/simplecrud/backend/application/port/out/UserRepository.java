package com.simplecrud.backend.application.port.out;

import com.simplecrud.backend.domain.model.UserModel;

public interface UserRepository {
    UserModel save(UserModel entity);
    UserModel byUsername(String username);
    UserModel byId(Long id);
}
