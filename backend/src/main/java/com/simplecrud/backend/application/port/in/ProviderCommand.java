package com.simplecrud.backend.application.port.in;

import com.simplecrud.backend.domain.exception.ProviderInternalErrorException;
import com.simplecrud.backend.domain.exception.ProviderNotFoundErrorException;
import com.simplecrud.backend.domain.model.request.CreateProviderRequest;
import com.simplecrud.backend.domain.model.response.ProviderResponse;

public interface ProviderCommand {
    ProviderResponse create(CreateProviderRequest request) throws ProviderInternalErrorException;
    ProviderResponse addClient(Long id, Long idClient) throws ProviderNotFoundErrorException ,ProviderInternalErrorException;
}