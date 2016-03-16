package com.tw.Library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArgumentSeparator {

    private HashMap<String, String> conditions = new HashMap<>();
    private String[] arguments;
    private String file;


    public ArgumentSeparator(String[] arguments) {
        this.arguments = arguments;
    }

    public Set<String> separateCommands() {
        Set<String> commands = new HashSet<>();
        for (int i = 0; i < arguments.length - 1; i++) {
            if (arguments[i].split("[^-]").length > 0) {
                commands.add(extractCommand(arguments[i]));
            } else {
                String[] conditionSplit = arguments[i].split(":");
                if (conditionSplit.length > 0) {
                    conditions.put(conditionSplit[0], conditionSplit[1]);
                }
            }
        }
        this.file = this.arguments[arguments.length - 1];
        return extractCommands(commands);
    }

    private String extractCommand(String argument) {
        int beginIndex = argument.split("[^-]")[0].length();
        int endIndex = argument.length();
        String command = argument.substring(beginIndex, endIndex);
        command = command.equals("f") ? "formal" : command;
        command = command.equals("i") ? "informalName" : command;
        return command;
    }

    private Set<String> extractCommands(Set<String> commands) {
        if (commands.contains("formal") && commands.contains("informalName"))
            commands.remove("formal");
        if (!commands.contains("formal") && !commands.contains("informalName"))
            commands.add("informalName");
        return commands;
    }

    public String getFile() {
        return this.file;
    }

    public HashMap<String, String> getConditions() {
        return conditions;
    }
}
