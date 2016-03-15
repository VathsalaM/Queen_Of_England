package Library;

import Person.Guest;
import Print.CompositeFormat;
import Print.Represent;

import java.util.ArrayList;

public class People {
    private ArrayList<Guest> people;

    public People(ArrayList<Guest> people) {
        this.people = people;
    }

    public People filter(CompositeFilter compositeFilter) {
        ArrayList<Guest> filteredGuests = new ArrayList<>();
        for (Guest guest : people) {
            if (compositeFilter.test(guest)) {
                filteredGuests.add(guest);
            }
        }
        people = filteredGuests;
        return new People(filteredGuests);
    }

    public String print(ArrayList<CompositeFormat> format) {
        Represent represent = new Represent();
        return represent.label(format,this.people);
    }

    public String printBorderedLabel(ArrayList<CompositeFormat> format) {
        Represent represent = new Represent();
        return represent.borderedLabel(format, this.people);
    }

    public String printLabel(ArrayList<CompositeFormat> formats) {
        Represent represent = new Represent();
        return represent.label(formats, this.people);
    }
}
