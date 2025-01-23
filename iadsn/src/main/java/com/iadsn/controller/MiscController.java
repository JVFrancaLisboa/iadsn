package com.iadsn.controller;

import com.iadsn.entities.OfertaEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/contrato")
    public String getContrato(){
        return "fragments/contrato";
    }

    @GetMapping("/relatorio")
    public String getRelatorio(){
        return "fragments/relatorio :: content";
    }

    @GetMapping("/carteirinhas")
    public String getCarteirinhas(){
        return "carteirinhas";
    }
}
