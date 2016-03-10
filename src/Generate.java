import java.util.ArrayList;

public class Generate {
    public static Guest guest(String guestInformation){
        String[] details = guestInformation.split(",");
        Name name = new Name(details[0],details[1]);
        Gender gender = new Gender(details[2]);
        Age age = new Age(Integer.parseInt(details[3]));
        City city = new City(details[4]);
        State state = new State(details[5]);
        Country country = new Country(details[6]);
        Address address = new Address(city,state,country);
        return new Guest(name,gender,age,address);
    }

    public static ArrayList<Guest> guestList(String listOfRecords) {
        ArrayList<Guest> listOfGuests = new ArrayList<>();
        String[] guests = listOfRecords.split("\n");
        for (String guestInformation : guests) {
            listOfGuests.add(guest(guestInformation));
        }
        return listOfGuests;
    }
}
