package LibraryTest.PredicatesTest;

import com.tw.Library.Generate;
import com.tw.Library.Predicates.CountryPredicate;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Guest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CountryPredicateTest {
    @Test
    public void test_tests_whether_the_guest_satisfies_the_given_threshold_condition() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        CountryPredicate countryPredicate = new CountryPredicate(new Country("Macedonia"));
        Assert.assertEquals(true,countryPredicate.test(guests.get(0)));
    }

}