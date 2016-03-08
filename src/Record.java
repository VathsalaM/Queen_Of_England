import java.util.HashMap;
import java.util.Objects;

public class Record extends HashMap {

    private String[] fields;
    private HashMap<String, Guest> labelList;
    private HashMap<String, String> labelTable;

    public HashMap<String, Guest> getLabelList() {
        return labelList;
    }


    public Record(String[] fields) {
        this.fields = fields;
    }

    public void create(String listOfrecordInString) {
        labelList = new HashMap<>();
        labelTable = new HashMap<>();
        String[] listOfRecords = this.split(listOfrecordInString, "\n");
        for (String guestDetailsInString : listOfRecords) {
            String[] guestDetails = this.split(guestDetailsInString, ",");
            Guest guest = new Guest(guestDetails);
            String[] delimiters = generateDelimiters();
            String label = guest.represent(this.fields, delimiters);
            labelList.put(""+label.hashCode(), guest);
            labelTable.put(""+label.hashCode(),label);
        }
    }

    private String[] generateDelimiters() {
        String[] delimiters = new String[this.fields.length];
        delimiters[0] = " ";
        if (delimiters.length < 1)
            return delimiters;
        delimiters[1] = Objects.equals(fields[1], "firstName") ? " " : ", ";
        for (int i = 2; i < delimiters.length - 1; i++)
            delimiters[i] = ", ";
        delimiters[delimiters.length - 1] = "";
        return delimiters;
    }

    private String[] split(String stringToBeSplitted, String delimiter) {
        String[] splittedString = stringToBeSplitted.split(delimiter);
        return splittedString[0] == "" ? new String[0] : splittedString;
    }

    public String print() {
        String result = "";
        String labelsString = labelList.keySet().toString();
        String[] labels = labelsString.substring(1, labelsString.length() - 1).split(", ");
        for (String label : labels) {
            result += labelTable.get(label);
        }
        return result;
    }
}
