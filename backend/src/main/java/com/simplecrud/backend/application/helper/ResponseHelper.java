package com.simplecrud.backend.application.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.simplecrud.backend.domain.model.AddressModel;
import com.simplecrud.backend.domain.model.ClientModel;
import com.simplecrud.backend.domain.model.UserModel;
import com.simplecrud.backend.domain.model.request.CreateAddressRequest;
import com.simplecrud.backend.domain.model.request.CreateClienteRequest;
import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.AddressResponse;
import com.simplecrud.backend.domain.model.response.ClientResponse;
import com.simplecrud.backend.domain.model.response.UserResponse;

@Component
public class ResponseHelper {

    private static final ModelMapper mapper = new ModelMapper();
    
    public ClientResponse createClientResponseWithAddressAndUser(ClientResponse client, AddressResponse address, UserResponse user) {
        ClientResponse response = ClientResponse
            .builder()
            .firstName(client.getFirstName())
            .lastName(client.getLastName())
            .build();

        return response;
    }

    public AddressModel createAddressModelWithOutClient(CreateAddressRequest address) {
        return AddressModel
            .builder()
            .city(address.getCity())
            .street(address.getStreet())
            .number(address.getNumber())
            .neighborhood(address.getNeighborhood())
            .zipCode(address.getZipCode())
            .build();
    }

    public List<UserResponse> convertUserEntityToUserResponse(List<UserModel> userModels) {
        return userModels.stream()
            .map(user -> mapper.map(user, UserResponse.class))
            .collect(Collectors.toList());
    }

    public Map<String, Object> convertUserResponsePage(Page<UserModel> page, List<UserResponse> users) {
        Map<String, Object> response = new HashMap<>();
        response.put("total", page.getTotalElements());
        response.put("page", page.getNumber());
        response.put("totalPage", page.getTotalPages());
        response.put("users", users);
        return response;
    }

    public UserModel convertUserCreateRequestToEntity(CreateUserRequest request) {
        return mapper.map(request, UserModel.class);
    }

    public UserResponse convertUserEntityToResponse(UserModel entity) {
        return mapper.map(entity, UserResponse.class);
    }

    public ClientModel convertClientCreateRequestEntityToResponse(CreateClienteRequest request) {
        return mapper.map(request, ClientModel.class);
    }

    public ClientResponse convertClientEntityToResponse(ClientModel entity) {
        return mapper.map(entity, ClientResponse.class);
    }
}
