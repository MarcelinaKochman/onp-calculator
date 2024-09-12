package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ONPCalculatorTest {

    @Autowired
    private ONPCalculator onpCalculator;

    public static Stream<Arguments> onpExpressionsWithExpected() {
        return Stream.of(
                Arguments.of("12 2 3 4 x 10 5 / + x +", 40),
                Arguments.of("5 1 2 + 4 x + 3 -", 14),
                Arguments.of("-5 abs", 5),
                Arguments.of("2 4 5 10 -5 max", 10)
        );
    }

    @ParameterizedTest
    @MethodSource("onpExpressionsWithExpected")
    void calculate(String expression, int expected) {
        assertThat(onpCalculator.calculate(expression)).isEqualTo(expected);
    }

    @Test
    void unsupportedOperationException() {
        String expression = "12 % 2";
        assertThrows(UnsupportedOperationException.class, () -> onpCalculator.calculate(expression));
    }
}