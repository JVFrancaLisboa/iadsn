package com.iadsn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "gastos")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Justifique o gasto")
    private String descricao;
    @PositiveOrZero(message = "O valor deve ser positivo")
    private BigDecimal valor;
    @Lob
    @Column(name = "nota_fiscal")
    private byte[] notaFiscal;
}