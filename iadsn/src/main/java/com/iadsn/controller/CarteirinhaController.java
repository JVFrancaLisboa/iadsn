package com.iadsn.controller;

import com.iadsn.dto.CarteirinhaMembroDTO;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carteirinha")
public class CarteirinhaController {

    @Autowired
    private MembroService membroService;

    @GetMapping("/tela")
    public String getCarteirinhas(@ModelAttribute CarteirinhaMembroDTO dto, Model model){
        dto.getMembro().setNascimento(dto.formatarData(dto.getMembro().getNascimento()));
        dto.setBatismoAguas(dto.formatarData(dto.getBatismoAguas()));
        dto.setBatismoEspiritoSanto(dto.formatarData(dto.getBatismoEspiritoSanto()));
        model.addAttribute("dto", dto);
        return "carteirinhas";
    }

    @GetMapping("/membrodto")
    public String  getCapturaMembroDto(Model model){
        model.addAttribute("dto", new CarteirinhaMembroDTO());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/captura-membrodto :: content";
    }
}
