package Print;

import Person.Guest;

public class InformalNameFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.informalName();
    }

    @Override
    public String toString() {
        return "InformalNameFormat{}";
    }
}
