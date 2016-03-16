package com.tw.Library.Represent;
import com.tw.Library.Formats.Format;
import com.tw.People.Person.Guest;

import java.util.ArrayList;
import java.util.Arrays;



public class Represent {

    public String label(Format format, ArrayList<Guest> guestList) {
        String result = "";
        for (Guest guest : guestList) {
            String name = guest.formatName(format);
            String cityAndState = guest.cityAndState();
            String country = guest.country();
            String label = getBorderedLabel(name, cityAndState, country);
            result += label;
        }
        return result;
    }
    private String getBorderedLabel(String name, String cityAndState, String country) {
        int maxLength = findMaxLength(name, cityAndState, country);
        name = addChar(name, maxLength, ' ');
        cityAndState = addChar(cityAndState, maxLength, ' ');
        country = addChar(country, maxLength, ' ');
        return addBorder(name, cityAndState, country);
    }

    private String addBorder(String name, String cityAndState, String country) {
        String top = String.format("+%s+", addChar("", name.length() - 2, '-'));
        String middleLine = String.format("|%s|", addChar("", name.length() - 2, '-'));
        name = String.format("|%s|", name);
        cityAndState = String.format("|%s|", cityAndState);
        country = String.format("|%s|", country);
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n", top, name, middleLine, cityAndState, country, top);
    }

    private String addChar(String name, int maxLength, char character) {
        int spaceLength = maxLength - name.length();
        char[] characterArray = new char[spaceLength];
        Arrays.fill(characterArray, character);
        return String.format("%s%s%s%s", character, name, new String(characterArray), character);
    }

    private int findMaxLength(String name, String cityAndState, String country) {
        String highest = name.length() > cityAndState.length() ? name : cityAndState;
        String maximum = highest.length() > country.length() ? highest : country;
        return maximum.length();
    }

}
