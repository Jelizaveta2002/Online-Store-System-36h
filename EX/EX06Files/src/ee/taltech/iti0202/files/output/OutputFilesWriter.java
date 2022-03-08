package ee.taltech.iti0202.files.output;

import ee.taltech.iti0202.files.input.FileReaderException;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class OutputFilesWriter {

    public boolean writeLinesToFile(List<String> lines, String filename) {
        try
        {
            FileWriter myWriter = new FileWriter(filename);
            for (String line : lines) {
                myWriter.write(line);
                myWriter.write("\n");
            }
            myWriter.close();
            return true;
        }
        catch(Exception e)
        {
            // e.printStackTrace();
            throw new FileReaderException(e, "No such file");
        }
    }


    public static void main(String[] args) {
        List<String> newList = new ArrayList<>();
        newList.add("rfvrver");
        newList.add("rfvrver");
        newList.add("rfvrver");
        OutputFilesWriter newWriter = new OutputFilesWriter();
        System.out.println(newWriter.writeLinesToFile(newList,"C:\\temp\\file_.txt"));
    }
}