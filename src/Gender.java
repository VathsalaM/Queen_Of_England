import java.util.HashMap;

public class Gender {
    private final String gender;
    private HashMap<String,String> prefix = new HashMap();

    public Gender(String gender) {

        this.gender = gender;
        prefix.put("Male","Mr");
        prefix.put("Female","Ms");
    }

    public String findPrefix() {
        return prefix.get(gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Gender gender1 = (Gender) o;
        return gender.equals(gender1.gender) && prefix.equals(gender1.prefix) ;
    }
}
