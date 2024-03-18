package io.github.danilochaves.msproposta.listener;

import io.github.danilochaves.msproposta.mapper.PropostaMapper;
import io.github.danilochaves.msproposta.models.Proposta;
import io.github.danilochaves.msproposta.repositories.PropostaRepository;
import io.github.danilochaves.msproposta.services.WebSocketService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    private final PropostaRepository repository;

    private final WebSocketService webSocketService;

    public PropostaConcluidaListener(PropostaRepository repository, WebSocketService webSocketService) {
        this.repository = repository;
        this.webSocketService = webSocketService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.proposta-conluida.app-proposta}")
    public void propostaConcluida(Proposta proposta){
        repository.save(proposta);
//        webSocketService.notificar(PropostaMapper.INSTANCE.mapEntityToDto(proposta));
    }
}
