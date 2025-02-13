package com.simplecrud.backend.domain.mapper;

import org.modelmapper.ModelMapper;

import com.simplecrud.backend.domain.model.ClientModel;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateClienteRequest;
import com.simplecrud.backend.domain.model.response.ClientResponse;

public class ClientMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public static ClientModel convertCreateRequestToEntity(CreateClienteRequest request) {
        return mapper.map(request, ClientModel.class);
    }

    public static ClientResponse convertRequestToEntity(ClientModel entity) {
        return mapper.map(entity, ClientResponse.class);
    }

    public static ClientResponse convertEntityToResponse(ClientModel entity) {
        return mapper.map(entity, ClientResponse.class);
    }

    public static ClientModel convertRequestToEntity(CreateClienteRequest request) {
        ClientModel client = new ClientModel();
        client.setFirstName(request.getFirstName());
        client.setLastName(request.getLastName());
        return client;
    }

    public static ClientModel convertRequestToEntityWithUser(ClientModel client, UserModel userModel) {
        ClientModel response = new ClientModel();
        response.setFirstName(client.getFirstName());
        response.setLastName(client.getLastName());
        response.setUser(userModel);
        return response;
    }

}
