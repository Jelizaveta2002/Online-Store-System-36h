package ee.taltech.iti0202.files.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> newList = new ArrayList<>();
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                newList.add(line);
            }
            fr.close();
        } catch (Exception e) {
            throw new FileReaderException(e, "No such file");
        }
        return newList;
    }

    public static void main(String[] args) {
        InputFilesBufferReader newReader = new InputFilesBufferReader();
        System.out.println(newReader.readTextFromFile("C:\\temp\\text_jva_.txt"));
    }
}
