package com.simplecrud.backend.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.port.in.UserUseCase;
import com.simplecrud.backend.application.service.UserService;
import com.simplecrud.backend.domain.model.request.CreateUserRequest;
import com.simplecrud.backend.domain.model.response.UserResponse;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "user")
public class UserRestController {
    
    private final UserUseCase useCase;

    public UserRestController(
        UserService userService
    ) {
        this.useCase = userService;
    }

    @PostMapping("create")
    public ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest request) {
        UserResponse response = this.useCase.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @GetMapping("byUsername/{username}")
    public ResponseEntity<UserResponse> getByUsername(@PathVariable("username") String username) {
        UserResponse response = this.useCase.getByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @GetMapping("list")
    public ResponseEntity<Map<String, Object>> list(Pageable pageable) {
        Map<String, Object> response = this.useCase.list(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    


}
