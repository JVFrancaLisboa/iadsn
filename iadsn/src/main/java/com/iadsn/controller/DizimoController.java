package com.iadsn.controller;

import com.iadsn.entities.DizimoEntity;
import com.iadsn.services.DizimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dizimos")
public class DizimoController {

    @Autowired
    DizimoService dizimoService;

    @PostMapping("/save-dizimo")
    public String salvarDizmo(@ModelAttribute DizimoEntity dizimo){
        dizimoService.criarDizimo(dizimo);
        return "home";
    }
}
