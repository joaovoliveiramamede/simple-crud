package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class CreateAddressRequest implements Serializable {
    @Schema(description = "Street address", example = "R. Street Major")
    private String street;
    @Schema(description = "Neighborhood address", example = "Squad Four")
    private String neighborhood;
    @Schema(description = "Number address", example = "155B")
    private String number;
    @Schema(description = "City address", example = "New York")
    private String city;
    @Schema(description = "Zip Code address", example = "33500-00")
    private String zipCode;
}
