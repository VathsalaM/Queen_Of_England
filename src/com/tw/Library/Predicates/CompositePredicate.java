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
}
