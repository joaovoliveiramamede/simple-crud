package com.simplecrud.backend.adapter.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.model.UserModel;

@Service
public class UserRepositoryJpa implements UserRepository {
    
    private final SpringJpaUserRepository springJpaUserRepository;

    public UserRepositoryJpa(
        SpringJpaUserRepository repositoryMongo
    ) {
        this.springJpaUserRepository = repositoryMongo;
    }

    @Override
    public UserModel save(UserModel entity) {
        return this.springJpaUserRepository.save(entity);
    }

    @Override
    public UserModel byUsername(String username) {
        return this.springJpaUserRepository.findByUsername(username);
    }

    @Override
    public UserModel byId(Long id) {
        Optional<UserModel> user = this.springJpaUserRepository.findById(id);
        System.out.println("User: " + user.get().getUsername());
        return user.get();
    }

    @Override
    public Page<UserModel> list(Pageable pageable) {
        return this.springJpaUserRepository.findAll(pageable);
    }

}
