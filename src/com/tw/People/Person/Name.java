package com.tw.People.Person;

import com.tw.Library.Formats.Format;

public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String format(Format format) {
        return format.value(firstName,lastName);
    }
}
