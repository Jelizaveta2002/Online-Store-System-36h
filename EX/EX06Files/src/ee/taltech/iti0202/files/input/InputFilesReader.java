package ee.taltech.iti0202.files.input;

import java.util.List;

public interface InputFilesReader {

    /**
     * Write lines.
     */
    List<String> readTextFromFile(String filename);

}
