package com.iadsn.security.jwt;


import com.iadsn.services.ImplDadosUsuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.MalformedInputException;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    @Value("${projeto.jwtExpirationMs}")
    private String jwtExpirationMs;

    public String generationTokenFromUserDetailsImpl(ImplDadosUsuario userDatail){
        return Jwts.builder().setSubject(userDatail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSigninKey(){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        }catch(MalformedJwtException e){
            e.printStackTrace();
            System.out.println("Token Inválido!");
        }catch (UnsupportedJwtException e){
            e.printStackTrace();
            System.out.println("Token não suportado!");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            System.out.println("Token argumento inválido!");
        }

        return false;
    }
}
