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
        Cliente cliente = clienteRepository.updateValor(id, dtoRequest.valor()); //TODO garantir que ambas as transações ocorram para commitar?
        transacaoRepository.save(
                Transacao
                        .builder()
                        .idCliente(id)
                        .realizadaEm(LocalDateTime.now())
                        .descricao(dtoRequest.descricao())
                        .tipo(dtoRequest.tipo())
                        .valor(dtoRequest.valor())
                        .build()
        );
        return cliente;

    }

    public Cliente executeDebitOperation(TransacaoDTORequest dtoRequest, Integer id) {

    }
}
