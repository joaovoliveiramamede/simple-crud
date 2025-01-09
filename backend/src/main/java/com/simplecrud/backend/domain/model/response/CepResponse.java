package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CepResponse implements Serializable {
    private String cep;
    private String state;
    private String neighborhood;
    private String street;
    private String service;
}
