package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private Boolean isCompany;
    private String email;
    private String userId;
}
