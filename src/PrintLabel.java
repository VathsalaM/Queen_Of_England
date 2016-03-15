import Library.CompositeFilter;
import Library.People;
import Print.CompositeFormat;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;

public class PrintLabel {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Invitation invitation = new Invitation();
        Set<String> commands = invitation.separateArguments(args);
        CompositeFilter filters = invitation.addFilters();
        ArrayList<CompositeFormat> formats = invitation.addPrintFormats();
        People guestList = invitation.generateListOfValidGuests(filters);
        String label;
        if (commands.contains("borderedLabel")) {
            label = invitation.printBorderedLabel(formats,guestList);
        }
        else
            label = invitation.printLabel(formats,guestList);
        System.out.println(label);
    }
}
