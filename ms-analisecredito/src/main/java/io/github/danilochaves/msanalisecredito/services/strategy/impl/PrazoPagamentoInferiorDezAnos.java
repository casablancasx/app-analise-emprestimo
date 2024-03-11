package io.github.danilochaves.msanalisecredito.services.strategy.impl;


import io.github.danilochaves.msanalisecredito.domain.Proposta;
import io.github.danilochaves.msanalisecredito.services.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

@Component
public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() < 120 ? 80 : 0;
    }
}