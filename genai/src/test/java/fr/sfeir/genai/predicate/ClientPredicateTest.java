package fr.sfeir.genai.predicate;

import org.junit.jupiter.api.Test;

import fr.sfeir.genai.model.Client;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientPredicateTest {

    @Test
    public void testIsInFranceFromSfeirWhenClientIsFromFranceAndHasNameSfeirThenReturnsTrue() {
        // Arrange
        Client client = Client.builder()
                .nom("Sfeir")
                .pays("France")
                .build();

        // Act
        boolean result = ClientPredicate.isInFranceFromSfeir().test(client);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsInFranceFromSfeirWhenClientIsFromFranceButNotSfeirThenReturnsFalse() {
        // Arrange
        Client client = Client.builder()
                .nom("NotSfeir")
                .pays("France")
                .build();

        // Act
        boolean result = ClientPredicate.isInFranceFromSfeir().test(client);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsInFranceFromSfeirWhenClientIsNotFromFranceButSfeirThenReturnsFalse() {
        // Arrange
        Client client = Client.builder()
                .nom("Sfeir")
                .pays("NotFrance")
                .build();

        // Act
        boolean result = ClientPredicate.isInFranceFromSfeir().test(client);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsInFranceFromSfeirWhenClientIsNotFromFranceAndNotSfeirThenReturnsFalse() {
        // Arrange
        Client client = Client.builder()
                .nom("NotSfeir")
                .pays("NotFrance")
                .build();

        // Act
        boolean result = ClientPredicate.isInFranceFromSfeir().test(client);

        // Assert
        assertFalse(result);
    }
}