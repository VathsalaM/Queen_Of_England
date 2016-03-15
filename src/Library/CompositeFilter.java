package Library;

import Person.Guest;

import java.util.ArrayList;

public class CompositeFilter implements Filters {

    private ArrayList<Filters> predicates;

    public CompositeFilter(ArrayList<Filters> predicates) {
        this.predicates = predicates;
    }

    @Override
    public boolean test(Guest guest) {
        for (Filters predicate : this.predicates) {
            if(!predicate.test(guest))
                return false;
        }
        return true;
    }
}
