package LibraryTest;

import com.tw.Library.ArgumentSeparator;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ArgumentSeparatorTest {
    @Test
    public void separate_takes_all_the_arguments_and_separates_file_and_commands() throws Exception {
        String[] arguments = {"-f","sample.txt"};
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        Set<String> commands = new HashSet<>();
        commands.add("formal");
        HashMap<String,String> conditions = new HashMap<>();
        String file = "sample.txt";
        assertEquals(commands,argumentSeparator.separateCommandsAndConditions());
        assertEquals(file,argumentSeparator.getFile());
        assertEquals(conditions,argumentSeparator.getConditions());
    }

    @Test
    public void separate_takes_all_the_arguments_and_separates_file_commands_and_conditions() throws Exception {
        String[] arguments = {"-f","country:Germany","sample.txt"};
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        Set<String> commands = new HashSet<>();
        commands.add("formal");
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("country","Germany");
        String file = "sample.txt";
        assertEquals(commands,argumentSeparator.separateCommandsAndConditions());
        assertEquals(file,argumentSeparator.getFile());
        assertEquals(conditions,argumentSeparator.getConditions());
    }
    @Test
    public void separate_adds_informal_as_command_when_there_is_no_command_present() throws Exception {
        String[] arguments = {"country:Germany","sample.txt"};
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        Set<String> commands = new HashSet<>();
        commands.add("informalName");
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("country","Germany");
        String file = "sample.txt";
        assertEquals(commands,argumentSeparator.separateCommandsAndConditions());
        assertEquals(file,argumentSeparator.getFile());
        assertEquals(conditions,argumentSeparator.getConditions());
    }
    @Test
    public void separate_does_not_adds_command_if_it_is_already_present() throws Exception {
        String[] arguments = {"-i","--formal","country:Germany","sample.txt"};
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        Set<String> commands = new HashSet<>();
        commands.add("informalName");
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("country","Germany");
        String file = "sample.txt";
        assertEquals(commands,argumentSeparator.separateCommandsAndConditions());
        assertEquals(file,argumentSeparator.getFile());
        assertEquals(conditions,argumentSeparator.getConditions());
    }

}
