package com.orchers.rinhadebackend.repository;

import com.orchers.rinhadebackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
