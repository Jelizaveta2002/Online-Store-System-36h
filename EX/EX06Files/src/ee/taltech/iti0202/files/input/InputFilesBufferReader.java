package ee.taltech.iti0202.files.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFilesBufferReader implements InputFilesReader {

    @Override
    public List<String> readTextFromFile(String filename) {
        List<String> newList = new ArrayList<>();
        try
        {
            File file=new File(filename);    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            String line;
            while((line=br.readLine())!=null)
            {
                newList.add(line);      //appends line to string buffer
            }
            fr.close();    //closes the stream and release the resources
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new FileReaderException(e, "No such file");

        }
        return newList;
    }
}
