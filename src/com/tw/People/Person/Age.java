package com.tw.People.Person;
public class Age {
    private final int age;

    public Age(int age) {
        this.age = age;
    }
    public boolean isAbove(Age otherAge) {
        return this.age>otherAge.age;
    }

    @Override
    public String toString() {
        return  ""+age;
    }
}
