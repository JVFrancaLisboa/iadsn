package com.iadsn.services;

import com.iadsn.entities.GastoEntity;
import com.iadsn.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    GastoRepository gastoRepository;

    public GastoEntity getGastoId(Long id){
        return gastoRepository.findById(id).orElse(null);
    }

    public GastoEntity atualizarGasto(Long id, GastoEntity gastoAtualizado){
        GastoEntity gasto = getGastoId(id);

        gasto.setDescricao(gastoAtualizado.getDescricao());
        gasto.setValor(gastoAtualizado.getValor());
        gasto.setNotaFiscal(gastoAtualizado.getNotaFiscal());

        return gastoRepository.save(gasto);
    }

    public List<GastoEntity> getGastoList(){
        return gastoRepository.findAll();
    }

    public GastoEntity criarGasto(GastoEntity gasto){
        gasto.setId(null);
        return gastoRepository.save(gasto);
    }

    public void deletarGasto(Long id){
        GastoEntity gasto = getGastoId(id);
        gastoRepository.deleteById(gasto.getId());
    }
}
