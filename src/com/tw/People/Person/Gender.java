package com.tw.People.Person;

public enum Gender {
    Male("Mr"),
    Female("Ms");

    private String prefix;

    Gender(String prefix) {

        this.prefix = prefix;
    }

    public String prefix() {
        return this.prefix;
    }
}
