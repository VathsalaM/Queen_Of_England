package Print;

import Person.Guest;

public class CountryFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.country();
    }

    @Override
    public String toString() {
        return "CountryFormat{}";
    }
}
