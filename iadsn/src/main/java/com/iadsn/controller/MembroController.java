package com.iadsn.controller;

import com.iadsn.entities.MembroEntity;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MembroController {

    @Autowired
    MembroService membroService;

    @GetMapping("/membros")
    public String membros(Model model) {
        model.addAttribute("membro", new MembroEntity());
        return "fragments/membros :: content";
    }

    @PostMapping("salvar-membro")
    public String salvarMembro(@ModelAttribute MembroEntity membro) {
        membroService.criarMembro(membro);
        return "home";
    }
}