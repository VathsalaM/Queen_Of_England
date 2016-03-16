package com.tw.Library.Formats;

import com.tw.People.Person.Guest;

public class InformalNameFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.informalName();
    }
}
