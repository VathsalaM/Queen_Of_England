package com.tw.People.Person;
public class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Name name = (Name) o;
        return firstName.equals(name.firstName) && lastName.equals(name.lastName);

    }

    public String formalName() {
        return lastName+", "+firstName;
    }

    public String informalName() {
        return firstName+" "+lastName;
    }

}
