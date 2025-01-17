package com.iadsn.controller;

import com.iadsn.entities.MembroEntity;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    MembroService membroService;

    @GetMapping("/membrosInterface")
    public String membros(Model model) {
        model.addAttribute("membro", new MembroEntity());
        model.addAttribute("membrosLista", membroService.getMembrosDesarquivados());
        model.addAttribute("membrosArquivados", membroService.getMembrosArquivados());
        return "fragments/membros :: content";
    }

    @PostMapping("salvar-membro")
    public String salvarMembro(@ModelAttribute MembroEntity membro) {
        membroService.criarMembro(membro);
        return "home";
    }

    @PostMapping("deletar/{id}")
    public String deletarMembro(@PathVariable Long id){
        membroService.deletarMembro(id);
        return "home";
    }

    @PostMapping("arquivar/{id}")
    public String arquivarMembro(@PathVariable(value = "id") Long id){
        membroService.arquivarMembroId(id);
        return "home";
    }

    @PostMapping("desarquivar/{id}")
    public String desarquivarMembro(@PathVariable(value = "id") Long id){
        membroService.desarquivarMembroId(id);
        return "home";
    }
}