package Person;
import java.util.HashMap;

public class Guest {
    private final Name name;
    private final Gender gender;
    private final Age age;
    private final Address address;
    private HashMap<String, String> methods;

    public Guest(Name name, Gender gender, Age age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String formalName() {
        return gender.findPrefix() + " " + name.informalName();
    }

    public String informalName() {
        return gender.findPrefix() + " " + name.formalName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Guest guest = (Guest) o;
        return name.equals(guest.name) && gender.equals(guest.gender) && age.equals(guest.age) && address.equals(guest.address);

    }
    public String age() {
        return age.toString();
    }
    public String country() {
        return address.country();
    }
    public String cityAndState(){
        return address.toString();
    }
}
