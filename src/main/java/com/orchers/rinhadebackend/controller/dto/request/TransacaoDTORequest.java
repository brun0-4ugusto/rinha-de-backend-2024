package com.orchers.rinhadebackend.controller.dto.request;

public record TransacaoDTORequest(
        Long valor,
        String tipo,
        String descricao
) {
}
