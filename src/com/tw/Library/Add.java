package com.tw.Library;

import com.tw.Library.Formats.FormalNameFormat;
import com.tw.Library.Formats.Format;
import com.tw.Library.Formats.InformalNameFormat;
import com.tw.Library.Predicates.AgePredicate;
import com.tw.Library.Predicates.CompositePredicate;
import com.tw.Library.Predicates.CountryPredicate;
import com.tw.Library.Predicates.Predicates;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Add {
    public CompositePredicate predicates(HashMap<String, String> conditions) {
        ArrayList<Predicates> predicates = new ArrayList<>();
        Set<String> conditionSet = conditions.keySet();
        if (conditionSet.contains("country"))
            predicates.add(new CountryPredicate(new Country(conditions.get("country"))));
        if (conditionSet.contains("ageAbove"))
            predicates.add(new AgePredicate(new Age(Integer.parseInt(conditions.get("ageAbove")))));
        return new CompositePredicate(predicates);
    }

    public Format format(Set<String> commands) {
        if (commands.contains("formal"))
            return new FormalNameFormat();
        return new InformalNameFormat();
    }
}
