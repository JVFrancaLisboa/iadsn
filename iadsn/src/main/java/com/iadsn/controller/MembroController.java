package com.iadsn.controller;

import com.iadsn.entities.MembroEntity;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros_api")
public class MembroController {

    @Autowired
    MembroService membroService;

    @PostMapping("/salvar")
    public ResponseEntity<MembroEntity> salvarMembro(@RequestBody MembroEntity membro){
        var membroCriado = membroService.criarMembro(membro);
        return new ResponseEntity<>(membroCriado, HttpStatus.OK);
    }
}