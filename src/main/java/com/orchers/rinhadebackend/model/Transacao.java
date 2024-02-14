package com.orchers.rinhadebackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transacao")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    private Integer id;
    private Long valor;
    private Character tipo;
    private String descricao; //limitar o tamanho?
    @Column(name = "realizada_em")
    private LocalDateTime realizadaEm;
}
