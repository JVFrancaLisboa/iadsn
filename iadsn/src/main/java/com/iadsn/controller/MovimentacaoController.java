package com.iadsn.controller;

import com.iadsn.entities.DizimoEntity;
import com.iadsn.entities.MembroEntity;
import com.iadsn.entities.OfertaEntity;
import com.iadsn.services.DizimoService;
import com.iadsn.services.MembroService;
import com.iadsn.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    DizimoService dizimoService;
    @Autowired
    OfertaService ofertaService;
    @Autowired
    MembroService membroService;

    // Realicionados aos Dizimos
    @PostMapping("/save-dizimo")
    public String salvarDizmo(@ModelAttribute DizimoEntity dizimo){
        dizimoService.criarDizimo(dizimo);
        return "home";
    }


    // Realicionados as Ofertas
    @PostMapping("/save-oferta")
    public String salvarOferta(@ModelAttribute OfertaEntity oferta){
        ofertaService.criarOferta(oferta);
        return "home";
    }


    // Realicionados aos Gastos
    
}
