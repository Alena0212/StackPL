import org.junit.*;
import static org.junit.Assert.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class Tests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Test

    public void ExecutorTest1() {
        String[] tokList = {"2", "3", "+", "print"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "5\n");
        System.setOut(System.out);
        }

        public void ExecutorTest2() {
        String[] tokList = {"5", "1", "swap", "dup", "[", "dup", "rot", "*", "swap", "1", "-", "dup", "]", "drop", "print"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "120\n");
        System.setOut(System.out);
    }

    public void ExecutorTest3() {
        String[] tokList = {"0", "1", "<", "[", "1", "print", "0", "]"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "1\n");
        System.setOut(System.out);
    }

    public void ExecutorTest4() {
        String[] tokList = {"5", "7", "dup", "rot", "dup", "rot", "1", "rot", "rot",  "<", "[", "drop",
                "swap", "drop", "0", "0", "]", "[", "drop", "0", "]", "print"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "5\n");
        System.setOut(System.out);
    }

    public void ExecutorTest5() {
        String[] tokList = {"7", "5", "dup", "rot", "dup", "rot", "1", "rot", "rot",  "<", "[", "drop",
                "swap", "drop", "0", "0", "]", "[", "drop", "0", "]", "print"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "5\n");
        System.setOut(System.out);
    }

    public void ExecutorTest6() {
        String[] tokList = {"5", "dup", "[", "print", "1", "-", "dup", "]"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "5\n4\n3\n2\n1\n");
        System.setOut(System.out);
    }

    public void ExecutorTest7() {
        String[] tokList = {"5", "dup", "[", "dup", "dup", "[", "print", "1", "-", "dup", "]", "drop", "1", "-", "dup", "]"};
        Executor exec = new Executor(tokList);
        exec.execute();
        System.setOut(new PrintStream(outContent));
        String strOutContent = new String(outContent.toByteArray(), StandardCharsets.UTF_8);
        assertEquals(strOutContent, "5\n4\n3\n2\n1\n4\n3\n2\n1\n3\n2\n1\n2\n1\n1\n");
        System.setOut(System.out);
    }
    }
