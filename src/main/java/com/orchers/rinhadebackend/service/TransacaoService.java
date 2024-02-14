package com.orchers.rinhadebackend.service;

import com.orchers.rinhadebackend.model.Cliente;
import com.orchers.rinhadebackend.repository.ClienteRepository;
import com.orchers.rinhadebackend.repository.TransacaoRepository;
import org.springframework.stereotype.Component;

@Component
public class TransacaoService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public Cliente executeCreditOperation() {

    }

    public Cliente executeDebitOperation() {
    }
}
