package com.simplecrud.backend.domain.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String senha;
}
