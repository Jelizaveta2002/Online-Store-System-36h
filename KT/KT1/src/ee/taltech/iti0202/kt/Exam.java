package ee.taltech.iti0202.kt;

import java.util.ArrayList;
import java.util.Locale;

public class Exam {
    /**
     * Given two strings,
     * find if one string is a rotation of another string.
     * Comparison should be case insensitive ("A" and "a" are the same).
     *
     * rotatedString("piimavunts", "ntspiimavu") => true
     * rotatedString("ABC", "cab") => true
     * rotatedString("kurgid", "gikur") => false
     */
    public static boolean rotatedString(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i);
            String b = Character.toString(a);
            list1.add(b);
        }
        for (int i = 0; i < str2.length(); i++) {
            char a = str2.charAt(i);
            String b = Character.toString(a);
            list2.add(b);
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        for (String ch : list1) {
            if (!list2.contains(ch.toUpperCase(Locale.ROOT)) && !list2.contains(ch.toLowerCase(Locale.ROOT))) {
                return false;
            }
            list2.remove(ch);
        }
        return true;
    }

    /**
     * Given a string, consider the prefix string made of the first N chars of the string.
     * Does that prefix string appear somewhere else in the string.
     * Assume that the string is not empty and that N is in the range 1 .. str.length().
     * The duplicate can overlap with the prefix (but not 100%).
     * See the last two examples.
     *
     * prefixExistsAgain("abXXabc", 1) => true
     * prefixExistsAgain("abXXabc", 2) => true
     * prefixExistsAgain("abXXabc", 3) => false
     * prefixExistsAgain("ababa", 3) => true
     * prefixExistsAgain("aaaa", 3) => true
     * prefixExistsAgain("aaaa", 4) => false
     */
    public static boolean prefixExistsAgain(String str, int n) {
        if (!str.trim().isEmpty() && n >= 1 && n <= str.length()) {
            String toCompare = str.substring(1);
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char a = str.charAt(i);
                String b = Character.toString(a);
                prefix.append(b);
            }
            return toCompare.contains(prefix);
        }
        return false;
    }

}
