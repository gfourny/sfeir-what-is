package fr.sfeir.genai.config;

import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.sfeir.genai.model.Client;
import fr.sfeir.genai.model.Facture;
import fr.sfeir.genai.repository.ClientRepository;

/**
 * @author gfourny
 */
@Configuration
public class InitClientDatabase {

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository) {
        return args -> {
            clientRepository.saveAll(
                    List.of(
                            Client.builder()
                                    .nom("sfeir")
                                    .adresse("40 rue de la tour d'auvergne")
                                    .id(1L)
                                    .facture(Facture.builder()
                                            .id(1L)
                                            .montantTotal(131.2)
                                            .numeroFacture(UUID.randomUUID().toString())
                                            .build())
                                    .build(),
                            Client.builder()
                                    .nom("sfeir")
                                    .adresse("40 rue de la tour d'auvergne")
                                    .id(2L)
                                    .facture(Facture.builder()
                                            .id(2L)
                                            .montantTotal(44.2)
                                            .numeroFacture(UUID.randomUUID().toString())
                                            .build())
                                    .build(),
                            Client.builder()
                                    .nom("sfeir")
                                    .adresse("40 rue de la tour d'auvergne")
                                    .id(3L)
                                    .facture(Facture.builder()
                                            .id(3L)
                                            .montantTotal(28.9)
                                            .numeroFacture(UUID.randomUUID().toString())
                                            .build())
                                    .build(),
                            Client.builder()
                                    .nom("sos")
                                    .adresse("40 rue de la tour d'auvergne")
                                    .id(4L)
                                    .facture(Facture.builder()
                                            .id(4L)
                                            .montantTotal(12)
                                            .numeroFacture(UUID.randomUUID().toString())
                                            .build())
                                    .build()
                    )
            );
        };
    }
}
