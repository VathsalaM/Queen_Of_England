package LibraryTest.PredicatesTest;

import com.tw.Library.Filter.AgeFilter;
import com.tw.Library.Filter.CompositeFilter;
import com.tw.Library.Filter.CountryFilter;
import com.tw.Library.Filter.Filter;
import com.tw.Library.Generate;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Age;
import com.tw.People.Person.Guest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CompositeGuestListFilterTest {
    @Test
    public void test_tests_weather_the_guest_passes_all_the_given_conditions() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        ArrayList<Filter> predicates = new ArrayList<>();
        predicates.add(new CountryFilter(new Country("Macedonia")));
        predicates.add(new AgeFilter(new Age(17)));
        CompositeFilter compositeFilter = new CompositeFilter(predicates);
        assertEquals(true, compositeFilter.test(guests.get(0)));
    }

    @Test
    public void test_returns_false_if_guest_doesnot_satisfy_any_conditions() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        ArrayList<Filter> predicates = new ArrayList<>();
        predicates.add(new CountryFilter(new Country("Macedonia")));
        predicates.add(new AgeFilter(new Age(20)));
        CompositeFilter compositeFilter = new CompositeFilter(predicates);
        assertEquals(false, compositeFilter.test(guests.get(0)));
    }
}