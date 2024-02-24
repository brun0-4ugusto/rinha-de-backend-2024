package com.orchers.rinhadebackend.controller.dto.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class TransacaoExtratoDTOResponse {
    private Long valor;
    private String tipo;
    private String descricao;
    private LocalDateTime realizadaEm;
}
