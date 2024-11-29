package com.simplecrud.backend.application.port.out;

import com.simplecrud.backend.domain.exception.UserTransactionalError;
import com.simplecrud.backend.domain.model.UserModel;

public interface UserRepository {
    UserModel save(UserModel entity) throws UserTransactionalError;
}
