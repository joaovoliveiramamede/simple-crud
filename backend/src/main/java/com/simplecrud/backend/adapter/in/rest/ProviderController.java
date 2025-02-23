package com.simplecrud.backend.adapter.in.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.service.ProviderService;
import com.simplecrud.backend.domain.model.request.CreateProviderRequest;
import com.simplecrud.backend.domain.model.response.ProviderResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("provider")
@Tag(name = "Provider", description = "Provider REST API")
public class ProviderController {
    
    @Autowired
    private ProviderService service;

    @Operation(summary = "Create a new Provider")
    @PostMapping("create")
    public ResponseEntity<ProviderResponse> create(@Valid @RequestBody CreateProviderRequest request) {
        ProviderResponse response = this.service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PostMapping("add")
    public ResponseEntity<ProviderResponse> addClient(@RequestParam("id") Long id, @RequestParam("id_client") Long idClient) {
        ProviderResponse response = this.service.addClient(id, idClient);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

}
