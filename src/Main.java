
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser(args[0]);
        parser.parse();
        String[] commands = parser.getTokens();
        Executor processor = new Executor(commands);
        processor.execute();
    }
}
