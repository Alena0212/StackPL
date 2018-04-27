import StackInstruction.Push;
import StackInstruction.StackInstruction;

import java.util.Stack;

public class Executor {
    private String[] cmdList;
    private Stack<Integer> execStack;
    private StackInstructionFactory instructionFactory;

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Executor(String[] tokList) {
        execStack = new Stack<>();
        cmdList = tokList;
        instructionFactory = new StackInstructionFactory();
    }

    public Executor(String[] tokList, Stack<Integer> s) {
        execStack = s;
        cmdList = tokList;
        instructionFactory = new StackInstructionFactory();
    }

    private int loop(int indexInCmdList) {
        String[] loopCmdList;
        String sequence = "";
        int braceFlag = 1;
        int i;
        for (i = indexInCmdList + 1; braceFlag > 0; ++i) {
            if (cmdList[i].equals("[")) {
                braceFlag++;
            }
            if (cmdList[i].equals("]")) {
                braceFlag--;
            }
            sequence += cmdList[i] + " ";
        }
        sequence = sequence.substring(0, sequence.length() - 3);
        loopCmdList = sequence.split("\\s+");
        Executor loopExecutor = new Executor(loopCmdList, execStack);
        while (execStack.peek() != 0){
            execStack.pop();
            loopExecutor.execute();
        }
        execStack.pop();
        return i-1;
    }

    public void execute() {
        StackInstruction inst = null;
        for (int i = 0; i < cmdList.length; ++i) {
            if (isInt(cmdList[i])) {
                inst = new Push(Integer.parseInt(cmdList[i]));
            }
            else if (cmdList[i].equals("[")) {
                i = loop(i);
                continue;
            }
            else {
                inst = instructionFactory.createInstruction(cmdList[i]);
            }
            inst.execute(execStack);
        }
    }
}
