package com.simplecrud.backend.adapter.in.handle;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        // Verificar se a exceção é devido a violação de chave única (UNIQUE)
        if (ex.getCause() != null && ex.getCause().getMessage().contains("Duplicate entry")) {
            return new ResponseEntity<>("Erro: O nome do dispositivo já existe.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Erro de integridade de dados.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
