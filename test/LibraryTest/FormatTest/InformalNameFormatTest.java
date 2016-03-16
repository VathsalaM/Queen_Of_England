package LibraryTest.FormatTest;

import com.tw.Library.Formats.InformalNameFormat;
import com.tw.Library.Generate;
import com.tw.People.Person.Guest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InformalNameFormatTest {
    @Test
    public void value_returns_formal_name_of_the_given_test() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        String expected = "Ms Julius Barrows";
        InformalNameFormat informalNameFormat = new InformalNameFormat();
        assertEquals(expected,informalNameFormat.value(guests.get(0)));
    }

}