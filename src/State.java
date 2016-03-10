public class State {
    private final String name;

    public State(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        State state = (State) o;
        return name.equals(state.name);

    }
}
