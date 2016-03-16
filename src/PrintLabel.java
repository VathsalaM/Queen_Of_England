import com.tw.Library.Add;
import com.tw.Library.ArgumentSeparator;
import com.tw.Library.Formats.Format;
import com.tw.Library.Generate;
import com.tw.Library.Predicates.CompositePredicate;
import com.tw.Library.Reader.Reader;
import com.tw.People.People;
import com.tw.People.Person.Guest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PrintLabel {
    public static void main(String[] args) throws IOException {
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(args);
        Set<String> commands = argumentSeparator.separateCommandsAndConditions();
        String fileName = argumentSeparator.file();
        HashMap<String,String> conditions = argumentSeparator.getConditions();
        String listOfRecords = new Reader().read(fileName);
        CompositePredicate compositePredicate = new Add().predicates(conditions);
        Format format = new Add().format(commands);
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        People people = new People(guests);
        People filteredGuestList = people.filter(compositePredicate);
        System.out.println(filteredGuestList.createLabel(format));
    }
}
