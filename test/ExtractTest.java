//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.Assert.assertEquals;
//
//public class ExtractTest {
//    @Test
//    public void extractCommands_returns_formal_when_both_formal_and_informal_are_present() throws Exception {
//        Set<String> commands = new HashSet<>();
//        commands.add("formal");
//        commands.add("informal");
//        commands.add("country");
//        Set<String> expected = new HashSet<>();
//        expected.add("formal");
//        expected.add("country");
////        assertEquals(expected,Extract.extractCommands(commands));
//    }
//
//    @Test
//    public void extractCommands_returns_formal_when_both_formal_and_informal_are_not_present() throws Exception {
//        Set<String> commands = new HashSet<>();
//        commands.add("country");
//        Set<String> expected = new HashSet<>();
//        expected.add("formal");
//        expected.add("country");
////        assertEquals(expected,Extract.extractCommands(commands));
//    }
//
//    @Test
//    public void extractCommand_considers_f_and_formal_both_as_formal() throws Exception {
//        assertEquals("formal",Extract.extractCommand("-f"));
//    }
//    @Test
//    public void extractCommand_considers_i_and_informal_both_as_informal() throws Exception {
//        assertEquals("informal",Extract.extractCommand("-i"));
//    }
//
//    @Test
//    public void extractCommand_returns_the_command_without_specialCharacters() throws Exception {
//        assertEquals("formal",Extract.extractCommand("--formal"));
//        assertEquals("informal",Extract.extractCommand("--informal"));
//    }
//
//    @Test
//    public void extractConditions_extracts_the_conditions_in_commands() throws Exception {
//        Set<String> commands = new HashSet<>();
//        commands.add("formal");
//        commands.add("country");
//        ArrayList<String> argumentsWithoutHyphen = new ArrayList<>();
//        argumentsWithoutHyphen.add("Bangladesh");
//        HashMap<String,String> expectedConditions= new HashMap<>();
//        expectedConditions.put("country","Bangladesh");
//        assertEquals(expectedConditions,Extract.extractConditions(commands,argumentsWithoutHyphen));
//    }
//}