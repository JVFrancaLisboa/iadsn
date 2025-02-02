package com.iadsn.entities;

import com.iadsn.domain.MovimentacaoFinanceira;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "gastos")
public class GastoEntity implements MovimentacaoFinanceira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Justifique o gasto")
    private String descricao;
    private BigDecimal valor;
    @NotBlank(message = "Por favor preencha o campo 'Data'")
    private String data;
    @Transient //Indica que esse atributo não será persistido ao banco
    private MultipartFile file;
    @Lob
    @Column(name = "nota_fiscal", columnDefinition = "LONGBLOB")
    private byte[] notaFiscal;

    @Override
    public String getNome() {
        return "SAÍDA: "+descricao;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public String getData(){
        return data;
    }
}