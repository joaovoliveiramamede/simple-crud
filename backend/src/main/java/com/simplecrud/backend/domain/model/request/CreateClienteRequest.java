package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteRequest implements Serializable {
    @Schema(description = "First name of client", example = "John")
    @NotNull
    private String firstName;
    @Schema(description = "Last name of client", example = "Deer")
    @NotNull
    private String lastName;
    @Schema(description = "User associate into client", implementation = CreateUserRequest.class)
    @NotNull
    private CreateUserRequest user;
    @Schema(description = "Address about client", implementation = CreateUserRequest.class)
    private CreateAddressRequest address;
}
