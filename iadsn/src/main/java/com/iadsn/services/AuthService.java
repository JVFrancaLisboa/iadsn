package com.iadsn.services;

import com.iadsn.dto.AcessDTO;
import com.iadsn.dto.AuthenticationDTO;
import com.iadsn.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDTO){
        try{
            // Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDTO.getLogin(), authDTO.getPassword());

            // Prepara mecanismo para autenticação
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Busca usuário logado
            UserDetailImpl userAuthenticate = (UserDetailImpl) authentication.getPrincipal();

            String token = jwtUtils.generationTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO acessDTO = new AcessDTO(token);

            return acessDTO;
        }catch(BadCredentialsException e){
            e.printStackTrace();
            // TODO login ou senha inválido
        }
        return null;
    }
}
