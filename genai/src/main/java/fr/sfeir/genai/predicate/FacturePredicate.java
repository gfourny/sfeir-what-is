package fr.sfeir.genai.predicate;

import java.util.function.Predicate;

import fr.sfeir.genai.model.Facture;

/**
 * @author gfourny
 */
public class FacturePredicate {
    
    private FacturePredicate(){}
    
    public static Predicate<Facture> filteredFacture(int amount, String prefix){
        return isMoreThanAmount(amount).and(isStartWithFactureNumber(prefix));
    }
    
    private static Predicate<Facture> isMoreThanAmount(int amount){
        return facture -> facture.getMontantTotal() > amount;
    }
    
    private static Predicate<Facture> isStartWithFactureNumber(String prefix){
        return facture -> facture.getNumeroFacture().startsWith(prefix);
    }
}
