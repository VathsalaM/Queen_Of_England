package LibraryTest.PredicatesTest;

import com.tw.Library.Filter.AgeFilter;
import com.tw.Library.Generate;
import com.tw.People.Person.Age;
import com.tw.People.Person.Guest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AgeGuestListFilterTest {
    @Test
    public void test_tests_whether_the_guest_satisfies_the_given_threshold_condition() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        AgeFilter ageFilter = new AgeFilter(new Age(20));
        Assert.assertEquals(false, ageFilter.test(guests.get(0)));
    }
}