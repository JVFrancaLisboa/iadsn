package com.iadsn.controller;

import com.iadsn.entities.DizimoEntity;
import com.iadsn.entities.OfertaEntity;
import com.iadsn.services.DizimoService;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscController {

    @Autowired
    MembroService membroService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/movimentacoes")
    public String getMovs(Model model){
        model.addAttribute("oferta", new OfertaEntity());
        model.addAttribute("dizimo", new DizimoEntity());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/movimentacoes :: content";
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
