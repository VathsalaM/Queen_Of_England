import com.tw.Library.Add;
import com.tw.Library.ArgumentSeparator;
import com.tw.Library.Filter.CompositeFilter;
import com.tw.Library.Filter.GuestListFilter;
import com.tw.Library.Formats.Format;
import com.tw.Library.Generate;
import com.tw.Library.Reader.Reader;
import com.tw.Library.Represent.Represent;
import com.tw.People.Person.Guest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PrintLabel {
    public static void main(String[] args) throws IOException {
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(args);
        Set<String> commands = argumentSeparator.separateCommands();
        String fileName = argumentSeparator.getFile();
        HashMap<String, String> conditions = argumentSeparator.getConditions();
        String listOfRecords = new Reader().read(fileName);
        CompositeFilter compositeFilter = Add.filters(conditions);
        Format format = Add.format(commands);
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        ArrayList<Guest> filteredGuestList = new GuestListFilter().filter(compositeFilter, guests);
        System.out.println(new Represent().label(format, filteredGuestList));
    }
}
