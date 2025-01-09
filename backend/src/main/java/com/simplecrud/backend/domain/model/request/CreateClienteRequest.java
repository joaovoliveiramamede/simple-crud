package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String document;
    private Boolean isCompany;
    private String email;
    private String username;
}
