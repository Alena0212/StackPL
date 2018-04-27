package StackInstruction;

import java.util.Stack;

public class Duplicate implements StackInstruction{
    public Duplicate() {};
    @Override
    public void execute(Stack<Integer> s) {
        int a = s.pop();
        s.push(a);
        s.push(a);
    }
}
