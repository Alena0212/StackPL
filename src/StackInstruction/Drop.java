package StackInstruction;

import java.util.Stack;

public class Drop implements StackInstruction {
    public Drop() {};
    @Override
    public void execute(Stack<Integer> s) {
        s.pop();
    }
}
