import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GuestTest {
    @Test
    public void isSameCity_returns_true_if_the_given_city_is_same() throws Exception {
        Name name = new Name("stupid", "fellow");
        Gender gender = new Gender("Male");
        Age age = new Age(18);
        City city = new City("bangalore");
        State state = new State("Karnataka");
        Country country = new Country("India");
        Address address = new Address(city, state, country);
        Guest guest = new Guest(name, gender, age, address);
        assertTrue(guest.isSameCountry(country));
    }
}