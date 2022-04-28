package ee.taltech.iti0202.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Exam {

    /**
     * 01
     *
     * For each multiple of 10 in the given array,
     * change all the values following it to be that multiple of 10,
     * until encountering another multiple of 10.
     * So {2, 10, 3, 4, 20, 5} yields {2, 10, 10, 10, 20, 20}.
     *
     * tenRun([2, 10, 3, 4, 20, 5]) => [2, 10, 10, 10, 20, 20]
     * tenRun([10, 1, 20, 2]) => [10, 10, 20, 20]
     * tenRun([10, 1, 9, 20]) => [10, 10, 10, 20]
     */
    public static List<Integer> tenRun(List<Integer> nums) {
        ArrayList<Integer> newList = new ArrayList<>(nums);
        ArrayList<Integer> listToReturn = new ArrayList<>();
        Integer toPut = null;
        boolean check = false;
        for (Integer number : newList) {
            if (!check) {
                if (number % 10 != 0) {
                    listToReturn.add(number);
                }
                else {
                    listToReturn.add(number);
                    check = true;
                    toPut = number;
                }
            }
            else {
                if (number % 10 != 0) {
                    listToReturn.add(toPut);
                }
                else {
                    listToReturn.add(number);
                    toPut = number;
                }
            }
        }
        return listToReturn;
    }


    /**
     * 02
     *
     * Write a method that analyzes input String and returns all pairs of same letter that is present as lower-case and upper-case in input String.
     * Returned letter pairs have to be in alphabetic order. If there are multiple same letter pairs, then return only one. If there are no suitable pairs, return "".
     * Take latin alphabet 'a' - 'z' as base.
     * mixedPairs("abcABD") => "AaBb" (a and b are represented by both lowe and upper cased letter)
     * mixedPairs("aaaAAAaaaa") => "Aa"
     * mixedPairs("tere") => ""
     * mixedPairs("bBaacA") => "AaBb" (result is in alphabetic order, although in input String, b is earlier than a).
     * @param input
     * @return
     */
    public static String mixedPairs(String input) {
        StringBuilder newBuilder = new StringBuilder(input);
        ArrayList<String> listWithCapLetters = new ArrayList<>();
        ArrayList<String> listWithSmallLetters = new ArrayList<>();
        ArrayList<String> finalList = new ArrayList<>();
        StringBuilder finalBuilder = new StringBuilder();
        for (int i=0; i< newBuilder.length(); i++) {
            char ch = newBuilder.charAt(i);
            String letter = Character.toString(ch);
            if (Character.isUpperCase(ch)) {
                listWithCapLetters.add(letter);
            } else {
                listWithSmallLetters.add(letter);
            }
        }
        Collections.sort(listWithCapLetters);
        Collections.sort(listWithSmallLetters);
        for (String letter : listWithCapLetters) {
            if (listWithSmallLetters.contains(letter.toLowerCase(Locale.ROOT)) && !finalList.contains(letter)) {
                finalList.add(letter);
                finalList.add(letter.toLowerCase(Locale.ROOT));
            }
        }
        for (String letter : finalList) {
            finalBuilder.append(letter);
        }
        return finalBuilder.toString();
    }



    /**
     * 03
     *
     * Write a recursive method (no loops, no global variables, calls itself)
     * which separates different letters by single space.
     *
     * recSeparate("abc") => "a b c"
     * recSeparate("aabbc") => aa bb c"
     * recSeparate("aaaabbbccd") => "aaaa bbb cc d"
     * recSeparate("") => ""
     * recSeparate("aaa") => "aaa"
     *
     * @param text
     * @return
     */
    public static String recSeparate(String text) {
        return "wrong again";
    }



}
