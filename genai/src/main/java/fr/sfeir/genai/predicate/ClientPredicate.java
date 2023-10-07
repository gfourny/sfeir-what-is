package fr.sfeir.genai.predicate;

import java.util.Optional;
import java.util.function.Predicate;

import fr.sfeir.genai.model.Client;

/**
 * @author gfourny
 */
public class ClientPredicate {
    private static final String France = "France";
    private static final String SFEIR = "Sfeir";
    private ClientPredicate(){}
    
    public static Predicate<Client> isInFranceFromSfeir(){
        return isInFrance().and(isFromSfeir());
    }
    
    public static Predicate<Client> isInFrance(){
        return client -> Optional.ofNullable(client)
                .map(Client::getPays)
                .map(France::equals)
                .orElse(false);
    }
    
    public static Predicate<Client> isFromSfeir(){
        return client -> Optional.ofNullable(client)
                .map(Client::getNom)
                .map(SFEIR::equals)
                .orElse(false);
    }
}
