package PeopleTest;

import com.tw.Library.Formats.InformalNameFormat;
import com.tw.Library.Generate;
import com.tw.Library.Predicates.CompositePredicate;
import com.tw.Library.Predicates.CountryPredicate;
import com.tw.Library.Predicates.Predicates;
import com.tw.People.People;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Guest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PeopleTest {
    @Test
    public void filter_filters_the_people_according_to_the_conditions_specified() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n" +
                "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        People people = new People(guests);
        ArrayList<Predicates> predicates = new ArrayList<>();
        predicates.add(new CountryPredicate(new Country("Bangladesh")));
        CompositePredicate compositePredicate = new CompositePredicate(predicates);
        People actualPeople = people.filter(compositePredicate);

        String expectedListOfRecords = "Melody,Dooley,Female,31,West Shanna,Vermont,Bangladesh";
        ArrayList<Guest> guestList = new Generate().guestList(expectedListOfRecords);
        People expectedPeople = new People(guestList);
        assertEquals(expectedPeople,actualPeople);
    }

    @Test
    public void createLabel_creates_label_for_the_list_of_guests() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        People people = new People(guests);
        String actualLabel = people.createLabel(new InformalNameFormat());
        String expectedLabel="+---------------------+\n" +
                "| Ms Julius Barrows   |\n" +
                "|---------------------|\n" +
                "| Veda haven, Vermont |\n" +
                "| Macedonia           |\n" +
                "+---------------------+\n";
        assertEquals(expectedLabel,actualLabel);
    }
}