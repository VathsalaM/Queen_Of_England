import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddressTest {
    @Test
    public void isSameCountry_checks_wether_both_the_countries_are_same_or_not() throws Exception {
        City city = new City("bangalore");
        State state = new State("Karnataka");
        Country country = new Country("India");
        Address address = new Address(city, state, country);
        assertTrue(address.isSameCountry(new Country("India")));
    }
}