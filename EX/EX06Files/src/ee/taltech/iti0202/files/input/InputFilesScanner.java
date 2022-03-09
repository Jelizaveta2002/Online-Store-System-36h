package ee.taltech.iti0202.files.input;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFilesScanner implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> newList = new ArrayList<>();
        File file = new File(filename);
        try {
            FileReader fr = new FileReader(file);
            Scanner sc = new Scanner(fr);
            while ((sc.hasNextLine())) {
                newList.add(sc.nextLine());
            }
            fr.close();
        } catch (Exception e) {
            throw new FileReaderException(e, "No such file");

        }
        return newList;
    }

    public static void main(String[] args) {
        InputFilesScanner newReader = new InputFilesScanner();
        System.out.println(newReader.readTextFromFile("C:\\temp\\text_jva_ex06.txt"));

    }
}
