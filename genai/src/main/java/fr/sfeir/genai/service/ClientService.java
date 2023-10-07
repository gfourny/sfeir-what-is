package fr.sfeir.genai.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import fr.sfeir.genai.model.Client;
import fr.sfeir.genai.model.Facture;
import fr.sfeir.genai.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

/**
 * @author gfourny
 */
@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;
    
    public Map<String, List<Facture>> getFacturesByClients(){
        List<Client> clients = StreamSupport.stream(clientRepository.findAll().spliterator(), false)
                .toList();
        
        return clients.stream()
                .collect(Collectors.groupingBy(Client::getNom,
                        Collectors.mapping(Client::getFacture, Collectors.toList()))
                );
    }
}
