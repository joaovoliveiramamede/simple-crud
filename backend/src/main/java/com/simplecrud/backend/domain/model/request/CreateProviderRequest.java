package com.simplecrud.backend.domain.model.request;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data @Builder
public class CreateProviderRequest implements Serializable {
    @NotNull
    @Schema(description = "Name your company", example = "HNK ST")
    private String name;
    @NotNull
    @Schema(description = "Social Reason about your company", example = "HNK ST")
    private String socialReason;
    @NotNull
    @Schema(description = "Register Number about your company", example = "112.12123.22323/001")
    private String registerNumber;
    @NotNull
    @Schema(description = "Your service provider", example = "Building")
    private String service;
}
