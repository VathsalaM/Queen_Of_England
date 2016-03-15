import Library.*;
import Person.Guest;
import Print.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


class Invitation {

    private HashMap<String, String> conditions;
    private Set<String> commands;
    private Set<String> conditionSet;
    private String fileName;

    public Set<String> separateArguments(String[] args) {
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(args);
        argumentSeparator.separate();
        conditions = argumentSeparator.getConditions();
        commands = argumentSeparator.getCommands();
        fileName = argumentSeparator.toString();
        return commands;
    }

    public CompositeFilter addFilters() {
        ArrayList<Filters> predicates = new ArrayList<>();
        conditionSet = conditions.keySet();
        for (String string : conditionSet) {
            if (string.equals("country"))
                predicates.add(new CountryPredicate(conditions.get("country")));
            if (string.equals("ageAbove"))
                predicates.add(new AgePredicate(conditions.get("ageAbove")));
        }
        return new CompositeFilter(predicates);
    }

    public ArrayList<CompositeFormat> addPrintFormats() {
        ArrayList<CompositeFormat> formats = new ArrayList<>();
        if (commands.contains("formal")) {
            formats.add(new CompositeFormat(new FormalNameFormat()));
        } else {
            formats.add(new CompositeFormat(new InformalNameFormat()));
        }
        for (String condition : conditionSet) {
            if (condition.equals("country"))
                formats.add(new CompositeFormat(new CountryFormat()));
            if (condition.equals("ageAbove"))
                formats.add(new CompositeFormat(new AgeFormat()));
        }
        return formats;
    }

    public People generateListOfValidGuests(CompositeFilter compositeFilter) throws IOException {
        String listOfRecords = new Reader().read(fileName);
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        People people = new People(guests);
        return people.filter(compositeFilter);
    }

    public String printLabel(ArrayList<CompositeFormat> formats, People guestList) {
        return guestList.printLabel(formats);
    }

    public String printBorderedLabel(ArrayList<CompositeFormat> formats, People guestList) {
        formats.add(new CompositeFormat(new CityAndStateFormat()));
        formats.add(new CompositeFormat(new CountryFormat()));
        System.out.println(formats.toString());
        return guestList.printBorderedLabel(formats);
    }

}


