package com.iadsn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

    @GetMapping("/movimentacoes")
    public String getMovs(){
        return "movs";
    }

    @GetMapping("/membros")
    public String getMembros(){
        return "membros";
    }
}
