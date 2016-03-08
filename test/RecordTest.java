import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class RecordTest {
    @Test
    public void create_takes_records_in_string_form_and_creates_a_record_of_guest() throws Exception {
        String[] fields = {"prefix", "firstName", "lastName"};
        String[] guestDetails = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<String , Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put(""+"Ms Julius Barrows\n".hashCode(), new Guest(guestDetails));
        assertEquals(record.getLabelList(),expectedListOfRecords);
    }

    @Test
    public void the_record_is_created_in_the_form_of_the_fields_given_to_the_label() throws Exception {
        String[] fields = {"prefix", "lastName", "firstName"};
        String[] guestDetails = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<String,Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put(""+"Ms Barrows, Julius\n".hashCode(), new Guest(guestDetails));
        assertEquals(record.getLabelList(),expectedListOfRecords);
    }

    @Test
    public void create_creates_label_containing_name_with_country_name() throws Exception {
        String[] fields = {"prefix", "lastName", "firstName", "country"};
        String[] guestDetails = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<String,Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put(""+"Ms Barrows, Julius, Macedonia\n".hashCode(), new Guest(guestDetails));
        assertEquals(record.getLabelList(),expectedListOfRecords);
    }

    @Test
    public void equals_returns_false_if_the_object_compared_is_not_of_the_same_type() throws Exception {
        String[] fields = {"prefix", "firstName", "lastName"};
        String[] guestDetails = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<String , Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put(""+"Ms Julius Barrows\n".hashCode(), new Guest(guestDetails));
        assertEquals(record.getLabelList(),expectedListOfRecords);
    }

    @Test
    public void getSpecific_gets_the_records_of_the_specified_country() throws Exception {
        String[] fields = {"prefix", "firstName", "lastName","country"};
        String[] guestDetails = {"Julius", "Barrows", "Female", "18", "Veda haven", "Vermont", "Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<String , Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put(""+"Ms Julius Barrows, Macedonia\n".hashCode(), new Guest(guestDetails));
        assertEquals(record.getLabelList(),expectedListOfRecords);
    }

    @Test
    public void print_prints_the_labels() throws Exception {
        String[] fields = {"prefix", "firstName", "lastName","country"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        String actual = record.print();
        String expected = "Ms Julius Barrows, Macedonia\n";
        assertEquals(expected,actual);
    }
    @Test
    public void print_prints_the_multiple_labels_in_different_line() throws Exception {
        String[] fields = {"prefix", "firstName", "lastName","country"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia\nMelody,Dooley,Female,31,West Shanna,Vermont,Bangladesh");
        String actual = record.print();
        String expected = "Ms Melody Dooley, Bangladesh\nMs Julius Barrows, Macedonia\n";
        assertEquals(expected,actual);
    }
}