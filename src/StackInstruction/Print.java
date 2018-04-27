package StackInstruction;

import java.util.Stack;

public class Print implements StackInstruction {
    public Print() {};
    @Override
    public void execute(Stack<Integer> s) {
        System.out.println(s.peek());
    }
}
