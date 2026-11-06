package de.dhbw.lecture01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumberTest2 {

    @Test
    void givenRomanNumberIIX_thenGetValue_returnIntValue8() {

        int value = RomanNumber.getValue("IIX");

        assertEquals(8, value);
    }

    @Test
    void givenRomanNumberX_thenGetValue_returnIntValue10() {

        int value = RomanNumber.getValue("X");

        assertEquals(10, value);
    }

}