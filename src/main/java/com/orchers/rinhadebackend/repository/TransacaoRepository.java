package com.orchers.rinhadebackend.repository;

import com.orchers.rinhadebackend.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}
