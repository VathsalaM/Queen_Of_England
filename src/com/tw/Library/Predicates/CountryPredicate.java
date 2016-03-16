package com.tw.Library.Predicates;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Guest;

public class CountryPredicate implements Predicates {
    private final Country country;

    public CountryPredicate(Country country) {
        this.country = country;
    }

    @Override
    public boolean test(Guest guest) {
        return guest.isSameCountry(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryPredicate that = (CountryPredicate) o;

        return country != null ? country.equals(that.country) : that.country == null;

    }
}
