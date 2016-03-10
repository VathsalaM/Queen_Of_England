public class City {
    private final String name;

    public City(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        City city = (City) o;
        return name.equals(city.name);

    }
}
