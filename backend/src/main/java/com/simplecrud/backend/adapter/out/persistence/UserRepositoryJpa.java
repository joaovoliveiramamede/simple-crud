package com.simplecrud.backend.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.model.UserModel;

@Service
public class UserRepositoryJpa implements UserRepository {
    
    private final SpringJpaUserRepository springMongoUserRepository;

    public UserRepositoryJpa(
        SpringJpaUserRepository repositoryMongo
    ) {
        this.springMongoUserRepository = repositoryMongo;
    }

    @Override
    public UserModel save(UserModel entity) {
        return this.springMongoUserRepository.save(entity);
    }

    @Override
    public UserModel byUsername(String username) {
        return this.springMongoUserRepository.findByUsername(username);
    }

    @Override
    public UserModel byId(Long id) {
        Optional<UserModel> user = this.springMongoUserRepository.findById(id);
        System.out.println("User: " + user.get().getUsername());
        return user.get();
    }

}
