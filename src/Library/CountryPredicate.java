package Library;

import Person.Country;
import Person.Guest;

public class CountryPredicate implements Filters {
    private final Country threshold;

    public CountryPredicate(String country) {
        this.threshold = new Country(country);
    }

    @Override
    public boolean test(Guest guest) {
        return guest.isSameCountry(threshold);
    }
}
