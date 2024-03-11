package io.github.danilochaves.msanalisecredito.services;


import io.github.danilochaves.msanalisecredito.domain.Proposta;
import io.github.danilochaves.msanalisecredito.services.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Autowired
    private NotificarRabbitService notificacaoRabbitService;

    public void analisar(Proposta proposta) {
        try {
            int pontos = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovada(pontos > 350);
        } catch (RuntimeException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }
        notificacaoRabbitService.notificar( proposta);
    }
}
