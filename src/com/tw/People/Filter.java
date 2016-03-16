package com.tw.People;

import com.tw.Library.Predicates.CompositePredicate;
import com.tw.People.Person.Guest;

import java.util.ArrayList;

public class Filter {
    public ArrayList<Guest> filter(CompositePredicate compositeFilter, ArrayList<Guest> guestList) {
        ArrayList<Guest> filteredGuests = new ArrayList<>();
        for (Guest guest : guestList) {
            if (compositeFilter.test(guest)) {
                filteredGuests.add(guest);
            }
        }
        return filteredGuests;
    }
}
