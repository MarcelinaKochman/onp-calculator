package com.example.demo.handlers;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Stack;

@Component
public class MaxHandler implements ONPOperationHandler {

    private static final String MAX_REGEXP = "max";

    @Override
    public boolean matches(String symbol) {
        return symbol.matches(MAX_REGEXP);
    }

    @Override
    public void handle(Stack<Integer> stack, String symbol) {
        Integer max = Collections.max(stack);
        stack.clear();
        stack.push(max);
    }
}
