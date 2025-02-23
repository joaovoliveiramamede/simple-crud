package com.simplecrud.backend.adapter.out.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simplecrud.backend.adapter.out.persistence.spring.SpringProviderJpa;
import com.simplecrud.backend.adapter.strategy.ErrorMessageStrategy;
import com.simplecrud.backend.application.port.out.ProviderQuery;
import com.simplecrud.backend.domain.exception.ProviderNotFoundErrorException;
import com.simplecrud.backend.domain.exception.ProviderTransactionalErrorException;
import com.simplecrud.backend.domain.model.ProviderModel;

@Service
public class ProviderRepository implements ProviderQuery {

    @Autowired
    private SpringProviderJpa springProviderJpa;

    @Override
    @Transactional
    public Optional<ProviderModel> save(ProviderModel entity) throws ProviderTransactionalErrorException {
        try {
            ProviderModel response = this.springProviderJpa.save(entity);
            return Optional.of(response);
        } catch (Exception error) {
            throw new ProviderTransactionalErrorException(ErrorMessageStrategy.ERROR_TRANSACTIONAL_SAVE, error);
        }
    }

    @Override
    @Transactional
    public Optional<ProviderModel> findById(Long id) throws ProviderNotFoundErrorException, ProviderTransactionalErrorException {
        try {
            Optional<ProviderModel> response = Optional.ofNullable(this.springProviderJpa.findById(id))
                .orElseThrow(() -> new ProviderNotFoundErrorException(ErrorMessageStrategy.ERROR_NOT_FOUND_BY_ID));
            return response;
        } catch (ProviderNotFoundErrorException error) {
            throw error;
        } catch (Exception error) {
            throw new ProviderNotFoundErrorException(ErrorMessageStrategy.ERROR_TRANSACTIONAL_SAVE, error);
        }
    }
    
}