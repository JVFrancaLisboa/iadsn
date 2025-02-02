package com.iadsn.services;

import com.iadsn.domain.MovimentacaoFinanceira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    DizimoService dizimoService;
    @Autowired
    OfertaService ofertaService;
    @Autowired
    GastoService gastoService;

    public List<MovimentacaoFinanceira> getMovimentacoes(){
        List<MovimentacaoFinanceira> movimentacoes = new ArrayList<>();
        movimentacoes.addAll(dizimoService.getDizimosList());
        movimentacoes.addAll(ofertaService.getOfertasList());
        movimentacoes.addAll(gastoService.getGastoList());
        movimentacoes.sort(Comparator.comparing(MovimentacaoFinanceira::getData));

        return movimentacoes;
    }
}