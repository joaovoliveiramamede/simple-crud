package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class CreateAddressRequest implements Serializable {
    private String street;
    private String neighborhood;
    private String number;
    private String city;
    private String zipCode;
}
