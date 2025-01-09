package com.simplecrud.backend.application.port.in;

import com.simplecrud.backend.domain.model.response.CepResponse;

public interface CepUseCase {
    public CepResponse getByCep(String cep);
}
