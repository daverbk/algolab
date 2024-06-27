package com.studies.practice.calculator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicCalculatorTest {
    BasicCalculator calculator = new BasicCalculator();

    @Test
    void addBToA_aAndBSumReturned() {
        BigDecimal a = new BigDecimal(2), b = new BigDecimal(2);
        BigDecimal expected = new BigDecimal(4);
        assertEquals(expected, calculator.add(a, b),
                "Add operation returns an incorrect result for " + a + " + " + b);
    }

    @Test
    void subtractAFromB_aAndBDifferenceReturned() {
        BigDecimal a = new BigDecimal(2), b = new BigDecimal(2);
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, calculator.subtract(a, b),
                "Subtract operation returns an incorrect result for " + a + " - " + b);
    }

    @Test
    void multiplyAByB_aAndBProductReturned() {
        BigDecimal a = new BigDecimal(2), b = new BigDecimal(6);
        BigDecimal expected = new BigDecimal(12);
        assertEquals(expected, calculator.multiply(a, b),
                "Multiply operation returns an incorrect result for " + a + " * " + b);
    }

    @Test
    void divideAAndB_aAndBQuotientReturned() {
        BigDecimal a = new BigDecimal(6), b = new BigDecimal(2);
        BigDecimal expected = new BigDecimal(3);
        assertEquals(expected, calculator.divide(a, b),
                "Divide operation returns an incorrect result for " + a + " / " + b);
    }

    @Test
    void divideAByZero_arithmeticExceptionIsThrown() {
        BigDecimal a = new BigDecimal(2), b = new BigDecimal(0);
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b),
                "Arithmetic exception is not thrown when trying to divide by zero");
    }
}
