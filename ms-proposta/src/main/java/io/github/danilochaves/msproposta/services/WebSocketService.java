package io.github.danilochaves.msproposta.services;

import io.github.danilochaves.msproposta.dto.PropostaResponseDto;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketService {

    private final SimpMessagingTemplate template;

    public WebSocketService(SimpMessagingTemplate template) {
        this.template = template;
    }

    public void notificar(PropostaResponseDto responseDto){
        template.convertAndSend("/propostas",responseDto);
    }
}
