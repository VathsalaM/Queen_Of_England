//package Library;
//import Person.Age;
//import Person.Country;
//import Person.Guest;
//
//import java.util.HashMap;
//import java.util.HashSet;
//
//public class Filter {
//    public static boolean check(String checkOption, String parameters, Guest guest) {
//        if(checkOption.equals("country"))
//            return countryCheck(parameters,guest);
//        if(checkOption.equals("ageAbove"))
//            return ageCheck(parameters, guest, "equal");
//        return false;
//    }
//
//    private static boolean ageCheck(String parameters, Guest guest, String above) {
//        Age age = new Age(Integer.parseInt(parameters));
//        return guest.isAgeValid(above,age);
//    }
//
//    private static boolean countryCheck(String parameters,Guest guest) {
//        Country country = new Country(parameters);
//        return guest.isSameCountry(country);
//    }
//
//    public static boolean chechAllConditions(HashMap<String, String> conditions, Guest guest) {
//        HashSet<Boolean> conditionSatisfied = new HashSet<>();
//        for (String condition : conditions.keySet()) {
//            conditionSatisfied.add(check(condition,conditions.get(condition),guest));
//        }
//        return conditionSatisfied.size()==1 && conditionSatisfied.contains(true);
//    }
//}
