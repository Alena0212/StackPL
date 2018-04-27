import java.io.*;
import java.util.*;

public class Parser {
    private String[] tokens;
    private static String[] instructions;
    static {
        instructions = new String[]{"+", "-", "*", "/", "<", "drop", "dup", "swap", "rot", "print"};
        Arrays.sort(instructions);
    }

    private static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Parser(String fileName) {
        String line = "";
        String input = "";
        BufferedReader in = null;
        try {
            if (fileName == null) in = new BufferedReader(new InputStreamReader(System.in));
            else in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            while ((line = in.readLine()) != null) {
                input +=  line + " ";
            }
            tokens = input.split("\\s+");
        }
        catch (IOException e){
            System.err.println(e.toString());
        }
        finally{
            try {
                if (null != in) {
                    in.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public void parse() /*throws Exception*/{
        int braceFlag = 0;
        try {
            for (String tok : tokens) {
                if (braceFlag < 0) {
                    throw new Exception("Loop braces mismatch");
                }
                if (tok.equals("[")) {
                    braceFlag++;
                    continue;
                }
                if (tok.equals("]")) {
                    braceFlag--;
                    continue;
                }
                if ((Arrays.binarySearch(instructions, tok) < 0) && !isInt(tok)) {
                    throw new Exception("Unknown identifier");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace(System.err);
        };
    }

    public String[] getTokens() {
        return tokens;
    }
}
