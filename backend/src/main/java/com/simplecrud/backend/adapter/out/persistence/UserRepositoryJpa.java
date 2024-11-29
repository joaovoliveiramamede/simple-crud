package com.simplecrud.backend.adapter.out.persistence;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

import com.simplecrud.backend.application.port.out.UserRepository;
import com.simplecrud.backend.domain.exception.UserTransactionalError;
import com.simplecrud.backend.domain.model.UserModel;

@Service
public class UserRepositoryJpa implements UserRepository {
    private final SpringJpaUserRepository repositoryJpa;

    public UserRepositoryJpa(
            SpringJpaUserRepository springRepositoryJpa) {
        this.repositoryJpa = springRepositoryJpa;
    }

    @Override
    @Transactional
    public UserModel save(UserModel entity) throws UserTransactionalError {
        try {
            UserModel response = repositoryJpa.save(entity);
            return response;
        } catch (DataAccessException exception) {
            throw new UserTransactionalError("Error to access database", exception);
        } catch (TransactionException exception) {
            throw new UserTransactionalError("Error on transaction for database", exception);
        }
        
    }

}
