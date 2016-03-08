import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintLabel {

    private final String[] commands;
    private String fileName;

    public PrintLabel(String[] commands) {
        ArgumentSeperator argumentSeperator = new ArgumentSeperator();
        this.commands = argumentSeperator.extractFeilds(commands);
        this.fileName = argumentSeperator.toString();
    }

    private Record createLabel() throws IOException {
        Record record = new Record(commands);
        String listOfRecords = readFile(fileName);
        record.create(listOfRecords);
        return record;
    }

    public void print() throws IOException {
        Record record = this.createLabel();
        String outPutLabels = record.print();
        System.out.println(outPutLabels);
    }

    private String readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        char[] cbuff = new char[(int) file.length()];
        fileReader.read(cbuff);
        return new String(cbuff);
    }

}
