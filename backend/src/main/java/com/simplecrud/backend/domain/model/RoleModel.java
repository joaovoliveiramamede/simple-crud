package com.simplecrud.backend.domain.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleModel implements Serializable {
    private String id; 
    private String name;
}
