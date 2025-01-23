package com.iadsn.controller;

import com.iadsn.entities.OfertaEntity;
import com.iadsn.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

    @Autowired
    OfertaService ofertaService;

    @PostMapping("/save-oferta")
    public String salvarOferta(@ModelAttribute OfertaEntity oferta){
        ofertaService.criarOferta(oferta);
        return "home";
    }
}
