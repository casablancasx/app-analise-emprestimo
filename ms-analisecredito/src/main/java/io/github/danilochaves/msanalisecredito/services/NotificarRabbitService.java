package io.github.danilochaves.msanalisecredito.services;



import io.github.danilochaves.msanalisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificarRabbitService {
    @Value("${rabbitmq.exchange.proposta-conluida}")
    private String exchangePropostaConcluida;

    private final RabbitTemplate rabbitTemplate;
    public NotificarRabbitService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void notificar(Proposta proposta){
        rabbitTemplate.convertAndSend(exchangePropostaConcluida, "", proposta);
    }


}
