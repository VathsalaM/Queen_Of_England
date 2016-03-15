package Person;
public class Country {
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Country country = (Country) o;
        return name.equals(country.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
