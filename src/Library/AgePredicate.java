package Library;

import Person.Age;
import Person.Guest;

public class AgePredicate implements Filters {
    private Age age;

    public AgePredicate(String age) {

        this.age = new Age(Integer.parseInt(age));
    }

    @Override
    public boolean test(Guest guest) {
        return guest.isAgeValid(age);
    }
}
