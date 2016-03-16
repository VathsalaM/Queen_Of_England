package LibraryTest;

import com.tw.Library.Generate;
import com.tw.People.Person.Address.Address;
import com.tw.People.Person.Address.City;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Address.State;
import com.tw.People.Person.Guest;
import org.junit.Test;

import java.util.ArrayList;

public class GenerateTest {
    @Test
    public void guestList_generates_list_of_guests_when_the_record_is_provided() throws Exception {
        ArrayList<Guest> expectedGuestList = new ArrayList<>();
        City city = new City("Veda haven");
        State state = new State("Vermont");
        Country country = new Country("Macedonia");
        Address address = new Address(city, state, country);
        Generate generate = new Generate();
        ArrayList<Guest> guests = generate.guestList("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
//        assertEquals(expectedGuestList,guests);
    }
}