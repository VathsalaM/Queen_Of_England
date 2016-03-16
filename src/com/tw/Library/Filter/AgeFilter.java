package com.tw.Library.Filter;

import com.tw.People.Person.Age;
import com.tw.People.Person.Guest;

public class AgeFilter implements Filter {

    private Age age;

    public AgeFilter(Age age) {

        this.age = age;
    }

    @Override
    public boolean test(Guest guest) {
        return guest.isAgeValid(age);
    }
}
