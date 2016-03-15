package Print;
import Person.Guest;

public class FormalNameFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.formalName();
    }

    @Override
    public String toString() {
        return "FormalNameFormat{}";
    }
}
