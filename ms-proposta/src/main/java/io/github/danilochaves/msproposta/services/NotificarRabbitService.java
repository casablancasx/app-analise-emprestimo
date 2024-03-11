package io.github.danilochaves.msproposta.services;

import io.github.danilochaves.msproposta.models.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificarRabbitService {

    private RabbitTemplate rabbitTemplate;

    public NotificarRabbitService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${rabbitmq.exchange.proposta-pendent}")
    private String exchangePropostaPendente;

    public void notificar(Proposta proposta){
        rabbitTemplate.convertAndSend(exchangePropostaPendente, "", proposta);
    }

}
