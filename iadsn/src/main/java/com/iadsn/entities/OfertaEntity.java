package com.iadsn.entities;

import com.iadsn.domain.MovimentacaoFinanceira;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Entity
@Table(name = "ofertas")
public class OfertaEntity implements MovimentacaoFinanceira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank(message = "Por favor preencha o campo 'Data'")
    private LocalDate data;
    @PositiveOrZero(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @Override
    public String getNome() {
        return "OFERTAS";
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}