package com.tw.Library.Filter;

import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Guest;

public class CountryFilter implements Filter {
    private final Country country;

    public CountryFilter(Country country) {
        this.country = country;
    }

    @Override
    public boolean test(Guest guest) {
        return guest.isSameCountry(country);
    }
}
