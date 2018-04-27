package StackInstruction;

import java.util.Stack;

public class Rotate implements StackInstruction {
    public Rotate() {};
    @Override
    public void execute(Stack<Integer> s) {
        int c = s.pop();
        int b = s.pop();
        int a = s.pop();
        s.push(b);
        s.push(c);
        s.push(a);
    }
}
