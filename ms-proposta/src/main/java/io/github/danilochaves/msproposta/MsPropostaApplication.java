package io.github.danilochaves.msproposta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableScheduling
public class MsPropostaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPropostaApplication.class, args);
    }

}
