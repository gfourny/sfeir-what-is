package fr.sfeir.genai.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import fr.sfeir.genai.model.Client;
import lombok.RequiredArgsConstructor;

/**
 * @author gfourny
 */
@Service
@RequiredArgsConstructor
public class RabbitMQProducer {
    
    private final AmqpTemplate template;

    public void send(Client client){
        template.convertAndSend(client);
    }
}
