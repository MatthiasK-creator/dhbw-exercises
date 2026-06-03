package de.dhbw.lecture09.task04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Denken Sie bitte daran, dass es um TDD und damit die Herangehensweise geht und die Logik nicht primär im Fokus steht.
 */
public class RomanicNumber {
    private static final Map<Integer, String> ROMAN_NUMERALS = new LinkedHashMap<>();

    static {
        ROMAN_NUMERALS.put(1000, "M");
        ROMAN_NUMERALS.put(900, "CM");
        ROMAN_NUMERALS.put(500, "D");
        ROMAN_NUMERALS.put(400, "CD");
        ROMAN_NUMERALS.put(100, "C");
        ROMAN_NUMERALS.put(90, "XC");
        ROMAN_NUMERALS.put(50, "L");
        ROMAN_NUMERALS.put(40, "XL");
        ROMAN_NUMERALS.put(10, "X");
        ROMAN_NUMERALS.put(9, "IX");
        ROMAN_NUMERALS.put(5, "V");
        ROMAN_NUMERALS.put(4, "IV");
        ROMAN_NUMERALS.put(1, "I");
    }

    public static String toRoman(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException("Zahl darf nicht null sein");
        }

        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Römische Zahlen unterstützen nur Werte von 1 bis 3999");
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry : ROMAN_NUMERALS.entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }

        return result.toString();
    }


}
