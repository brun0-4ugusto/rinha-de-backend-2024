package com.orchers.rinhadebackend.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TransacaoDTORequest(@NotBlank Long valor, @NotBlank String tipo, @NotBlank @Size(max = 10) String descricao) {
}
