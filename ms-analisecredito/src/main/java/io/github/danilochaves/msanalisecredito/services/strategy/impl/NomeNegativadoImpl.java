package io.github.danilochaves.msanalisecredito.services.strategy.impl;


import io.github.danilochaves.msanalisecredito.domain.Proposta;
import io.github.danilochaves.msanalisecredito.services.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;


@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        if (nomeNegativado()) {
            throw new RuntimeException("NOME NEGATIVADO");
        }
        return 100;
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }
}