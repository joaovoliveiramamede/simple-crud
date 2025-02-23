package com.simplecrud.backend.domain.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class ProviderResponse implements Serializable {
    private Long id;
    private String name;
    private String socialReason;
    private String registerNumber;
    private String service;
}
