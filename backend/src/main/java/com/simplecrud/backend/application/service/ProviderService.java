package com.simplecrud.backend.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplecrud.backend.adapter.out.persistence.ProviderRepository;
import com.simplecrud.backend.adapter.strategy.ErrorMessageStrategy;
import com.simplecrud.backend.application.helper.ProviderResponseHelper;
import com.simplecrud.backend.application.port.in.ProviderCommand;
import com.simplecrud.backend.application.port.out.ClientRepository;
import com.simplecrud.backend.domain.exception.ProviderInternalErrorException;
import com.simplecrud.backend.domain.model.ClientModel;
import com.simplecrud.backend.domain.model.ProviderModel;
import com.simplecrud.backend.domain.model.request.CreateProviderRequest;
import com.simplecrud.backend.domain.model.response.ProviderResponse;

@Service
public class ProviderService implements ProviderCommand {

    @Autowired
    private ProviderResponseHelper responseHelper;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProviderRepository repository;

    @Override
    public ProviderResponse create(CreateProviderRequest request) throws ProviderInternalErrorException {
        try {
            return Optional.ofNullable(request)
                .map(responseHelper::convertCreateRequestToEntity)
                .flatMap(repository::save)
                .map(responseHelper::convertEntityToResponse)
                .orElseThrow(() -> new ProviderInternalErrorException(ErrorMessageStrategy.ERROR_INTERNAL_CREATE));
        } catch (Exception error) {
            throw new ProviderInternalErrorException(ErrorMessageStrategy.ERROR_INTERNAL_CREATE, error);
        }
    }

    @Override
    public ProviderResponse addClient(Long id, Long idClient) throws ProviderInternalErrorException {
        try {
            ClientModel findedClient = this.clientRepository.findById(idClient)
                .orElseThrow(() -> new ProviderInternalErrorException("Cliente não encontrado"));

            ProviderModel findedProvider = this.repository.findById(id)
                    .orElseThrow(() -> new ProviderInternalErrorException("Fornecedor não encontrado"));

            findedProvider.getClients().add(findedClient);

            Optional<ProviderModel> savedProvider = this.repository.save(findedProvider);
            return responseHelper.convertEntityToResponse(savedProvider.get());
        } catch (Exception error) {
            throw new ProviderInternalErrorException(ErrorMessageStrategy.ERROR_INTERNAL_CREATE, error);
        }
    }
    


}
