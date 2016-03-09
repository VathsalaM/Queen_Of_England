import java.util.HashMap;

class Record extends HashMap {

    private final String[] fields;
    private HashMap<Name, Guest> labelList;

    public Record(String[] fields) {
        this.fields = fields;
    }

    public void create(String listOfRecordInString) {
        String[] listOfRecords = listOfRecordInString.split("\n");
        for (String guestDetailsInString : listOfRecords) {
            String[] guestDetails = guestDetailsInString.split(",");
            Name name = new Name(guestDetails[0],guestDetails[1]);
            Gender gender = new Gender(guestDetails[2]);
            Age age = new Age(Integer.valueOf(guestDetails[3]));
            City city = new City(guestDetails[4]);
            State state = new State(guestDetails[5]);
            Country country = new Country(guestDetails[6]);
            Address address = new Address(city,state,country);
            Guest guest = new Guest(name, gender, age, address);
            labelList.put(name,guest);
        }
    }
}
