package com.iadsn.entities;

import com.iadsn.domain.MovimentacaoFinanceira;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "dizimos")
public class DizimoEntity implements MovimentacaoFinanceira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "membro_id") // 'membro_id' definido como chave secundária no bd
    private MembroEntity membro; // Membro que está efetuando o dizimo
    //@NotBlank(message = "Por favor preencha o campo 'Data'")
    private LocalDate data;
    @PositiveOrZero(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @Override
    public String getNome() {
        return membro != null ? membro.getNome() : "Anônimo";
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}