package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse implements Serializable {
   private String id;
   private String username;
   private String password; 
}
