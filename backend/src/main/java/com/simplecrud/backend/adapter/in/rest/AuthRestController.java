package com.simplecrud.backend.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.domain.model.request.LoginRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "auth")
public class AuthRestController {
    
    @PostMapping("login")
    public String  postMethodName(@RequestBody LoginRequest entity) {
        //TODO: process POST request
        
        return "Hello";
    }
    
    

}
