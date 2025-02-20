package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest implements Serializable {
    @Schema(description = "Email user", example = "email@example.com")
    private String email;
    @Schema(description = "Password user", example = "123456789", minLength = 6)
    private String password;
}
