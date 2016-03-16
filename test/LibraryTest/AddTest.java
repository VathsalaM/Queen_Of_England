package LibraryTest;

import com.tw.Library.Add;
import com.tw.Library.Formats.FormalNameFormat;
import com.tw.Library.Formats.Format;
import com.tw.Library.Predicates.CompositePredicate;
import com.tw.Library.Predicates.CountryPredicate;
import com.tw.Library.Predicates.Predicates;
import com.tw.People.Person.Address.Country;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AddTest {
    @Test
    public void prdicates_adds_the_predicates_according_to_the_conditions() throws Exception {
        HashMap<String,String> conditions = new HashMap<>();
        conditions.put("country","Bangladesh");
        CompositePredicate actualPredicates = new Add().predicates(conditions);
        ArrayList<Predicates> predicates = new ArrayList<>();
        predicates.add(new CountryPredicate(new Country("Bangladesh")));
        CompositePredicate expectedPredicates = new CompositePredicate(predicates);
        assertEquals(expectedPredicates,actualPredicates);
    }
    @Test
    public void formats_returns_formal_or_informal_format_according_to_the_command() throws Exception {
        Set<String> commands = new HashSet<>();
        commands.add("formal");
        Format actualFormat = new Add().format(commands);
        Format expectedFormat = new FormalNameFormat();
        assertEquals(expectedFormat,actualFormat);
    }
}