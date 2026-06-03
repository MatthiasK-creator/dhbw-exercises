package de.dhbw.lecture09.task04;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanicNumberTest {
    @ParameterizedTest
    @CsvSource({"1, I", "4, IV", "9, IX", "42, XLII", "58, LVIII", "99, XCIX", "2024, MMXXIV", "3999, MMMCMXCIX"})
    void toRoman_gueltigeZahlen_korrekteRoemischeZahl(int input, String expected) {

        // Arrange / Act
        String result = RomanicNumber.toRoman(input);

        // Assert
        assertEquals(expected, result);
    }

}