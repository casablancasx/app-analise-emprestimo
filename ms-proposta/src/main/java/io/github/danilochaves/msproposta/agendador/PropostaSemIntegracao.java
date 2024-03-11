package io.github.danilochaves.msproposta.agendador;

import io.github.danilochaves.msproposta.models.Proposta;
import io.github.danilochaves.msproposta.repositories.PropostaRepository;
import io.github.danilochaves.msproposta.services.NotificarRabbitService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class PropostaSemIntegracao {

    private final PropostaRepository propostaRepository;

    private final NotificarRabbitService notificacaoRabbitService;
    private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);


    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void buscarPropostasSemIntegracao() {
        propostaRepository.findAllByIntegradaIsFalse().forEach(proposta -> {
            try {
                notificacaoRabbitService.notificar(proposta);
                atualizarProposta(proposta);
            } catch (RuntimeException ex) {
                logger.error(ex.getMessage());
            }
        });
    }

    private void atualizarProposta(Proposta proposta) {
        proposta.setIntegrada(true);
        propostaRepository.save(proposta);
    }
}