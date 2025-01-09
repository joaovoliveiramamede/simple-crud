package com.simplecrud.backend.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.simplecrud.backend.application.port.in.CepUseCase;
import com.simplecrud.backend.domain.model.response.CepResponse;

@Service
public class CepService implements CepUseCase {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CepResponse getByCep(String cep) {
        try {
            String url = "https://brasilapi.com.br/api/cep/v1/" + cep;
            CepResponse response = restTemplate.getForObject(url, CepResponse.class);
            return response;
        } catch (Exception e) {
            return null;
        }
    }
    
}
