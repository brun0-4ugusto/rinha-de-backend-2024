package com.orchers.rinhadebackend.controller.dto.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.TreeSet;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class ExtratoDTOResponse {
    private SaldoDTOResponse saldo;
    private List<TransacaoExtratoDTOResponse> ultimasTransacoes;
}
