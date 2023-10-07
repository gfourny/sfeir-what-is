package fr.sfeir.genai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sfeir.genai.model.Client;
import fr.sfeir.genai.model.Facture;
import fr.sfeir.genai.service.ClientService;
import lombok.RequiredArgsConstructor;

/**
 * @author gfourny
 */
@RestController
@RequestMapping("/facture")
@RequiredArgsConstructor
public class SfeirController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Map<String, List<Facture>>> getFacturesByClients() {
        return new ResponseEntity<>(clientService.getFacturesByClients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> postFacture(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.postFacture(client),HttpStatus.CREATED);
    }
}
