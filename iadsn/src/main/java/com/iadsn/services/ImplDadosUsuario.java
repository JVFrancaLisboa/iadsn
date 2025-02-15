package com.iadsn.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class ImplDadosUsuario implements UserDetails {

    private Long id;
    private String nome;
    private String username;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> autorizacoes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
