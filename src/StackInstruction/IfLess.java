package StackInstruction;
import java.util.Stack;

public class IfLess implements StackInstruction {
    public IfLess() { };
    public void execute(Stack<Integer> s) {
        if (s.pop() > s.pop()) s.push(1);
        else s.push(0);
    }
}
