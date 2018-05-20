import javax.crypto.NullCipher;

public class Main {
    public static void main(String[] args) {
        Parser parser = null;
        if (args.length == 0) parser = new Parser(null);
        else parser = new Parser(args[0]);
        parser.parse();
        String[] commands = parser.getTokens();
        Executor processor = new Executor(commands);
        processor.execute();
    }
}
