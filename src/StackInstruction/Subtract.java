package StackInstruction;

import java.util.Stack;

public class Subtract implements StackInstruction {
    public Subtract() {};
    @Override
    public void execute(Stack<Integer> s) {
        int a = s.pop();
        int b = s.pop();
        s.push(b - a);
    }
}
