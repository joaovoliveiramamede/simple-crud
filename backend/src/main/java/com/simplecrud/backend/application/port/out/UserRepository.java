package com.simplecrud.backend.application.port.out;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simplecrud.backend.domain.model.UserModel;

public interface UserRepository {
    UserModel save(UserModel entity);
    UserModel byUsername(String username);
    UserModel byId(Long id);
    Page<UserModel> list(Pageable pageable);
}
