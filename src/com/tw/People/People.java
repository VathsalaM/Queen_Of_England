package com.tw.People;

import com.tw.Library.Formats.Format;
import com.tw.Library.Predicates.CompositePredicate;
import com.tw.Library.Represent.Represent;
import com.tw.People.Person.Guest;

import java.util.ArrayList;

public class People {
    private ArrayList<Guest> peopleList;

    public People(ArrayList<Guest> peopleList) {
        this.peopleList = peopleList;
    }

    public People filter(CompositePredicate compositeFilter) {
        ArrayList<Guest> filteredGuests = new ArrayList<>();
        for (Guest guest : peopleList) {
            if (compositeFilter.test(guest)) {
                filteredGuests.add(guest);
            }
        }
        peopleList = filteredGuests;
        return new People(filteredGuests);
    }

    public String createLabel(Format format) {
        Represent represent = new Represent();
        return represent.label(format, this.peopleList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people1 = (People) o;
        System.out.println(this.peopleList+"\t"+ people1.peopleList);
        return peopleList != null ? peopleList.equals(people1.peopleList) : people1.peopleList == null;
    }
}
