package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private UserResponse user;
    private AddressResponse address;
}
