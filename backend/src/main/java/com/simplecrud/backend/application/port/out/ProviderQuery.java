package com.simplecrud.backend.application.port.out;

import java.util.Optional;

import com.simplecrud.backend.domain.exception.ProviderTransactionalErrorException;
import com.simplecrud.backend.domain.model.ProviderModel;

public interface ProviderQuery {
    Optional<ProviderModel> save(ProviderModel entity) throws ProviderTransactionalErrorException;
    Optional<ProviderModel> findById(Long id) throws ProviderTransactionalErrorException;
}