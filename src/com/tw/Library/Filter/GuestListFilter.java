package com.tw.Library.Filter;

import com.tw.People.Person.Guest;

import java.util.ArrayList;

public class GuestListFilter {
    public ArrayList<Guest> filter(CompositeFilter compositeFilter, ArrayList<Guest> guestList) {
        ArrayList<Guest> filteredGuests = new ArrayList<>();
        for (Guest guest : guestList) {
            if (compositeFilter.test(guest)) {
                filteredGuests.add(guest);
            }
        }
        return filteredGuests;
    }
}
