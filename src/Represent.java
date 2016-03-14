import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Represent {

    public void print(Set<String> commands, Set<String> conditions, ArrayList<Guest> guestList) {
        System.out.println("function called.......");
        commands.addAll(conditions);
        for (Guest guest : guestList) {
            String guestDetails = getAllFields(commands, guest);
            System.out.println(guestDetails);
        }
    }

    private String getAllFields(Set<String> commands, Guest guest) {
        String value = "";
        for (String command : commands) {
            value = guest.getValue(command, value+", ");
        }
        return value;
    }

    public void print(Set<String> commands, ArrayList<Guest> guestList) {
        String[] strings = commands.toArray(new String[commands.size()]);
        for (Guest guest : guestList) {
            String name = guest.getValue(strings[1], "");
            String cityAndState = guest.getValue("address", "");
            String country = guest.getValue("country", "");
            String label = getBorderedLabel(name, cityAndState, country);
            System.out.println(label);
        }
    }

    private String getBorderedLabel(String name, String cityAndState, String country) {
        int maxLength = findMaxLength(name, cityAndState, country);
        name = addChar(name,maxLength,' ');
        cityAndState = addChar(cityAndState,maxLength,' ');
        country = addChar(country,maxLength,' ');
        String borderedLabel = addBorder(name,cityAndState,country);
        return borderedLabel;
    }

    String addBorder(String name, String cityAndState, String country) {
        String top = String.format("+%s+",addChar("",name.length()-2,'-'));
        String middleLine = String.format("|%s|",addChar("",name.length()-2,'-'));
        name = String.format("|%s|",name);
        cityAndState = String.format("|%s|",cityAndState);
        country = String.format("|%s|",country);
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n",top,name,middleLine,cityAndState,country,top);
    }

    String addChar(String name, int maxLength,char character) {
        int spaceLength = maxLength-name.length();
        char[] characterArray = new char[spaceLength];
        Arrays.fill(characterArray,character);
        return String.format("%s%s%s%s",character,name,new String(characterArray),character);
    }

    int findMaxLength(String name, String cityAndState, String country) {
        String highest = name.length() > cityAndState.length() ? name : cityAndState;
        String maximum = highest.length() > country.length() ? highest : country;
        return maximum.length();
    }
}
