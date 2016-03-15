package Print;

import Person.Guest;

import java.util.ArrayList;
import java.util.Arrays;


public class Represent {

    private String getBorderedLabel(String name, String cityAndState, String country) {
        int maxLength = findMaxLength(name, cityAndState, country);
        name = addChar(name, maxLength, ' ');
        cityAndState = addChar(cityAndState, maxLength, ' ');
        country = addChar(country, maxLength, ' ');
        return addBorder(name, cityAndState, country);
    }

    public String addBorder(String name, String cityAndState, String country) {
        String top = String.format("+%s+", addChar("", name.length() - 2, '-'));
        String middleLine = String.format("|%s|", addChar("", name.length() - 2, '-'));
        name = String.format("|%s|", name);
        cityAndState = String.format("|%s|", cityAndState);
        country = String.format("|%s|", country);
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n", top, name, middleLine, cityAndState, country, top);
    }

    public String addChar(String name, int maxLength, char character) {
        int spaceLength = maxLength - name.length();
        char[] characterArray = new char[spaceLength];
        Arrays.fill(characterArray, character);
        return String.format("%s%s%s%s", character, name, new String(characterArray), character);
    }

    public int findMaxLength(String name, String cityAndState, String country) {
        String highest = name.length() > cityAndState.length() ? name : cityAndState;
        String maximum = highest.length() > country.length() ? highest : country;
        return maximum.length();
    }

    public String borderedLabel(ArrayList<CompositeFormat> formats, ArrayList<Guest> guestList) {
        String result = "";
        for (Guest guest : guestList) {
            String name = formats.get(0).value(guest);
            String cityAndState = formats.get(1).value(guest);
            String country = formats.get(2).value(guest);
            String label = getBorderedLabel(name, cityAndState, country);
            result += label;
        }
        return result;
    }

    public String label(ArrayList<CompositeFormat> formats, ArrayList<Guest> guestList) {
        String result = "";
        for (Guest guest : guestList) {
            String guestDetails = formats.get(0).value(guest);
            for (int i = 1; i < formats.size(); i++) {
                guestDetails += ", " + formats.get(i).value(guest);
            }
            result += guestDetails+"\n";
        }
        return result;
    }
}
