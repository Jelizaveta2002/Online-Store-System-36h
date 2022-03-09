package ee.taltech.iti0202.files;

import ee.taltech.iti0202.files.input.FileReaderException;
import ee.taltech.iti0202.files.input.InputFilesLines;
import ee.taltech.iti0202.files.input.InputFilesScanner;
import ee.taltech.iti0202.files.morse.MorseTranslator;
import ee.taltech.iti0202.files.input.InputFilesBufferReader;
import ee.taltech.iti0202.files.output.OutputFilesWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MorseTranslatorTest {

    @org.junit.jupiter.api.Test
    void addMorseCodesBufferReader() {
        MorseTranslator translator = new MorseTranslator();
        InputFilesBufferReader reader = new InputFilesBufferReader();
        HashMap<String, String> result = new HashMap<>();
        result.put("a", ".-");
        result.put("b", "-...");
        result.put("c", "-.-.");
        result.put("d", "-..");
        assertEquals(result, translator.addMorseCodes(reader.readTextFromFile("C:\\Users\\volos\\IdeaProjects\\iti0202-2022\\EX" +
                "\\EX06Files\\src\\ee\\taltech\\iti0202\\files\\input\\morse.txt")));
    }

    @org.junit.jupiter.api.Test
    void addMorseCodesScanner() {
        MorseTranslator translator = new MorseTranslator();
        InputFilesScanner reader = new InputFilesScanner();
        HashMap<String, String> result = new HashMap<>();
        result.put("a", ".-");
        result.put("b", "-...");
        result.put("c", "-.-.");
        result.put("d", "-..");
        assertEquals(result, translator.addMorseCodes(reader.readTextFromFile("C:\\Users\\volos\\IdeaProjects" +
                "\\iti0202-2022\\EX\\EX06Files\\src\\ee\\taltech\\iti0202\\files\\input\\morse.txt")));
    }

    @org.junit.jupiter.api.Test
    void addMorseCodesFilesLines() {
        MorseTranslator translator = new MorseTranslator();
        InputFilesLines reader = new InputFilesLines();
        HashMap<String, String> result = new HashMap<>();
        result.put("a", ".-");
        result.put("b", "-...");
        result.put("c", "-.-.");
        result.put("d", "-..");
        assertEquals(result, translator.addMorseCodes(reader.readTextFromFile("C:\\Users\\volos\\IdeaProjects\\iti0202-2022\\EX\\EX06Files\\src" +
                "\\ee\\taltech\\iti0202\\files\\input\\morse.txt")));
    }

    @Test
    void readFileFail1() {
        InputFilesBufferReader reader = new InputFilesBufferReader();
        try {
            assertThrows(FileReaderException.class,
                    (Executable) reader.readTextFromFile(""), "No such file");
        } catch (FileReaderException ignored) {
        }
    }

    @Test
    void readFileFail2() {
        InputFilesLines reader = new InputFilesLines();
        try {
            assertThrows(FileReaderException.class,
                    (Executable) reader.readTextFromFile(""), "No such file");
        } catch (FileReaderException ignored) {
        }
    }

    @Test
    void readFileFail3() {
        InputFilesScanner reader = new InputFilesScanner();
        try {
            assertThrows(FileReaderException.class,
                    (Executable) reader.readTextFromFile(""), "No such file");
        } catch (FileReaderException ignored) {
        }
    }

    @org.junit.jupiter.api.Test
    void writeLinesToFile() {
        OutputFilesWriter writer = new OutputFilesWriter();
        ArrayList<String> listWithWords = new ArrayList<>();
        listWithWords.add("flower");
        listWithWords.add("spring");
        listWithWords.add("sun");
        assertTrue(writer.writeLinesToFile(listWithWords, "C:\\Users\\volos\\IdeaProjects\\iti0202-2022" +
                "\\EX\\EX06Files\\src\\ee\\taltech\\iti0202\\files\\input\\check.txt"));
    }


    @org.junit.jupiter.api.Test
    void translateLinesToMorse() {
        MorseTranslator translator = new MorseTranslator();
        ArrayList<String> list = new ArrayList<>();
        InputFilesBufferReader reader = new InputFilesBufferReader();
        translator.addMorseCodes(reader.readTextFromFile("C:\\Users\\volos\\IdeaProjects\\iti0202-2022\\EX\\EX06Files" +
                "\\src\\ee\\taltech\\iti0202\\files\\input\\morse.txt"));
        list.add("a");
        list.add("d");
        list.add("cd ad");
        ArrayList<String> result = new ArrayList<>();
        result.add(".-");
        result.add("-..");
        result.add("-.-. -..\t.- -..");
        assertEquals(result, translator.translateLinesToMorse(list));
    }

    @org.junit.jupiter.api.Test
    void translateLinesFromMorse() {
        MorseTranslator translator = new MorseTranslator();
        ArrayList<String> list = new ArrayList<>();
        InputFilesBufferReader reader = new InputFilesBufferReader();
        translator.addMorseCodes(reader.readTextFromFile("C:\\Users\\volos\\IdeaProjects\\iti0202-2022\\EX" +
                "\\EX06Files\\src\\ee\\taltech\\iti0202\\files\\input\\morse.txt"));
        list.add(".-");
        list.add("-..");
        list.add("-.-. -..\t.- -..");
        ArrayList<String> result = new ArrayList<>();
        result.add("a");
        result.add("d");
        result.add("cd ad");
        assertEquals(result, translator.translateLinesFromMorse(list));
    }
}
