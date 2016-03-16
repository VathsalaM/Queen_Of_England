package com.tw.Library.Reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public String read(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        char[] characterBuffer = new char[(int) file.length()];
        fileReader.read(characterBuffer);
        return new String(characterBuffer);
    }
}
