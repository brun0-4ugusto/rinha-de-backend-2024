package com.orchers.rinhadebackend.service;

import com.orchers.rinhadebackend.controller.dto.response.ExtratoDTOResponse;
import com.orchers.rinhadebackend.controller.dto.response.SaldoDTOResponse;
import com.orchers.rinhadebackend.controller.dto.response.TransacaoExtratoDTOResponse;
import com.orchers.rinhadebackend.model.Cliente;
import com.orchers.rinhadebackend.model.Transacao;
import com.orchers.rinhadebackend.repository.ClienteRepository;
import com.orchers.rinhadebackend.repository.TransacaoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ExtratoService {
    private final TransacaoRepository transacaoRepository;

    public ExtratoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public ExtratoDTOResponse getExtrato(Integer id) {
        List<Transacao> transacoes = transacaoRepository.findByClienteIdOrderByRealizadaEmDesc(id ,Limit.of(10));

        if(transacoes.isEmpty()){
            throw new RuntimeException();
        }

        return ExtratoDTOResponse.builder()
                .saldo(SaldoDTOResponse.builder()
                        .total(transacoes.get(0).getCliente().getSaldo())
                        .dataExtrato(LocalDateTime.now())
                        .limite(transacoes.get(0).getCliente().getLimite())
                        .build())
                .ultimasTransacoes(
                        transacoes.stream()
                        .map(transacao -> TransacaoExtratoDTOResponse.builder()
                                .valor(transacao.getValor())
                                .tipo(transacao.getTipo())
                                .descricao(transacao.getDescricao())
                                .realizadaEm(transacao.getRealizadaEm())
                                .build())
                        .collect(Collectors.toCollection(LinkedList::new)))
                .build();
    }
}
