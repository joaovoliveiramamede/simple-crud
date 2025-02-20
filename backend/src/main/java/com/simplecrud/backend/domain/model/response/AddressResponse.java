package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class AddressResponse implements Serializable {
    private Long id;
    private String street;
    private String neighborhood;
    private String number;
    private String city;
    private String zipCode;
}
