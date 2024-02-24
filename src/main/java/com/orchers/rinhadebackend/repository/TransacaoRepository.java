package com.orchers.rinhadebackend.repository;

import com.orchers.rinhadebackend.model.Transacao;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.TreeSet;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    public TreeSet<Transacao> findByIdOrderByRealizadaEm(Limit limit);
}
