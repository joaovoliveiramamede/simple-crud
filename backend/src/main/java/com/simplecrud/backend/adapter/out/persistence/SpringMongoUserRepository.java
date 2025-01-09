package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.simplecrud.backend.domain.model.UserModel;

@Repository
public interface SpringMongoUserRepository extends MongoRepository<UserModel, String> {
    UserModel findByUsername(String username);
}
