import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    @Test
    public void represent_represents_the_given_field_values_seperated_by_given_delimiters() throws Exception {
        String[] details = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Guest guest = new Guest(details);
        String[] fields = {"prefix", "firstName", "lastName"};
        String[] delimiter = {" ", " ", ""};
        String actual = guest.represent(fields, delimiter);
        String expected = "Ms Julius Barrows\n";
        assertEquals(expected, actual);
    }

    @Test
    public void represent_represents_the_list_with_given_feilds_seperated_by_given_delimiters() throws Exception {
        String[] details = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Guest guest = new Guest(details);
        String[] fields = {"prefix", "lastName", "firstName"};
        String[] delimiter = {" ", ", ", ""};
        String actual = guest.represent(fields, delimiter);
        String expected = "Ms Barrows, Julius\n";
        assertEquals(expected, actual);
    }

    @Test
    public void represent_represents_the_Name_along_with_country_name() throws Exception {
        String[] details = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Guest guest = new Guest(details);
        String[] fields = {"prefix", "lastName", "firstName", "country"};
        String[] delimiter = {" ", ", ", ", ", ""};
        String actual = guest.represent(fields, delimiter);
        String expected = "Ms Barrows, Julius, Macedonia\n";
        assertEquals(expected, actual);
    }
}