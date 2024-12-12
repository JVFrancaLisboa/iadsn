package com.iadsn.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "dizimos")
public class Dizimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "membro_id") // 'membro_id' definido como chave secundária no bd
    private Membro membro; // Membro que está efetuando o dizimo
    @NotBlank(message = "Por favor preencha o campo 'Data'")
    private Date data;
    @PositiveOrZero(message = "O valor deve ser positivo")
    private BigDecimal valor;
}
