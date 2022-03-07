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
        File file=new File(filename);    //creates a new file instance
        try(Stream<String> stream = Files.lines(Paths.get(file.toString())))
        {
            FileReader fr=new FileReader(file);   //reads the file
            Scanner sc=new Scanner(fr);  //creates a buffering character input stream
            String line;
            while((sc.hasNextLine()))
            {
                newList.add(sc.nextLine());      //appends line to string buffer
            }
            fr.close();    //closes the stream and release the resources
        }
        catch(Exception e)
        {
            // e.printStackTrace();
            throw new FileReaderException(e, "No such file");

        }
        return newList;
    }
}