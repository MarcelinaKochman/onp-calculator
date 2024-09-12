package com.example.demo.handlers;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class AbsHandler implements ONPOperationHandler {

    private static final String ABS_REGEXP = "abs";

    @Override
    public boolean matches(String symbol) {
        return symbol.matches(ABS_REGEXP);
    }

    @Override
    public void handle(Stack<Integer> stack, String symbol) {
        Integer symbolA = stack.pop();
        stack.push(-symbolA);
    }
}
