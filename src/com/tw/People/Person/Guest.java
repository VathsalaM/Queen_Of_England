package com.tw.People.Person;

import com.tw.Library.Formats.Format;
import com.tw.People.Person.Address.Address;
import com.tw.People.Person.Address.Country;

import java.util.HashMap;

public class Guest {
    private final Name name;
    private final Gender gender;
    private final Age age;
    private final Address address;
    private HashMap<String, String> methods;

    public Guest(Name name, Gender gender, Age age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String formatName(Format format) {
        return gender.prefix() + " " + name.format(format);
    }

    public String age() {
        return age.toString();
    }

    public String country() {
        return address.country();
    }

    public String cityAndState() {
        return address.cityAndCountry();
    }

    public boolean isAgeValid(Age age) {
        return this.age.isAbove(age);
    }

    public boolean isSameCountry(Country country) {
        return this.address.isSameCountry(country);
    }
}
