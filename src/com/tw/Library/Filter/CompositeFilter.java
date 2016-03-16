package com.tw.Library.Filter;

import com.tw.People.Person.Guest;

import java.util.ArrayList;

public class CompositeFilter implements Filter {
    private ArrayList<Filter> predicates;

    public CompositeFilter(ArrayList<Filter> predicates) {
        this.predicates = predicates;
    }

    @Override
    public boolean test(Guest guest) {
        for (Filter predicate : this.predicates) {
            if (!predicate.test(guest))
                return false;
        }
        return true;
    }
}
