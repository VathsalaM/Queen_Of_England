import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Extract {
    public static HashMap<String, String> extractConditions(Set<String> commands, ArrayList<String> arguments) {
        HashMap<String ,String> conditions = new HashMap<>();
        String[] sample = new String[0];
        String[] commandArray = commands.toArray(sample);
        for(int i = 0; i < arguments.size(); i++) {
            conditions.put(commandArray[i+1],arguments.get(i));
        }
        return conditions;
    }

    public static String extractCommand(String argument) {
        int beginIndex = argument.split("[^-]")[0].length();
        int endIndex = argument.length();
        String command = argument.substring(beginIndex, endIndex);
        command = command.equals("f") ? "formal" : command;
        command = command.equals("i") ? "informal" : command;
        return command;
    }

    public static Set<String> extractCommands(Set<String> commands) {
        if(commands.contains("formal") && commands.contains("informal"))
            commands.remove("informal");
        if(!commands.contains("formal") && !commands.contains("informal"))
            commands.add("formal");
        return commands;
    }
}
