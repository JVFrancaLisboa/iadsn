package com.iadsn.controller.api;

import com.iadsn.entities.MembroEntity;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("membros_api")
public class MembroControllerApi {

    @Autowired
    MembroService membroService;

    @GetMapping("pesquisar/{id}")
    public ResponseEntity<MembroEntity> procurarMembro(@PathVariable(value = "id") Long id){
        MembroEntity membro = membroService.getMembroId(id);
        return new ResponseEntity<>(membro, HttpStatus.OK);
    }
}
