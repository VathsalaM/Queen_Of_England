package com.tw.Library.Predicates;

import com.tw.People.Person.Age;
import com.tw.People.Person.Guest;

public class AgePredicate implements Predicates {

    private Age age;

    public AgePredicate(Age age) {

        this.age = age;
    }

    @Override
    public boolean test(Guest guest) {
        return guest.isAgeValid(age);
    }
}
