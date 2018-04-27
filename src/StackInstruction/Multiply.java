package StackInstruction;

import java.util.Stack;

public class Multiply implements StackInstruction{
    public Multiply() {};
    @Override
    public void execute(Stack<Integer> s) {
        s.push(s.pop() * s.pop());
    }
}
