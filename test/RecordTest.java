import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RecordTest {
    @Test
    public void create_takes_records_in_string_form_and_creates_a_record_of_guest() throws Exception {
        String[] fields = {"prefix","firstName","lastName"};
        String[] guestDetails = {"Julius","Barrows","Female","18","Veda haven","Vermont","Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<Integer,Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put("Ms Julius Barrows\n".hashCode(),new Guest(guestDetails));
        assertTrue(record.equals(expectedListOfRecords));
    }

    @Test
    public void the_record_is_created_in_the_form_of_the_fields_given_to_the_label() throws Exception {
        String[] fields = {"prefix","lastName","firstName"};
        String[] guestDetails = {"Julius","Barrows","Female","18","Veda haven","Vermont","Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<Integer,Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put("Ms Barrows, Julius\n".hashCode(),new Guest(guestDetails));
        assertTrue(record.equals(expectedListOfRecords));
    }
    @Test
    public void create_creates_label_containing_name_with_country_name() throws Exception {
        String[] fields = {"prefix","lastName","firstName","country"};
        String[] guestDetails = {"Julius","Barrows","Female","18","Veda haven","Vermont","Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<Integer,Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put("Ms Barrows, Julius, Macedonia\n".hashCode(),new Guest(guestDetails));
        assertTrue(record.equals(expectedListOfRecords));
    }

    @Test
    public void equals_returns_false_if_the_object_compared_is_not_of_the_same_type() throws Exception {
        String[] fields = {"prefix","firstName","lastName"};
        String[] guestDetails = {"Julius","Barrows","Female","18","Veda haven","Vermont","Macedonia"};
        Record record = new Record(fields);
        record.create("Julius,Barrows,Female,18,Veda haven,Vermont,Macedonia");
        HashMap<Integer,Guest> expectedListOfRecords = new HashMap<>();
        expectedListOfRecords.put("Ms Julius Barrows\n".hashCode(),new Guest(guestDetails));
        assertFalse(record.equals(expectedListOfRecords.toString()));
    }
}