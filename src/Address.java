public class Address {
    private final City city;
    private final State state;
    private final Country country;

    public Address(City city, State state, Country country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public boolean isSameCountry(Country otherCountry) {
        return this.country.equals(otherCountry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Address address = (Address) o;
        return city.equals(address.city) && state.equals(address.state) && country.equals(address.country);

    }

    @Override
    public String toString() {
        return String.format("%s, %s",city.toString(),state.toString());
    }

    public String country() {
        return country.toString();
    }

}
