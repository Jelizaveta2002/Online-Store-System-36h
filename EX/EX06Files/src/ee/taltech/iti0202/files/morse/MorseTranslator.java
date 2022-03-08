package ee.taltech.iti0202.files.morse;
import java.util.*;

public class MorseTranslator {
    private final Map<String, String> mapWithMorse = new HashMap<>();

    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            String key = String.valueOf(line.charAt(0));
            StringBuilder newBuilder = new StringBuilder();
            newBuilder.append(line);
            newBuilder.deleteCharAt(0);
            mapWithMorse.put(key.toLowerCase(Locale.ROOT), newBuilder.toString().trim());
        }
        return mapWithMorse;
    }

    public List<String> translateLinesToMorse(List<String> lines) {
        List<String> listOfLines = new ArrayList<>();
        for (String line : lines) {
            String newLine = translateLineToMorse(line);
            listOfLines.add(newLine);
        }
        return listOfLines;
    }

    public List<String> translateLinesFromMorse(List<String> lines) {
        return null;
    }

    private String translateLineToMorse(String line) {
        StringBuilder newBuilder = new StringBuilder();
        for (char str : line.toCharArray()) {
            String s = String.valueOf(str);
            if (!s.equals(" ")) {
                newBuilder.append(mapWithMorse.get(s.toLowerCase(Locale.ROOT)));
                newBuilder.append(" ");
            } else {
                newBuilder.append("    ");
            }
        }
        return newBuilder.toString();
    }

    private String translateLineFromMorse(String line) {
        return null;
    }

    public static void main(String[] args) {
        MorseTranslator translator = new MorseTranslator();
        List<String> newList = new ArrayList<>();
        newList.add("L--");
        newList.add("I, --..--");
        newList.add("Z--..--");
        newList.add("A.--");
        translator.addMorseCodes(newList);
        System.out.println(translator.translateLineToMorse("liza az"));
    }
}
