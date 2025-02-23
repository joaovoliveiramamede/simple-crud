package com.simplecrud.backend.application.helper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.simplecrud.backend.domain.model.ProviderModel;
import com.simplecrud.backend.domain.model.request.CreateProviderRequest;
import com.simplecrud.backend.domain.model.response.ProviderResponse;

@Component
public class ProviderResponseHelper {
    
    private static final ModelMapper mapper = new ModelMapper();

    public ProviderModel convertCreateRequestToEntity(CreateProviderRequest request) {
        return mapper.map(request, ProviderModel.class);
    }

    public ProviderResponse convertEntityToResponse(ProviderModel entity) {
        return mapper.map(entity, ProviderResponse.class);
    }

}
