package com.tw.Library;

import com.tw.People.Person.Address.Address;
import com.tw.People.Person.Address.City;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Address.State;
import com.tw.People.Person.Age;
import com.tw.People.Person.Gender;
import com.tw.People.Person.Guest;
import com.tw.People.Person.Name;

import java.util.ArrayList;

public class Generate {
    private Guest guest(String guestInformation) {
        String[] details = guestInformation.split(",");
        Name name = new Name(details[0], details[1]);
        Gender gender = Gender.valueOf(details[2]);
        Age age = new Age(Integer.parseInt(details[3]));
        City city = new City(details[4]);
        State state = new State(details[5]);
        Country country = new Country(details[6]);
        Address address = new Address(city, state, country);
        return new Guest(name, gender, age, address);
    }

    public ArrayList<Guest> guestList(String listOfRecords) {
        ArrayList<Guest> listOfGuests = new ArrayList<>();
        String[] guests = listOfRecords.split("\n");
        for (String guestInformation : guests) {
            listOfGuests.add(guest(guestInformation));
        }
        return listOfGuests;
    }
}
