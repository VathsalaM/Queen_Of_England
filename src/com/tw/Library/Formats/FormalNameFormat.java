package com.tw.Library.Formats;

import com.tw.People.Person.Guest;

public class FormalNameFormat implements Format {
    @Override
    public String value(Guest guest) {
        return guest.formalName();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        return !(otherObject == null || getClass() != otherObject.getClass()) && this.getClass() == otherObject.getClass();
    }
}
