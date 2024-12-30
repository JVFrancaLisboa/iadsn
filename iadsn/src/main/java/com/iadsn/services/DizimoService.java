package com.iadsn.services;

import com.iadsn.entities.DizimoEntity;
import com.iadsn.repository.DizimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizimoService {
    @Autowired
    DizimoRepository dizimoRepository;

    public DizimoEntity getDizimoId(Long id){
        return dizimoRepository.findById(id).orElse(null);
    }

    public List<DizimoEntity> getDizimosList(){
        return dizimoRepository.findAll();
    }

    public DizimoEntity atualizarDizimo(Long id, DizimoEntity dizimoAtualizado){
        DizimoEntity dizimo = dizimoRepository.findById(id).orElse(null);
        dizimo.setMembro(dizimoAtualizado.getMembro());
        dizimo.setData(dizimoAtualizado.getData());
        dizimo.setValor(dizimoAtualizado.getValor());
        return dizimoRepository.save(dizimo);
    }
}
