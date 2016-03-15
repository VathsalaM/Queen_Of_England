//package PrintTest;
//
//import Library.Generate;
//import Library.People;
//import Person.Guest;
//import Print.*;
//import org.junit.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.assertEquals;
//
//public class PeopleTest {
//    @Test
//    public void print_returns_bordered_name_when_borderedLabel_argument_is_present_and_format_is_informal() throws Exception {
////        People people = new People();
//        ArrayList<String> arguments = new ArrayList<>();
//        arguments.add("borderedLabel");
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
////        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat > formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new InformalNameFormat());
//        CompositeFormat cityAndState = new CompositeFormat(new CityAndStateFormat());
//        CompositeFormat country = new CompositeFormat(new CountryFormat());
//        formats.add(format);
//        formats.add(cityAndState);
//        formats.add(country);
////        String actual = people.print(arguments,formats,guestList);
//        String expected = "+---------------------+\n" +
//                "| Ms Julius Barrows   |\n" +
//                "|---------------------|\n" +
//                "| Veda haven, Vermont |\n" +
//                "| Macedonia           |\n" +
//                "+---------------------+\n";
////        assertEquals(expected,actual);
//    }
//    @Test
//    public void print_returns_bordered_name_when_borderedLabel_argument_is_present_and_format_is_formal() throws Exception {
//        People people = new People();
//        ArrayList<String> arguments = new ArrayList<>();
//        arguments.add("borderedLabel");
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
//        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat> formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new FormalNameFormat());
//        CompositeFormat cityAndState = new CompositeFormat(new CityAndStateFormat());
//        CompositeFormat country = new CompositeFormat(new CountryFormat());
//        formats.add(format);
//        formats.add(cityAndState);
//        formats.add(country);
//        String actual = people.print(arguments,formats,guestList);
//        String expected = "+---------------------+\n" +
//                "| Ms Barrows, Julius  |\n" +
//                "|---------------------|\n" +
//                "| Veda haven, Vermont |\n" +
//                "| Macedonia           |\n" +
//                "+---------------------+\n";
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    public void print_prints_normal_label_with_formal_format_when_there_are_no_arguments() throws Exception {
//        People people = new People();
//        ArrayList<String> arguments = new ArrayList<>();
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
//        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat> formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new FormalNameFormat());
//        CompositeFormat cityAndState = new CompositeFormat(new CityAndStateFormat());
//        CompositeFormat country = new CompositeFormat(new CountryFormat());
//        formats.add(format);
//        String actual = people.print(arguments,formats,guestList);
//        String expected = "Ms Barrows, Julius";
//        assertEquals(expected,actual);
//    }
//
//    @Test
//    public void print_prints_name_with_fields_when_fields_are_present() throws Exception {
//        People people = new People();
//        ArrayList<String> arguments = new ArrayList<>();
//        String listOfRecords = "Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\n";
//        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
//        ArrayList<CompositeFormat> formats = new ArrayList<>();
//        CompositeFormat format = new CompositeFormat(new FormalNameFormat());
//        CompositeFormat age = new CompositeFormat(new AgeFormat());
//        formats.add(format);
//        formats.add(age);
//        String actual = people.print(arguments,formats,guestList);
//        String expected = "Ms Barrows, Julius, 18";
//        assertEquals(expected,actual);
//    }
//}