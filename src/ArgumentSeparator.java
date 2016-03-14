import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ArgumentSeparator {

    private String[] arguments;
    private Set<String> commands;
    private String file;

    public HashMap<String, String> getConditions() {
        return conditions;
    }

    private HashMap<String, String> conditions = new HashMap<>();

    public ArgumentSeparator(String[] arguments) {
        this.arguments = arguments;
    }

    public Set<String> separate() {
        commands = new HashSet<>();
        for (int i = 0; i < arguments.length - 1; i++) {
            extactCommand(arguments[i]);
        }
        this.file = this.arguments[arguments.length - 1];
        return Extract.extractCommands(commands);
    }

    private void extactCommand(String argument) {
        if (argument.split("[^-]").length > 0)
            commands.add(Extract.extractCommand(argument));
        else {
            String[] conditionSplit = argument.split(":");
            if (conditionSplit.length > 0) {
                conditions.put(conditionSplit[0], conditionSplit[1]);
            }
        }
    }

    public boolean isCommandsEqual(Set<String> otherCommands) {
        return this.commands.equals(otherCommands);
    }

    public boolean isFileEqual(String otherFile) {
        return this.file.equals(otherFile);
    }

    public boolean isConditionsEqual(HashMap<String, String> conditions) {
        return this.conditions.equals(conditions);
    }

    @Override
    public String toString() {
        return this.file;
    }
}
