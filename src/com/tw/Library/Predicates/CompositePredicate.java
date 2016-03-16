package com.tw.Library.Predicates;

import com.tw.People.Person.Guest;

import java.util.ArrayList;

public class CompositePredicate implements Predicates {
    private ArrayList<Predicates> predicates;
    public CompositePredicate(ArrayList<Predicates> predicates) {
        this.predicates = predicates;
    }
    @Override
    public boolean test(Guest guest) {
        for (Predicates predicate : this.predicates) {
            if(!predicate.test(guest))
                return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositePredicate that = (CompositePredicate) o;

        return predicates != null ? predicates.equals(that.predicates) : that.predicates == null;

    }
}
