package PeopleTest;

import com.tw.People.Person.Age;
import org.junit.Assert;
import org.junit.Test;

public class AgeTest {
    @Test
    public void isAbove_checks_weather_the_given_age_is_greter_than_the_current_age() throws Exception {
        Assert.assertEquals(false,new Age(18).isAbove(new Age(20)));
        Assert.assertEquals(true,new Age(21).isAbove(new Age(20)));
    }
}