package ee.taltech.iti0202.files.morse;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

public class MorseTranslator {
    private final Map<String, String> mapWithMorse = new HashMap<>();
    private final Map<String, String> mapKeyIsMorse = new HashMap<>();


    /**
     * Write lines.
     */
    public Map<String, String> addMorseCodes(List<String> lines) {
        for (String line : lines) {
            String key = String.valueOf(line.charAt(0));
            StringBuilder newBuilder = new StringBuilder();
            newBuilder.append(line);
            newBuilder.deleteCharAt(0);
            String key1 = key.toLowerCase(Locale.ROOT);
            String trim = newBuilder.toString().trim();
            mapWithMorse.put(key1, trim);
            mapKeyIsMorse.put(trim, key.toLowerCase(Locale.ROOT));
        }
        return mapWithMorse;
    }


    /**
     * Write lines.
     */
    public List<String> translateLinesToMorse(List<String> lines) {
        ArrayList<String> listOfLines = new ArrayList<>();
        for (String line : lines) {
            String newLine = translateLineToMorse(line);
            listOfLines.add(newLine);
        }
        return listOfLines;
    }


    /**
     * Write lines.
     */
    public List<String> translateLinesFromMorse(List<String> lines) {
        List<String> listOfLines = new ArrayList<>();
        for (String line : lines) {
            String newLine = translateLineFromMorse(line);
            listOfLines.add(newLine);
        }
        return listOfLines;
    }


    /**
     * Write lines.
     */
    private String translateLineToMorse(String line) {
        StringBuilder newBuilder = new StringBuilder();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char str = chars[j];
                String s = String.valueOf(str);
                newBuilder.append(mapWithMorse.get(s.toLowerCase(Locale.ROOT)));
                if (j < chars.length - 1) {
                    newBuilder.append(" ");
                }
            }
            if (i < words.length - 1) {
                newBuilder.append("\t");
            }

        }
        return newBuilder.toString();
    }


    /**
     * Write lines.
     */
    private String translateLineFromMorse(String line) {
        StringBuilder newBuilder = new StringBuilder();
        String[] words = line.split("\\t");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String[] letters = word.split(" ");
            for (int j = 0; j < letters.length; j++) {
                String str = letters[j];
                newBuilder.append(mapKeyIsMorse.get(str));
            }
            if (i < words.length - 1) {
                newBuilder.append(" ");
            }
        }
        return newBuilder.toString();
    }

    public static void main(String[] args) {
        MorseTranslator translator = new MorseTranslator();
        List<String> newList = new ArrayList<>();
        newList.add("L--");
        newList.add("I--..--");
        newList.add("Z--..-.-");
        newList.add("A.--");
        translator.addMorseCodes(newList);
        System.out.println(translator.translateLineFromMorse("-- --..-- --..-.- .--\t--..-- .--"));
    }
}
