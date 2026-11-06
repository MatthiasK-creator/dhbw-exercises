package de.dhbw.lecture09.task04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanicNumberTest {

    @ParameterizedTest
    @CsvFileSource(resources = "roman-numbers.csv", numLinesToSkip = 1)
    void toRoman_gueltigeZahlen_korrekteRoemischeZahl(int input, String expected) {

        // Arrange / Act
        String result = RomanicNumber.toRoman(input);

        // Assert
        assertEquals(expected, result);
    }

}