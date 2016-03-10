import java.util.ArrayList;
import java.util.Set;

public class Represent {
    public static void print(Set<String> commands, Set<String> strings, ArrayList<Guest> guestList) {
        commands.addAll(strings);
        for (Guest guest : guestList) {
            String guestDetails = getAllFields(commands,guest);
            System.out.println(guestDetails);
        }
    }

    private static String getAllFields(Set<String> commands, Guest guest) {
        String value = "";
        for (String command : commands) {
            value = guest.getValue(command,value);
        }
        return value;
    }
}
