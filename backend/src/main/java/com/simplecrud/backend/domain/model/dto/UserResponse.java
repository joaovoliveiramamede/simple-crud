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
public class UserResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String senha;
}
