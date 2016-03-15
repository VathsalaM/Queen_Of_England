package LibraryTest;
import Person.*;
import org.junit.Test;

public class FilterTest {
    @Test
    public void check_checks_the_condition_and_calls_the_appropriate_function_with_apropriate_parameters() throws Exception {
        Name name = new Name("stupid", "fellow");
        Gender gender = new Gender("Male");
        Age age = new Age(18);
        City city = new City("bangalore");
        State state = new State("Karnataka");
        Country country = new Country("India");
        Address address = new Address(city, state, country);
        Guest guest = new Guest(name, gender, age, address);
//        assertTrue(Filter.check("country","India",guest));
    }
}