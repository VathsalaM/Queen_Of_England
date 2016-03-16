package LibraryTest.PredicatesTest;

import com.tw.Library.Generate;
import com.tw.Library.Predicates.AgePredicate;
import com.tw.Library.Predicates.CompositePredicate;
import com.tw.Library.Predicates.CountryPredicate;
import com.tw.Library.Predicates.Predicates;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Age;
import com.tw.People.Person.Guest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CompositePredicateTest {
    @Test
    public void test_tests_weather_the_guest_passes_all_the_given_conditions() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        ArrayList<Predicates> predicates = new ArrayList<>();
        predicates.add(new CountryPredicate(new Country("Macedonia")));
        predicates.add(new AgePredicate(new Age(17)));
        CompositePredicate compositePredicate = new CompositePredicate(predicates);
        assertEquals(true,compositePredicate.test(guests.get(0)));
    }
    @Test
    public void test_returns_false_if_guest_doesnot_satisfy_any_conditions() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        ArrayList<Predicates> predicates = new ArrayList<>();
        predicates.add(new CountryPredicate(new Country("Macedonia")));
        predicates.add(new AgePredicate(new Age(20)));
        CompositePredicate compositePredicate = new CompositePredicate(predicates);
        assertEquals(false,compositePredicate.test(guests.get(0)));
    }
}