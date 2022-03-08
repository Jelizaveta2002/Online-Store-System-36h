package ee.taltech.iti0202.files.morse;
import java.util.*;

public class MorseTranslator {

    public Map<String, String> addMorseCodes(List<String> lines) {
        Map<String, String> mapWithMorse = new HashMap<>();
        for (String line : lines) {
            String key = String.valueOf(line.charAt(0));
            StringBuilder newBuilder = new StringBuilder();
            newBuilder.append(line);
            newBuilder.deleteCharAt(0);
            mapWithMorse.put(key.toLowerCase(Locale.ROOT), newBuilder.toString());
        }
        return mapWithMorse;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        return null;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        return null;
    }

    private String translateLineToMorse(String line) {
        return null;
    }

    private String translateLineFromMorse(String line) {
        return null;
    }

    public static void main(String[] args) {
        MorseTranslator translator = new MorseTranslator();
        List<String> newList = new ArrayList<>();
        newList.add("6--");
        newList.add("7, --..--");
        newList.add("0--..--");
        newList.add("U.--");
        System.out.println(translator.addMorseCodes(newList));
    }
}
