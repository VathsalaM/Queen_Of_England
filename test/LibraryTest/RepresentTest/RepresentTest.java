package LibraryTest.RepresentTest;

import com.tw.Library.Formats.Format;
import com.tw.Library.Formats.InformalNameFormat;
import com.tw.Library.Generate;
import com.tw.Library.Represent.Represent;
import com.tw.People.Person.Guest;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RepresentTest {
    @Test
    public void label_returns_the_label_format_of_the_given_guest_list() throws Exception {
        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia";
        ArrayList<Guest> guestList = new Generate().guestList(listOfRecords);
        Represent represent = new Represent();
        Format format = new InformalNameFormat();
        String actual = represent.label(format,guestList);
        String expected="+---------------------+\n" +
                        "| Ms Julius Barrows   |\n" +
                        "|---------------------|\n" +
                        "| Veda haven, Vermont |\n" +
                        "| Macedonia           |\n" +
                        "+---------------------+\n";
        Assert.assertEquals(expected,actual);
    }
}