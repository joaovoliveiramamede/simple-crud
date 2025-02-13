package com.simplecrud.backend.application.helper;

import org.springframework.stereotype.Component;

import com.simplecrud.backend.domain.model.AddressModel;
import com.simplecrud.backend.domain.model.request.CreateAddressRequest;
import com.simplecrud.backend.domain.model.response.AddressResponse;
import com.simplecrud.backend.domain.model.response.ClientResponse;
import com.simplecrud.backend.domain.model.response.UserResponse;

@Component
public class ResponseHelper {
    
    public ClientResponse createClientResponseWithAddressAndUser(ClientResponse client, AddressResponse address, UserResponse user) {
        ClientResponse response = ClientResponse
            .builder()
            .firstName(client.getFirstName())
            .lastName(client.getLastName())
            .build();
        
        if(address != null) {
            response.setAddress(address);
        }

        if(user != null) {
            response.setUser(user);
        }

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

}
