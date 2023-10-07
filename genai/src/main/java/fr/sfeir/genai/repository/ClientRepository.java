package fr.sfeir.genai.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.sfeir.genai.model.Client;

/**
 * @author gfourny
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
