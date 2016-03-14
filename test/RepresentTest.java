import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepresentTest {
    @Test
    public void findMaxLength_finds_the_max_length_of_all_the_strings_given() throws Exception {
        Represent represent = new Represent();
        int actualLength = represent.findMaxLength("hello","how are you","I am awesome");
        assertEquals(12,actualLength);
    }

    @Test
    public void addSpace_adds_extra_space_for_the_string_and_returns_the_string() throws Exception {
        Represent represent = new Represent();
        String actualString = represent.addChar("hello",15,' ');
        assertEquals(" hello           ",actualString);
    }

    @Test
    public void addBorder_adds_borderaccross_the_given_String() throws Exception {
        Represent represent = new Represent();
        String actual = represent.addBorder(" how   "," are   "," you   ");
        String expected = "+-------+\n" +
                          "| how   |\n" +
                          "|-------|\n" +
                          "| are   |\n" +
                          "| you   |\n" +
                          "+-------+\n";
        assertEquals(expected,actual);
    }
}