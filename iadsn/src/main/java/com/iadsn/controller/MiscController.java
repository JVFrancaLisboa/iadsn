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
        return "fragments/movimentacoes :: content";
    }

    @GetMapping("/membros")
    public String membros() {
        return "fragments/membros :: content";
    }
}
