import java.util.Hashtable;

public class Guest {
    private Hashtable<String, String> details;

    public Guest(String[] details) {
        String[] fields = {"firstName","lastName","gender","age","city","state","country"};
        this.details = new Hashtable<String, String>();
        for (int i=0;i<details.length;i++)
            this.details.put(fields[i],details[i]);
        String genderDetails = this.details.get("gender");
        Gender gender = new Gender(genderDetails);
        this.details.put("prefix",gender.toString());
    }

    public String represent(String[] fields, String[] delimiters) {
        String label = "";
        for (int i=0;i<fields.length;i++)
          label+=details.get(fields[i])+delimiters[i];
        return label+"\n";
    }

    @Override
    public String toString() {
        return details.toString() ;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
