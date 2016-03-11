import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class PrintLabel {
    private String[] arguments;
    private Set<String> commands;
    private String fileName;
    private HashMap<String, String> conditions;

    public PrintLabel(String[] arguments) {
        this.arguments = arguments;
    }

    public void print() throws IOException, NoSuchMethodException, InstantiationException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        ArrayList<Guest> guestList = this.createGuestList(arguments);
        Represent represent = new Represent();
        if (commands.contains("borderedLabel")) {
            represent.print(commands, guestList);
            return;
        }
        else
            represent.print(commands, conditions.keySet(), guestList);
    }

    private ArrayList<Guest> createGuestList(String[] arguments) throws IOException, NoSuchMethodException, InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        ArgumentSeparator argumentSeparator = new ArgumentSeparator(arguments);
        commands = argumentSeparator.separate();
        fileName = argumentSeparator.toString();
        conditions = argumentSeparator.getConditions();
        String listOfRecords = readFile(fileName);
        Record record = new Record(listOfRecords);
        return record.create(conditions);
    }

    private String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        char[] characterBuffer = new char[(int) file.length()];
        fileReader.read(characterBuffer);
        return new String(characterBuffer);
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PrintLabel printLabel = new PrintLabel(args);
        printLabel.print();
    }

}
