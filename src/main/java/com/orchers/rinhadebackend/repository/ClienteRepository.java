package com.orchers.rinhadebackend.repository;

import com.orchers.rinhadebackend.model.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Modifying
    @Transactional
    @Query("update Cliente c set c.saldo = c.saldo + :valor where c.id = :id")
    void creditOperation(@Param("id") Integer id, @Param("valor") long valor);

    @Modifying
    @Transactional
    @Query("update Cliente c set c.saldo = c.saldo - :valor where c.id = :id")
    void debitOperation(@Param("id") Integer id, @Param("valor") long valor);
}
