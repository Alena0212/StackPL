import StackInstruction.StackInstruction;
import StackInstruction.Add;

import java.io.*;
import java.util.HashMap;

import static StackInstruction.StackInstruction.*;

public class StackInstructionFactory {
    private HashMap<String, StackInstruction> configMap;

    StackInstructionFactory(){
        configMap = new HashMap<String, StackInstruction>();
        BufferedReader configFile = null;
        InputStream resource = null;
        String line = null;
        String[] configNote = null;
        try {
            resource = this.getClass().getResourceAsStream("config.csv");
            configFile = new BufferedReader(new InputStreamReader(resource));
            //configFile = new BufferedReader(new InputStreamReader(new FileInputStream("config.csv")));

            while ((line = configFile.readLine()) != null) {
                configNote = line.split(",");
                Object instruction = new Object();
                try {
                    Class cls = Class.forName(configNote[1]);
                    try {
                        instruction = cls.getDeclaredConstructor().newInstance();
                    }
                    catch (Exception e) {
                        e.printStackTrace(System.err);
                    }
                    configMap.put(configNote[0], (StackInstruction)instruction);
                }
                catch (ClassNotFoundException e) {
                        e.printStackTrace(System.err);
                }
            }
        }
        catch (IOException e){
            System.err.println(e.toString());
        }
        /*finally{
            try {
                if (null != configFile) {
                    configFile.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }*/
    };

    public StackInstruction createInstruction(String token) {
        return configMap.get(token);
    }
}
