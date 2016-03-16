package com.tw.Library;

import com.tw.Library.Filter.AgeFilter;
import com.tw.Library.Filter.CompositeFilter;
import com.tw.Library.Filter.CountryFilter;
import com.tw.Library.Filter.Filter;
import com.tw.Library.Formats.FormalNameFormat;
import com.tw.Library.Formats.Format;
import com.tw.Library.Formats.InformalNameFormat;
import com.tw.People.Person.Address.Country;
import com.tw.People.Person.Age;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Add {
    public static CompositeFilter filters(HashMap<String, String> conditions) {
        ArrayList<Filter> predicates = new ArrayList<>();
        Set<String> conditionSet = conditions.keySet();
        if (conditionSet.contains("country"))
            predicates.add(new CountryFilter(new Country(conditions.get("country"))));
        if (conditionSet.contains("ageAbove"))
            predicates.add(new AgeFilter(new Age(Integer.parseInt(conditions.get("ageAbove")))));
        return new CompositeFilter(predicates);
    }

    public static Format format(Set<String> commands) {
        if (commands.contains("formal"))
            return new FormalNameFormat();
        return new InformalNameFormat();
    }
}
