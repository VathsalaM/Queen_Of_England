package Library;

import Person.Country;
import Person.Guest;

import java.util.HashMap;

public class Condition {
    public static boolean check(String checkOption, String parameters, Guest guest) {
        if(checkOption.toLowerCase().equals("country"))
            return countryCheck(parameters,guest);
        return false;
    }

    private static boolean countryCheck(String parameters,Guest guest) {
        Country country = new Country(parameters);
        return guest.isSameCountry(country);
    }

    public static boolean chechAllConditions(HashMap<String, String> conditions, Guest guest) {
        boolean conditionSatisfied = false;
        for (String condition : conditions.keySet()) {
            conditionSatisfied=check(condition,conditions.get(condition),guest);
        }
        return conditionSatisfied;
    }
}
