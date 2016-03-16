package com.tw.People.Person.Address;

public class Country {
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object otherCountry) {
        if (this == otherCountry) return true;
        if (otherCountry == null || getClass() != otherCountry.getClass()) return false;
        Country country = (Country) otherCountry;
        return name != null ? name.equals(country.name) : country.name == null;

    }
}
