package com.orchers.rinhadebackend.service;

import com.orchers.rinhadebackend.controller.dto.response.ExtratoDTOResponse;
import com.orchers.rinhadebackend.controller.dto.response.SaldoDTOResponse;
import com.orchers.rinhadebackend.controller.dto.response.TransacaoExtratoDTOResponse;
import com.orchers.rinhadebackend.model.Cliente;
import com.orchers.rinhadebackend.model.Transacao;
import com.orchers.rinhadebackend.repository.ClienteRepository;
import com.orchers.rinhadebackend.repository.TransacaoRepository;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class ExtratoService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;

    public ExtratoService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
    }

    public ExtratoDTOResponse getExtrato(Integer id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isEmpty())
            throw new RuntimeException();

        TreeSet<Transacao> transacoes = transacaoRepository.findByIdOrderByRealizadaEm(Limit.of(10));


        return ExtratoDTOResponse.builder()
                .saldo(SaldoDTOResponse.builder()
                        .total(cliente.get().getSaldo())
                        .dataExtrato(LocalDateTime.now())
                        .limite(cliente.get().getLimite())
                        .build())
                .ultimasTransacoes(
                        transacoes.stream()
                        .map(transacao -> TransacaoExtratoDTOResponse.builder()
                                .valor(transacao.getValor())
                                .tipo(transacao.getTipo())
                                .descricao(transacao.getDescricao())
                                .realizadaEm(transacao.getRealizadaEm())
                                .build())
                        .collect(Collectors.toCollection(TreeSet::new)))
                .build();
    }
}
