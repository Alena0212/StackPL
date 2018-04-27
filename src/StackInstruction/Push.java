package StackInstruction;

import java.util.Stack;

public class Push implements StackInstruction {
    Integer val;

    public Push(int n) {
        val = n;
    };

    @Override
    public void execute(Stack<Integer> s) {
        s.push(val);
    }
}
