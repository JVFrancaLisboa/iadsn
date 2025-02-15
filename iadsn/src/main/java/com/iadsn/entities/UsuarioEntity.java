package com.iadsn.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    private Long id;
    private String nome;
    private String username;
    private String email;
    private String password;
}
