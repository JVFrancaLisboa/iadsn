package com.iadsn.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.iadsn.entities.enums.Cargo;
import com.iadsn.entities.enums.Sexo;
import com.iadsn.entities.enums.StatusCivil;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "membros")
public class MembroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo não pode ser nulo")
    private String nome;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String nascimento;
    @Email(message = "insira um E-Mail válido")
    private String email;
    @CPF(message = "Insira um CPF válido")
    @NotBlank(message = "Campo não pode ser nulo")
    private String cpf;
    @NotNull(message = "Escolha o 'Sexo'")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "status_civil")
    @NotNull(message = "Escolha o 'Status Civil'")
    @Enumerated(EnumType.STRING)
    private StatusCivil statusCivil;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @NotBlank(message = "Preencha o campo Endereço")
    private String endereco;
    private String telefone;
    private boolean arquivado = false;
    @Transient //Indica que esse atributo não será persistido ao banco
    private MultipartFile multipartFile;
    @Lob
    private byte[] foto;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "membro")
    private List<DizimoEntity> dizimos = new ArrayList<>();
}