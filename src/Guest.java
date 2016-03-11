import java.util.HashMap;

class Guest {
    private final Name name;
    private final Gender gender;
    private final Age age;
    private final Address address;
    public String Country;
    private HashMap<String, String> methods;

    public Guest(Name name, Gender gender, Age age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.Country = "hello";
    }

    public boolean isSameCountry(Country country) {
        return this.address.isSameCountry(country);
    }

    public String formalName(String value) {
        return gender.findPrefix() + " " + name.informalName();
    }

    public String informalName(String value) {
        System.out.println("calling ....................");
        return gender.findPrefix() + " " + name.formalName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Guest guest = (Guest) o;
        return name.equals(guest.name) && gender.equals(guest.gender) && age.equals(guest.age) && address.equals(guest.address);

    }

    public String getValue(String command, String value) {
        switch (command) {
            case "formal":
                return formalName(value);
            case "informalName":
                return informalName(value);
            case "country":
                return country(value);
            case "ageAbove":
                return age(value);
            case "address":
                return address.toString();
            default:
                return formalName(value);
        }
    }

    private String gender(String value) {
        return String.format("%s, %s",value,gender.toString());
    }

    private String age(String value) {
        return String.format("%s, %s",value,age.toString());
    }
    private String country(String value) {
        return value+address.country();
    }

    public boolean isAgeValid(String condition, Age age) {
        return this.age.isAbove(age);
    }
}
