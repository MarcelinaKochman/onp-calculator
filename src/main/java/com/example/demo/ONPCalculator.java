package com.example.demo;

import com.example.demo.handlers.ONPOperationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

@Component
@RequiredArgsConstructor
public class ONPCalculator {

    private static final String UNSUPPORTED_SYMBOL_MESSAGE = "Unsupported symbol %s";
    private static final String EXPRESSION_DELIMITER = " ";

    private final List<ONPOperationHandler> handlers;

    public int calculate(String onpExpression) {
        String[] symbols = onpExpression.split(EXPRESSION_DELIMITER);
        Stack<Integer> stack = new Stack<>();

        for (String symbol : symbols) {
            ONPOperationHandler operationHandler = handlers.stream()
                    .filter(handler -> handler.matches(symbol))
                    .findAny()
                    .orElseThrow(() -> new UnsupportedOperationException(UNSUPPORTED_SYMBOL_MESSAGE.formatted(symbol)));

            operationHandler.handle(stack, symbol);
        }

        return stack.pop();
    }

}
