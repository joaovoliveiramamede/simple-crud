package com.simplecrud.backend.adapter.in.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.service.UserService;
import com.simplecrud.backend.domain.model.dto.UserCreateRequest;
import com.simplecrud.backend.domain.model.dto.UserResponse;

@RestController
@RequestMapping(name = "user")
public class UserRestController {
    private final UserService service;
    public UserRestController(
        UserService userService
    ){
        this.service = userService;
    }
    @PostMapping("create")
    public ResponseEntity<UserResponse> create( @RequestBody UserCreateRequest request){
        UserResponse response = this.service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
