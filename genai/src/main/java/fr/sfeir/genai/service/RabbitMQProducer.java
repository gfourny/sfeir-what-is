package fr.sfeir.genai.service;

import org.springframework.stereotype.Service;

import fr.sfeir.genai.model.Client;
import lombok.RequiredArgsConstructor;

/**
 * @author gfourny
 */
@Service
@RequiredArgsConstructor
public class RabbitMQProducer {
    
    public void send(Client client) {
    }
}
