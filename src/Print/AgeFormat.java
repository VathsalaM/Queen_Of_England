package Print;

import Person.Guest;

public class AgeFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.age();
    }

    @Override
    public String toString() {
        return "AgeFormat{}";
    }
}
