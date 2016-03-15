//package PrintTest;
//
//import Library.Generate;
//import Person.Guest;
//import Print.*;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class RepresentTest {
//    @Test
//    public void findMaxLength_finds_the_max_length_of_all_the_strings_given() throws Exception {
//        Represent represent = new Represent();
//        int actualLength = represent.findMaxLength("hello", "how are you", "I am awesome");
//        assertEquals(12, actualLength);
//    }
//
//    @Test
//    public void addSpace_adds_extra_space_for_the_string_and_returns_the_string() throws Exception {
//        Represent represent = new Represent();
//        String actualString = represent.addChar("hello", 15, ' ');
//        assertEquals(" hello           ", actualString);
//    }
//
//    @Test
//    public void addBorder_adds_borderaccross_the_given_String() throws Exception {
//        Represent represent = new Represent();
//        String actual = represent.addBorder(" how   ", " are   ", " you   ");
//        String expected = "+-------+\n" +
//                "| how   |\n" +
//                "|-------|\n" +
//                "| are   |\n" +
//                "| you   |\n" +
//                "+-------+\n";
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void print_with_two_arguments_takes_format_and_guest_list_and_returns_bordered_label() throws Exception {
//        Represent represent = new Represent();
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
//        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat> formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new FormalNameFormat());
//        CompositeFormat cityAndState = new CompositeFormat(new CityAndStateFormat());
//        CompositeFormat country = new CompositeFormat(new CountryFormat());
//        formats.add(format);
//        formats.add(cityAndState);
//        formats.add(country);
//        String actualLabel = represent.borderedLabel(formats, guestList);
//        String expectedLabel = "+---------------------+\n" +
//                "| Ms Barrows, Julius  |\n" +
//                "|---------------------|\n" +
//                "| Veda haven, Vermont |\n" +
//                "| Macedonia           |\n" +
//                "+---------------------+\n";
//        assertEquals(expectedLabel, actualLabel);
//    }
//
//    @Test
//    public void label_takes_format_and_guest_list_and_returns_the_name_according_to_the_format() throws Exception {
//        Represent represent = new Represent();
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
//        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat> formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new FormalNameFormat());
//        formats.add(format);
//        String actualLabel = represent.label(formats, guestList);
//        String expectedlabel = "Ms Barrows, Julius";
//        assertEquals(expectedlabel, actualLabel);
//    }
//
//    @Test
//    public void print_prints_name_with_fields_when_fields_are_present() throws Exception {
//        Represent represent = new Represent();
//        ArrayList<String> arguments = new ArrayList<>();
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
//        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat> formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new FormalNameFormat());
//        CompositeFormat age = new CompositeFormat(new AgeFormat());
//        formats.add(format);
//        formats.add(age);
//        String actual = represent.label(formats, guestList);
//        String expected = "Ms Barrows, Julius, 18";
//        assertEquals(expected, actual);
//    }
//}