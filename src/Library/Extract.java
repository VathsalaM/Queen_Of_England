package Library;
import java.util.Set;

public class Extract {


    public static String extractCommand(String argument) {
        int beginIndex = argument.split("[^-]")[0].length();
        int endIndex = argument.length();
        String command = argument.substring(beginIndex, endIndex);
        command = command.equals("f") ? "formal" : command;
        command = command.equals("i") ? "informalName" : command;
        return command;
    }

    public static Set<String> extractCommands(Set<String> commands) {
        if(commands.contains("formal") && commands.contains("informalName"))
            commands.remove("informalName");
        if(!commands.contains("formal") && !commands.contains("informalName"))
            commands.add("formal");
        return commands;
    }
}
