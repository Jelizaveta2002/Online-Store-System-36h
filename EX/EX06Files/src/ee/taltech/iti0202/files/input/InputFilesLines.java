package ee.taltech.iti0202.files.input;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputFilesLines implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> newList = new ArrayList<>();
        File file = new File(filename);
        try (Stream<String> stream = Files.lines(Paths.get(file.toString()))) {
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
}
