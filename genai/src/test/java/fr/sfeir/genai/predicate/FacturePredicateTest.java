package fr.sfeir.genai.predicate;

import org.junit.jupiter.api.Test;

import fr.sfeir.genai.model.Facture;

import static org.junit.jupiter.api.Assertions.*;

class FacturePredicateTest {

    @Test
    void testFilteredFactureWhenAmountIsGreaterThanAndStartsWithPrefixThenReturnTrue() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "FAC123");

        // Act
        boolean result = FacturePredicate.filteredFacture(500, "FAC").test(facture);

        // Assert
        assertTrue(result);
    }

    @Test
    void testFilteredFactureWhenAmountIsGreaterThanButDoesNotStartWithPrefixThenReturnFalse() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "FAC123");

        // Act
        boolean result = FacturePredicate.filteredFacture(500, "INV").test(facture);

        // Assert
        assertFalse(result);
    }

    @Test
    void testFilteredFactureWhenAmountIsLessThanAndStartsWithPrefixThenReturnFalse() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "FAC123");

        // Act
        boolean result = FacturePredicate.filteredFacture(1500, "FAC").test(facture);

        // Assert
        assertFalse(result);
    }

    @Test
    void testFilteredFactureWhenAmountIsLessThanAndDoesNotStartWithPrefixThenReturnFalse() {
        // Arrange
        Facture facture = new Facture(1L, 1000, "FAC123");

        // Act
        boolean result = FacturePredicate.filteredFacture(1500, "INV").test(facture);

        // Assert
        assertFalse(result);
    }
}