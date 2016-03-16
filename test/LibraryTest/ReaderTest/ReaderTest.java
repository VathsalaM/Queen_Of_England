package LibraryTest.ReaderTest;

import com.tw.Library.Reader.Reader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReaderTest {
    @Test
    public void read_takes_file_name_reads_it_and_returs_the_content_in_string_form() throws Exception {
        Reader reader = new Reader();
        String actual = reader.read("sample.txt");
        String expected = "This is just a sample";
        assertEquals(expected,actual);
    }
}