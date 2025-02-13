package com.simplecrud.backend.adapter.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.port.in.AuthUseCase;
import com.simplecrud.backend.application.service.AuthService;
import com.simplecrud.backend.domain.model.request.AuthRequest;
import com.simplecrud.backend.domain.model.response.AuthResponse;

@RestController
@RequestMapping(value = "auth")
@CrossOrigin(value = "*")
public class AuthRestController {
    
    private final AuthUseCase useCase;

    public AuthRestController(
        AuthService service 
    ) {
        this.useCase = service;
    }

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> signIn(@RequestBody AuthRequest auth) {
        AuthResponse response = this.useCase.signIn(auth);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
