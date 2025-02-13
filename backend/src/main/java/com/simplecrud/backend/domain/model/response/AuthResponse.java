package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class AuthResponse implements Serializable {
    private String token;
    private UserResponse user;
    private String expiration;
}
