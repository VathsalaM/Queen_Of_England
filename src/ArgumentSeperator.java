import java.util.*;

public class ArgumentSeperator {
    private HashMap<String ,String> conditions;
    private String fileName;

    private String extractArgument(String argument) {
        int beginIndex = argument.split("[^-]")[0].length();
        int endIndex = argument.length();
        String command = argument.substring(beginIndex, endIndex);
        command = Objects.equals(command, "f") ? "formal" : command;
        command = Objects.equals(command, "i") ? "informal" : command;
        return command;
    }
    public String[] extractFeilds(String[] args) {
        Set<String> commands = new HashSet<>();
        for (String arg : args) {
            if (arg.split("[^-]").length > 0) {
                String command = extractArgument(arg);
                commands.add(command);
            }
            fileName = arg;
        }
        return toArray(commands);
    }

    private String[] toArray(Set<String> commands) {
        ArrayList<String> fields = new ArrayList<>();
        for (String command : commands) {
            fields.add(command);
        }
        fields = checkForReplacement(fields);
        String[] sample = new String[0];
        return fields.toArray(sample);
    }

    private ArrayList<String> checkForReplacement(ArrayList<String> fields) {
        fields.add(0, "prefix");
        fields.add(1, "firstName");
        fields.add(2, "lastName");
        if (fields.indexOf("informal") >= 0) {
            fields.remove(2);
            fields.remove(1);
            fields.add(1, "lastName");
            fields.add(2, "firstName");
        }
        fields.remove("formal");
        fields.remove("informal");
        return fields;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
