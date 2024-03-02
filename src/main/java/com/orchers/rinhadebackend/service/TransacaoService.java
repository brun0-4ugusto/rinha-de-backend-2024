package com.orchers.rinhadebackend.service;

import com.orchers.rinhadebackend.controller.dto.request.TransacaoDTORequest;
import com.orchers.rinhadebackend.model.Cliente;
import com.orchers.rinhadebackend.model.Transacao;
import com.orchers.rinhadebackend.repository.ClienteRepository;
import com.orchers.rinhadebackend.repository.TransacaoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransacaoService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public Cliente executeCreditOperation(TransacaoDTORequest dtoRequest, Integer id) {
        clienteRepository.creditOperation(id, dtoRequest.valor()); //TODO garantir que ambas as transações ocorram para commitar?
        transacaoRepository.save(
                Transacao
                        .builder()
                        .cliente(Cliente.builder()
                                .id(id)
                                .build())
                        .realizadaEm(LocalDateTime.now())
                        .descricao(dtoRequest.descricao())
                        .tipo(dtoRequest.tipo())
                        .valor(dtoRequest.valor())
                        .build()
        );
        return clienteRepository.findById(id).orElseThrow();

    }

    public Cliente executeDebitOperation(TransacaoDTORequest dtoRequest, Integer id) {
        clienteRepository.debitOperation(id, dtoRequest.valor());

        transacaoRepository.save(getTransacao(dtoRequest, id, dtoRequest.valor()));

        return clienteRepository.findById(id).orElseThrow();
    }

    private Transacao getTransacao(TransacaoDTORequest dtoRequest, Integer id, Long valorDebitado) {
        return Transacao.builder()
                .cliente(Cliente.builder()
                        .id(id)
                        .build())
                .valor(valorDebitado)
                .tipo(dtoRequest.tipo())
                .realizadaEm(LocalDateTime.now())
                .descricao(dtoRequest.descricao())
                .build();
    }
}
