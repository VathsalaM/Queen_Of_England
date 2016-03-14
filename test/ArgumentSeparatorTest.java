import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class ArgumentSeparatorTest {
    @Test
    public void separate_takes_all_the_arguments_and_separates_file_and_commands() throws Exception {
        String[] arguments = {"-f","sample.txt"};
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        argumentSeparator.separate();
        Set<String> commands = new HashSet<>();
        commands.add("formal");
        String file = "sample.txt";
        assertTrue(argumentSeparator.isCommandsEqual(commands));
        assertTrue(argumentSeparator.isFileEqual(file));
    }

    @Test
    public void separate_separates_the_condition_to_be_performed() throws Exception {
        String[] arguments = {"--informalName","country:Bangladesh","sample.txt"};
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        argumentSeparator.separate();
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("country","Bangladesh");
        Set<String> commands = new HashSet<>();
        commands.add("informalName");
        String file = "sample.txt";
        assertTrue(argumentSeparator.isConditionsEqual(conditions));
        assertTrue(argumentSeparator.isCommandsEqual(commands));
        assertTrue(argumentSeparator.isFileEqual(file));
    }
}
