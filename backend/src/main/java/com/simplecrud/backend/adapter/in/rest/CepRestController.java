package com.simplecrud.backend.adapter.in.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrud.backend.application.service.CepService;
import com.simplecrud.backend.domain.model.response.CepResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "cep")
public class CepRestController {

    private final CepService service;

    public CepRestController(
        CepService cepService
    ) {
        this.service = cepService;
    }

    @GetMapping("get/{cep}")
    public ResponseEntity<CepResponse> getByCep(@PathVariable("cep") String cep) {
        CepResponse response = this.service.getByCep(cep);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
