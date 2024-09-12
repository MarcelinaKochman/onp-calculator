package com.example.demo.handlers;

import java.util.Stack;

public interface ONPOperationHandler {
    boolean matches(String symbol);
    void handle(Stack<Integer> stack, String symbol);
}
