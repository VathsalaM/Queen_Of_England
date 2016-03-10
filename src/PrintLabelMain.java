import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

class PrintLabelMain {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PrintLabel printLabel = new PrintLabel(args);
        printLabel.print();
    }
}
