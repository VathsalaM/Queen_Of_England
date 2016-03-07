import java.util.Objects;

public class Gender {
    private String gender;

    public Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return Objects.equals(this.gender, "Female") ?"Ms":"Mr";
    }

}
