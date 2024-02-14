package com.orchers.rinhadebackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "cliente")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    private Integer id;
    private Long saldo;
    private Long limite;

}
