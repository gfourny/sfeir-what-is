package fr.sfeir.genai.predicate;

import java.util.function.Predicate;

import fr.sfeir.genai.model.Facture;

/**
 * @author gfourny
 */
public class FacturePredicate {

    private FacturePredicate() {
    }

    public static Predicate<Facture> filteredFacture(int amount, String prefix) {
        return isMoreThanAmount(amount).and(isStartWithFactureNumber(prefix));
    }

    private static Predicate<Facture> isMoreThanAmount(int amount) {
        return facture -> facture.getMontantTotal() > amount;
    }

    private static Predicate<Facture> isStartWithFactureNumber(String prefix) {
        return isPrefixEmpty(prefix).or(startWithPrefix(prefix));
    }

    private static Predicate<Facture> isPrefixEmpty(String prefix) {
        return facture -> prefix == null || prefix.isEmpty();
    }

    private static Predicate<Facture> startWithPrefix(String prefix) {
        return facture -> facture.getNumeroFacture().startsWith(prefix);
    }
}
