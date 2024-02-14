package com.orchers.rinhadebackend.repository;

import com.orchers.rinhadebackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query("update Cliente c set c.saldo = c.saldo + :valor where c.id = :id")
    Cliente creditOperation(@Param("id") Integer id, @Param("valor") long valor);

    @Query("update Cliente c set c.saldo = c.saldo - :valor where c.id = :id")
    Cliente debitOperation(@Param("id") Integer id, @Param("valor") long valor);
}
