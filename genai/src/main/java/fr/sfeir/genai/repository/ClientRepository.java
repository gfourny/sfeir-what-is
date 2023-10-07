package fr.sfeir.genai.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.sfeir.genai.model.Client;
import fr.sfeir.genai.model.Facture;

/**
 * @author gfourny
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    
    @Override
    default List<Client> findAll(){
        return List.of(
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
                        .id(1L)
                        .facture(Facture.builder()
                                .id(2L)
                                .montantTotal(44.2)
                                .numeroFacture(UUID.randomUUID().toString())
                                .build())
                        .build(),
                Client.builder()
                        .nom("sfeir")
                        .adresse("40 rue de la tour d'auvergne")
                        .id(1L)
                        .facture(Facture.builder()
                                .id(3L)
                                .montantTotal(28.9)
                                .numeroFacture(UUID.randomUUID().toString())
                                .build())
                        .build(),
                Client.builder()
                        .nom("sos")
                        .adresse("40 rue de la tour d'auvergne")
                        .id(1L)
                        .facture(Facture.builder()
                                .id(4L)
                                .montantTotal(12)
                                .numeroFacture(UUID.randomUUID().toString())
                                .build())
                        .build()
        );
    }
}
