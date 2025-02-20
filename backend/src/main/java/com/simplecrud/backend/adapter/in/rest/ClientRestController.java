package com.simplecrud.backend.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.port.in.ClientUseCase;
import com.simplecrud.backend.application.service.ClientService;
import com.simplecrud.backend.domain.model.request.CreateClienteRequest;
import com.simplecrud.backend.domain.model.response.ClientResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "client")
@Tag(name = "Clients", description = "Rest API for clients")
public class ClientRestController {

    private final ClientUseCase useCase;

    public ClientRestController(
        ClientService clientService
    ) {
        this.useCase = clientService;
    }
    
    @Operation(summary = "Create a new client")
    @PostMapping("create")
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody CreateClienteRequest request) throws Exception {
        ClientResponse response = this.useCase.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    

}
