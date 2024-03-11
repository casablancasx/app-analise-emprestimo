package io.github.danilochaves.msanalisecredito.listener;

import io.github.danilochaves.msanalisecredito.domain.Proposta;
import io.github.danilochaves.msanalisecredito.services.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    private final AnaliseCreditoService analiseCreditoService;



    public PropostaPendenteListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta-pendente.ms-analise-credito}")
    public void propostaPendente(Proposta proposta){
        analiseCreditoService.analisar(proposta);
    }
}
