import java.util.*;

class ArgumentSeparator {

    private String[] arguments;
    private Set<String> commands;
    private String file;

    public HashMap<String, String> getConditions() {
        return conditions;
    }

    private HashMap<String, String> conditions;

    public ArgumentSeparator(String[] arguments) {
        this.arguments = arguments;
    }

    public Set<String> separate() {
        commands = new HashSet<>();
        ArrayList<String> argumentsWithoutSpecialCharacters = new ArrayList<>();
        for (int i=0;i<arguments.length-1;i++) {
            if(arguments[i].split("[^-]").length>0)
                commands.add(Extract.extractCommand(arguments[i]));
            else
                argumentsWithoutSpecialCharacters.add(arguments[i]);
        }
        this.file = this.arguments[arguments.length-1];
        this.conditions = Extract.extractConditions(commands,argumentsWithoutSpecialCharacters);
        return commands;
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
