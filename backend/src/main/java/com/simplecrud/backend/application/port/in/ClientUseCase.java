package com.simplecrud.backend.application.port.in;

import java.util.Map;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.simplecrud.backend.domain.exception.ClienteInternalErrorException;
import com.simplecrud.backend.domain.model.request.CreateClienteRequest;
import com.simplecrud.backend.domain.model.response.ClientResponse;

public interface ClientUseCase {
    ClientResponse create(CreateClienteRequest request) throws ClienteInternalErrorException;
    Map<String, Object> list(Pageable pageable) throws ClienteInternalErrorException;
}