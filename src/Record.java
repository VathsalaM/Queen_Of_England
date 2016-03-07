import java.util.HashMap;
import java.util.Objects;

public class Record {

    private String[] fields;
    private HashMap<Integer, Guest> labelList;
    private HashMap<String,Integer> labels;

    public Record(String[] fields) {
        this.fields = fields;
    }


    public void create(String listOfrecordInString) {
         labelList = new HashMap<>();
        labels = new HashMap<>();
        String[] listOfRecords = this.split(listOfrecordInString, "\n");
        for (String guestDetailsInString : listOfRecords) {
            String[] guestDetails = this.split(guestDetailsInString, ",");
            Guest guest = new Guest(guestDetails);
            String[] delimiters = generateDelimiters();
            String label = guest.represent(this.fields,delimiters);
            labelList.put(label.hashCode(),guest);
            labels.put(label,label.hashCode());
        }
    }

    private String[] generateDelimiters() {
        String[] delimiters = new String[this.fields.length];
        delimiters[0] = " ";
        if(delimiters.length<1)
            return delimiters;
        delimiters[1] = Objects.equals(fields[1], "firstName") ?" ":", ";
        for (int i = 2; i <delimiters.length-1 ; i++)
            delimiters[i] = ", ";
        delimiters[delimiters.length-1]="";
        return delimiters;
    }

    private String[] split(String stringToBeSplitted, String delimiter) {
        String[] splittedString = stringToBeSplitted.split(delimiter);
        return splittedString[0] == "" ?new String[0]: splittedString;
    }

    @Override
    public String toString() {
        return labelList.toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if(otherObject instanceof HashMap || otherObject instanceof Record)
            return (this.toString().hashCode()==otherObject.toString().hashCode());
        return false;
    }

    public String  print() {
        return labels.keySet().toString();
    }
}
