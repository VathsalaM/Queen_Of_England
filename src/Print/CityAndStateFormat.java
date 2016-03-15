package Print;

import Person.Guest;

public class CityAndStateFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.cityAndState();
    }
}
