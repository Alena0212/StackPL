package StackInstruction;

import java.util.Stack;

public class Divide implements StackInstruction{
    public Divide() {};
    @Override
    public void execute(Stack<Integer> s) {
        s.push(s.pop() / s.pop());
    }
}
