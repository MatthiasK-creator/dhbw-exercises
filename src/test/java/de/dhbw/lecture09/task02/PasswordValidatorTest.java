package de.dhbw.lecture09.task02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest(name = "Gültiges Passwort: {0}")
    @ValueSource(strings = {
            "Password1",
            "Abcdefg1",
            "Test1234",
            "A1234567"   // genau 8 Zeichen
    })
    @DisplayName("Gültige Passwörter werden akzeptiert")
    void isValid_gueltigesPasswort_true(String password) {
        // Arrange
        PasswordValidator validator = new PasswordValidator();

        // Act
        boolean result = validator.isValid(password);

        // Assert
        assertTrue(result);
    }

    @ParameterizedTest(name = "Passwort=''{0}'' -> {1}")
    @CsvSource({
            "'', false",          // leer
            "abcdefg1, false",    // kein Großbuchstabe
            "ABCDEFGH, false",    // keine Ziffer
            "12345678, false",    // nur Ziffern
            "Abc123, false",      // zu kurz
            "abcdefgh, false",    // nur Kleinbuchstaben
            "ABCDEFG1, true"      // gültig
    })
    @DisplayName("Ungültige und Grenzfall-Passwörter werden korrekt bewertet")
    void isValid_verschiedenePasswoerter_erwartetesErgebnis(
            String password,
            boolean expected) {

        // Arrange
        PasswordValidator validator = new PasswordValidator();

        // Act
        boolean result = validator.isValid(password);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Null-Passwort löst IllegalArgumentException aus")
    void isValid_null_throwsIllegalArgumentException() {
        // Arrange
        PasswordValidator validator = new PasswordValidator();

        // Act + Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.isValid(null)
        );
    }
}