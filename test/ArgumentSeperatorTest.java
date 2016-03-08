import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArgumentSeperatorTest {
    @Test
    public void extractFeilds_splits_the_commands_and_files() throws Exception {
        String[] args = {"-f", "records.txt"};
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        String[] actualFields = argumentSeperator.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertArrayEquals(expectedFeilds,actualFields);
    }

    @Test
    public void extractFeilds_considers_f_and_formal_as_single_form() throws Exception {
        String[] args1 = {"-f", "records.txt"};
        String[] args2 = {"--formal", "records.txt"};
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        String[] actualFields1 = argumentSeperator.extractFeilds(args1);
        String[] actualFields2 = argumentSeperator.extractFeilds(args2);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertArrayEquals(expectedFeilds, actualFields1);
        assertArrayEquals(expectedFeilds, actualFields2);
    }

    @Test
    public void extractFeilds_does_not_allow_duplication_of_fields() throws Exception {
        String[] args = {"-f", "--formal", "records.txt"};
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        String[] actualFields = argumentSeperator.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertArrayEquals(expectedFeilds, actualFields);
    }

    @Test
    public void extractFeilds_returns_the_default_value_if_there_are_no_fields() throws Exception {
        String[] args = {"records.txt"};
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        String[] actualFields = argumentSeperator.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertArrayEquals(expectedFeilds, actualFields);
    }


    @Test
    public void extractFeilds_returns_the_last_occurring_value_if_there_are_both_formal_and_informal_arguments() throws Exception {
        String[] args = {"-f", "-i", "records.txt"};
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        String[] actualFields = argumentSeperator.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "lastName", "firstName"};
        assertArrayEquals(expectedFeilds, actualFields);
    }


    @Test
    public void extractFeilds_returns_the_informal_set_of_fields_if_informal_arguments_are_passed() throws Exception {
        String[] args = {"-i", "records.txt"};
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        String[] actualFields = argumentSeperator.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "lastName", "firstName"};
        assertArrayEquals(expectedFeilds, actualFields);
    }
}
