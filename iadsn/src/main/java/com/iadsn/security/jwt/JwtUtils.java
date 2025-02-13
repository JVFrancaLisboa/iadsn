package com.iadsn.security.jwt;

import com.iadsn.services.ImplDadosUsuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    @Value("${projeto.jwtExpirationMs}")
    private String jwtExpirationMs;

    public String generationTokenFromUserDetailsImpl(ImplDadosUsuario userData){
        return "";
    }
}
