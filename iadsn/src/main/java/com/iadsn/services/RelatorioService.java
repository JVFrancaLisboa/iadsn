package com.iadsn.services;

import com.iadsn.domain.MovimentacaoFinanceira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

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

    // Método Será depreciado quando o sistema estiver emitindo relatórios mensais.
    // Por hora ele só emite um único relátorio.
    public BigDecimal getValorTotalRalatorio(){
        return getMovimentacoes().stream()
                .map(MovimentacaoFinanceira::valor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Formatador de valores para BRL
    public String getValoresEmBrl(){
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formatador.format(getValorTotalRalatorio());
        return valorFormatado;
    }
}