//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//class PrintLabel {
//
//    private final String[] commands;
//    private final String fileName;
//
//    public PrintLabel(String[] commands) {
//        ArgumentSeparator argumentSeparator = new ArgumentSeparator();
//        this.commands = argumentSeparator.extractFields(commands);
//        this.fileName = argumentSeparator.toString();
//    }
//
//    private Record createLabel() throws IOException {
//        Record record = new Record(commands);
//        String listOfRecords = readFile(fileName);
//        record.create(listOfRecords);
//        return record;
//    }
//
//    public void print() throws IOException {
//        Record record = this.createLabel();
//        String outPutLabels = record.print();
//        System.out.println(outPutLabels);
//    }
//
//    private String readFile(String fileName) throws IOException {
//        File file = new File(fileName);
//        FileReader fileReader = new FileReader(file);
//        char[] characterBuffer = new char[(int) file.length()];
//        fileReader.read(characterBuffer);
//        return new String(characterBuffer);
//    }
//
//}
