package com.tw.People.Person.Address;

public class Address {
    private final City city;
    private final State state;
    private final Country country;

    public Address(City city, State state, Country country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public boolean isSameCountry(Country otherCountry) {
        return this.country.equals(otherCountry);
    }

    public String cityAndCountry() {
        return String.format("%s, %s", city.toString(), state.toString());
    }

    public String country() {
        return country.toString();
    }

}
