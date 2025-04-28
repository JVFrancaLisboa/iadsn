package com.iadsn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiscControllerTest {

    @GetMapping("/")
    public String testHome() {
        return "Hello World!";
    }

    @GetMapping("/login")
    public String testLogin() {
        return "Login Page!";
    }
}