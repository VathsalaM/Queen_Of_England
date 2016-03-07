import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SplitTest {
    @Test
    public void extractFeilds_splits_the_commands_and_files() throws Exception {
        String[] args = {"-f", "records.txt"};
        Split split = new Split();
        String[] actualFields = split.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields));
    }

    @Test
    public void extractFeilds_considers_f_and_formal_as_single_formal() throws Exception {
        String[] args1 = {"-f", "records.txt"};
        String[] args2 = {"-formal", "records.txt"};
        Split split = new Split();
        String[] actualFields1 = split.extractFeilds(args1);
        String[] actualFields2 = split.extractFeilds(args2);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields1));
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields2));
//        assertTrue(expectedFeilds.equals(actualFields1));
//        assertTrue(expectedFeilds.equals(actualFields2));
    }

    @Test
    public void extractFeilds_does_not_allow_duplication_of_fields() throws Exception {
        String[] args = {"-f", "--formal", "records.txt"};
        Split split = new Split();
        String[] actualFields = split.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields));
//        assertTrue(expectedFeilds.equals(actualFields));
    }

    @Test
    public void extractFeilds_returns_the_default_value_if_there_are_no_fields() throws Exception {
        String[] args = {"records.txt"};
        Split split = new Split();
        String[] actualFields = split.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "firstName", "lastName"};
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields));
//        assertTrue(expectedFeilds.equals(actualFields));
    }


    @Test
    public void extractFeilds_returns_the_last_occurring_value_if_there_are_both_formal_and_informal_arguments() throws Exception {
        String[] args = {"-f", "-i", "records.txt"};
        Split split = new Split();
        String[] actualFields = split.extractFeilds(args);
        String[] expectedFeilds = {"prefix","lastName", "firstName"};
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields));
//        assertTrue(expectedFeilds.equals(actualFields));
    }


    @Test
    public void extractFeilds_returns_the_informal_set_of_fields_if_informal_arguments_are_passed() throws Exception {
        String[] args = {"-i", "records.txt"};
        Split split = new Split();
        String[] actualFields = split.extractFeilds(args);
        String[] expectedFeilds = {"prefix", "lastName", "firstName"};
        assertEquals(Arrays.toString(expectedFeilds),Arrays.toString(actualFields));
//        assertTrue(expectedFeilds.equals(actualFields));
    }
}
