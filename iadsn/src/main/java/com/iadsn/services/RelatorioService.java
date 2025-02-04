package com.iadsn.services;

import com.iadsn.domain.MovimentacaoFinanceira;
import com.iadsn.dto.MovimentacaoFinanceiraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    DizimoService dizimoService;
    @Autowired
    OfertaService ofertaService;
    @Autowired
    GastoService gastoService;

    private List<MovimentacaoFinanceira> getMovimentacoes() {
        List<MovimentacaoFinanceira> movimentacoes = new ArrayList<>();
        movimentacoes.addAll(dizimoService.getDizimosList());
        movimentacoes.addAll(ofertaService.getOfertasList());
        movimentacoes.addAll(gastoService.getGastoList());
        movimentacoes.sort(Comparator.comparing(MovimentacaoFinanceira::getData));

        return movimentacoes;
    }

    public List<MovimentacaoFinanceiraDTO> getMovimentacoesDTO(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getMovimentacoes().stream()
                .map(mov -> new MovimentacaoFinanceiraDTO(mov.getNome(), mov.getData().format(formatter), mov.getValor()))
                .collect(Collectors.toList());
    }


    // Método Será depreciado quando o sistema estiver emitindo relatórios mensais.
    // Por hora ele só emite um único relátorio.
    private BigDecimal getValorTotalRalatorio(){
        return getMovimentacoesDTO().stream()
                .map(MovimentacaoFinanceiraDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Formatador de valores para BRL
    public String getValoresEmBrl(){
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formatador.format(getValorTotalRalatorio());
        return valorFormatado;
    }
}