package com.iadsn.controller;

import com.iadsn.dto.AuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(@RequestBody AuthenticationDTO authenticationDTO){

    }
}
