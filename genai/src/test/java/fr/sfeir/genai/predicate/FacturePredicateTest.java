package fr.sfeir.genai.predicate;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import fr.sfeir.genai.model.Facture;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FacturePredicateTest {

    @Test
    public void testFilteredFactureWhenAmountIsGreaterThanTotalAndPrefixIsEmptyThenFactureIsFiltered() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "F123");
        int amount = 2000;
        String prefix = "";

        // Act
        Predicate<Facture> predicate = FacturePredicate.filteredFacture(amount, prefix);

        // Assert
        assertFalse(predicate.test(facture));
    }

    @Test
    public void testFilteredFactureWhenAmountIsLessThanTotalAndPrefixIsNotEmptyThenFactureIsNotFiltered() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "F123");
        int amount = 500;
        String prefix = "F";

        // Act
        Predicate<Facture> predicate = FacturePredicate.filteredFacture(amount, prefix);

        // Assert
        assertTrue(predicate.test(facture));
    }

    @Test
    public void testFilteredFactureWhenAmountIsEqualToTotalAndPrefixIsNotEmptyThenFactureIsNotFiltered() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "F123");
        int amount = 1000;
        String prefix = "F";

        // Act
        Predicate<Facture> predicate = FacturePredicate.filteredFacture(amount, prefix);

        // Assert
        assertFalse(predicate.test(facture));
    }

    @Test
    public void testFilteredFactureWhenAmountIsEqualToTotalAndPrefixIsEmptyThenFactureIsNotFiltered() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "F123");
        int amount = 1000;
        String prefix = "";

        // Act
        Predicate<Facture> predicate = FacturePredicate.filteredFacture(amount, prefix);

        // Assert
        assertFalse(predicate.test(facture));
    }

    @Test
    public void testFilteredFactureWhenAmountIsLessThanTotalAndPrefixIsEmptyThenFactureIsNotFiltered() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "F123");
        int amount = 500;
        String prefix = "";

        // Act
        Predicate<Facture> predicate = FacturePredicate.filteredFacture(amount, prefix);

        // Assert
        assertTrue(predicate.test(facture));
    }
}