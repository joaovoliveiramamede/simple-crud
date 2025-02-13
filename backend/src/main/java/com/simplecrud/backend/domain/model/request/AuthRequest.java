package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class AuthRequest implements Serializable {
    private String username;
    private String password;
}
