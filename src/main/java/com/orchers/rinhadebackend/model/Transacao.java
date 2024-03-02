package com.orchers.rinhadebackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    private Long valor;

    private String tipo;

    @Size(max = 10)
    private String descricao; //limitar o tamanho?

    @Column(name = "realizada_em")
    private LocalDateTime realizadaEm;
}
