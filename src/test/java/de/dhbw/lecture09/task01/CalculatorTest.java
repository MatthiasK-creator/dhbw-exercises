package de.dhbw.lecture09.task01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void add_zweiPositiveZahlen_summeWirdBerechnet() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.add(3, 5);

        // Assert
        assertEquals(8, result);
    }

    @Test
    void subtract_zweiPositiveZahlen_differenzWirdBerechnet() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.subtract(10, 4);

        // Assert
        assertEquals(6, result);
    }

    @Test
    void multiply_zweiPositiveZahlen_produktWirdBerechnet() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.multiply(3, 4);

        // Assert
        assertEquals(12, result);
    }

    @Test
    void divide_zweiPositiveZahlen_quotientWirdBerechnet() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.divide(12, 3);

        // Assert
        assertEquals(4, result);
    }

    @Test
    void divide_divisorIstNull_arithmeticExceptionWirdGeworfen() {
        // Arrange
        Calculator calculator = new Calculator();

        // Act + Assert
        assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }
}