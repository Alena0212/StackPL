package StackInstruction;

import java.util.Stack;

public class Swap implements StackInstruction {
    public Swap() {};
    @Override
    public void execute(Stack<Integer> s) {
            int a = s.pop();
            int b = s.pop();
            s.push(a);
            s.push(b);
    }
}