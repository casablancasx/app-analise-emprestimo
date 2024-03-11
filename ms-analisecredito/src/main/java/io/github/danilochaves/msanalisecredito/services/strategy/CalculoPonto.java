package io.github.danilochaves.msanalisecredito.services.strategy;

import io.github.danilochaves.msanalisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}