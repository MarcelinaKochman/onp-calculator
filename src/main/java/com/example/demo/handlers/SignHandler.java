package com.example.demo.handlers;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

@Component
public class SignHandler implements ONPOperationHandler {

    private static final String SIGN_REGEXP = "[+-/x]";

    private static final Map<String, BiFunction<Integer, Integer, Integer>> SIGNS_WITH_FUNCTIONS =
            Map.of(
                    "+", Integer::sum,
                    "-", (value1, value2) -> value1 - value2,
                    "/", (value1, value2) -> value1 / value2,
                    "x", (value1, value2) -> value1 * value2
            );

    @Override
    public boolean matches(String symbol) {
        return symbol.matches(SIGN_REGEXP);
    }

    @Override
    public void handle(Stack<Integer> stack, String symbol) {
        Integer symbolA = stack.pop();
        Integer symbolB = stack.pop();

        Integer calculatedValue = SIGNS_WITH_FUNCTIONS.get(symbol).apply(symbolB, symbolA);
        stack.push(calculatedValue);
    }
}
