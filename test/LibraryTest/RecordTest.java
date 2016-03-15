package LibraryTest;
import Person.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class RecordTest {
    @Test
    public void create_creates_the_record_of_all_the_guests_given_in_the_list_of_records() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n" +
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh\n";
        ArrayList<Guest> expectedRecord = new ArrayList<>();
        Name name = new Name("Melody", "Dooley");
        Gender gender = new Gender("Female");
        Age age = new Age(31);
        City city = new City("West Shanna");
        State state = new State("Vermont");
        Country country = new Country("Bangladesh");
        Address address = new Address(city, state, country);
        Guest guest = new Guest(name, gender, age, address);
        expectedRecord.add(guest);
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("country","Bangladesh");
//        ArrayList<Guest> actualRecord = new Record(listOfRecords).create(conditions);
//        assertEquals(expectedRecord,actualRecord);
    }
}