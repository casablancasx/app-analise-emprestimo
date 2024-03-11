package io.github.danilochaves.msanalisecredito.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.queue.proposta-conluida.app-proposta}")
    private String filaPropostaConcluidaAppProposta;

    @Value("${rabbitmq.exchange.proposta-conluida}")
    private String exchangePropostaConcluida;
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue filaPropostaConcluidaAppProposta(){
        return QueueBuilder.durable(filaPropostaConcluidaAppProposta).build();
    }

    @Bean
    public FanoutExchange exchangePropostaConcluidaAppProposta(){
        return ExchangeBuilder.fanoutExchange(exchangePropostaConcluida).build();
    }

    @Bean
    public Binding bindingPropostaConcluidaAppProposta(){
        return BindingBuilder.bind(filaPropostaConcluidaAppProposta()).to(exchangePropostaConcluidaAppProposta());
    }
}
