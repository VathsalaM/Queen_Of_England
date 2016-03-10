import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConditionTest {
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
        assertTrue(Condition.check("country","India",guest));
    }
}