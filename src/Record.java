import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

class Record extends HashMap {

    private String listOfRecords;

    public Record(String listOfRecords) {
        this.listOfRecords = listOfRecords;
    }

    public ArrayList<Guest> create(HashMap<String,String> conditions) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        ArrayList<Guest> guestList = Generate.guestList(listOfRecords);
        ArrayList<Guest> records = new ArrayList<>();
        if(conditions.size()==0)
            return guestList;
        for (Guest guest : guestList) {
            if(Condition.chechAllConditions(conditions,guest))
                records.add(guest);
        }
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Record record = (Record) o;
        return listOfRecords.equals(record.listOfRecords);

    }
}
