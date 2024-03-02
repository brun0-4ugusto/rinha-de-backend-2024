package com.orchers.rinhadebackend.repository;

import com.orchers.rinhadebackend.model.Transacao;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    public LinkedList<Transacao> findByClienteIdOrderByRealizadaEmDesc(Integer clienteId, Limit limit);
}
