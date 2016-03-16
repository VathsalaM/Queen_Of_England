package LibraryTest.FormatTest;

import com.tw.Library.Formats.FormalNameFormat;
import com.tw.Library.Generate;
import com.tw.People.Person.Guest;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FormalNameFormatTest {
    @Test
    public void value_returns_formal_name_of_the_given_test() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guests = new Generate().guestList(listOfRecords);
        String expected = "Ms Barrows, Julius";
        FormalNameFormat formalNameFormat = new FormalNameFormat();
        assertEquals(expected,formalNameFormat.value(guests.get(0)));
    }
}