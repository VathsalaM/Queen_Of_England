import java.io.IOException;

public class PrintLabelMain {
    public static void main(String[] args) throws IOException {
        PrintLabel printLabel = new PrintLabel(args);
        printLabel.print();
    }
}
