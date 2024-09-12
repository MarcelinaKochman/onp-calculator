package com.example.demo.handlers;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

@Component
public class NumberHandler implements ONPOperationHandler {

    private static final String NUMBER_REGEXP = "-?[0-9]+";

    @Override
    public boolean matches(String symbol) {
        return symbol.matches(NUMBER_REGEXP);
    }

    @Override
    public void handle(Stack<Integer> stack, String symbol) {
        stack.push(Integer.valueOf(symbol));
    }
}
