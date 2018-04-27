package StackInstruction;

import java.util.Stack;

public class Add implements StackInstruction {
    public Add() {};
    @Override
    public void execute(Stack<Integer> s) {
        s.push(s.pop() + s.pop());
    }
}
