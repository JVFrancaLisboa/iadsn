package com.iadsn.controller;

import com.iadsn.dto.CarteirinhaMembroDTO;
import com.iadsn.dto.CarteirinhaMinistroDTO;
import com.iadsn.dto.enums.TipoCarteirinha;
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

        if(dto.getTipo() == TipoCarteirinha.MEMBRO){
            return "membro_carteirinha";
        }

        if(dto.getTipo() == TipoCarteirinha.MINISTRO){
            return "ministro_carteirinha";
        }

        if(dto.getTipo() == TipoCarteirinha.MISSIONARIO){
            return "missionario_carteirinha";
        }

        return null;
    }

    @GetMapping("/membrodto")
    public String  getCapturaMembroDto(Model model){
        model.addAttribute("dto", new CarteirinhaMembroDTO());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/captura-membrodto :: content";
    }

//    @GetMapping("/ministrodto")
//    public String getCapturaMinistroDto(Model model){
//        model.addAttribute("dto", )
//        return null;
//    }
}
