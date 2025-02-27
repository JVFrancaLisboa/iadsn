package com.iadsn.services;

import com.iadsn.entities.OfertaEntity;
import com.iadsn.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaService {

    @Autowired
    OfertaRepository ofertaRepository;

    public OfertaEntity getOfertaId(Long id){
        return ofertaRepository.findById(id).orElse(null);
    }

    public List<OfertaEntity> getOfertasList(){
        return ofertaRepository.findAll();
    }

    public OfertaEntity criarOferta(OfertaEntity oferta){
        oferta.setId(null);
        return ofertaRepository.save(oferta);
    }

    public void deletarOferta(Long id){
        OfertaEntity oferta = getOfertaId(id);
        ofertaRepository.deleteById(oferta.getId());
    }
}
