class Guest {
    private final Name name;
    private final Gender gender;
    private final Age age;
    private final Address address;

    public Guest(Name name, Gender gender, Age age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public boolean isSameCountry(Country country) {
        return this.address.isSameCountry(country);
    }
}
