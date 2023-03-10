package ee.taltech.iti0202.tk1;

import java.util.*;

public class Exam {


    /**
     * Return the "centered" average of an array of ints, which we'll say is the mean average of the values,
     * except ignoring the largest and smallest values in the array. If there are multiple copies of the
     * smallest value, ignore just one copy, and likewise for the largest value. Use int division to produce
     * the final average. You may assume that the array is length 3 or more.
     * <p>
     * centeredAverage([1, 2, 3, 4, 100]) → 3
     * centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
     * centeredAverage([-10, -4, -2, -4, -2, 0]) → -3
     */
    public static int centeredAverage(List<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>(nums);
        int sizeOfList = list.size();
        if (sizeOfList >= 3) {
            Collections.sort(list);
            list.remove(sizeOfList - 1);
            list.remove(0);
            int counter = 0;
            for (int num : list) {
                counter += num;
            }
            return (counter / list.size());
        }
        int counter = 0;
        if (! list.isEmpty()) {
            for (int num : list) {
                counter += num;
            }
            return (counter / list.size());
        }
        return 0;
    }


    /**
     * Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
     * Return 0 if they both go over.
     * <p>
     * blackjack(19, 21) → 21
     * blackjack(21, 19) → 21
     * blackjack(19, 22) → 19
     */
    public static int blackjack(int a, int b) {
        if (a > 21 && b > 21) {
            return 0;
        } else if (a <= 21 && b <= 21) {
            if (a > b) {
                return a;
            } else if (b > a) {
                return b;
            }
            else {
                return a;
            }
        } else if (a > 21 && b <= 21) {
            return b;
        }
        return a;
    }


    /**

     Given a string and an int n, return a string made of n repetitions of the last n characters
     of the string. You may assume that n is between 0 and the length of the string, inclusive.

     repeatEnd("Hello", 3) → "llollollo"
     repeatEnd("Hello", 2) → "lolo"
     repeatEnd("Hello", 1) → "o"
     */
    public static String repeatEnd(String str, int n) {
        if (str.length() != 0 && n <= str.length() && n >= 0) {
            StringBuilder newSting = new StringBuilder(str);
            ArrayList<String> storage = new ArrayList<>();
            StringBuilder string = new StringBuilder();
            StringBuilder stringResult = new StringBuilder();
            for (Integer i = 1; i < n + 1; i++ ) {
                char ch = str.charAt(str.length() - i);
                string.append(ch);
            }
            string.reverse();
            for (int i = 0; i < n; i++) {
                stringResult.append(string);
            }
            return stringResult.toString();
        }
        return "";
    }

    /**

     Modify and return the given map as follows: if the keys "a" and "b" are both in the map
     and have equal values, remove them both.

     mapAB({"a": "aaa", "b": "aaa", "c": "cake"}) → {"c": "cake"}
     mapAB({"a": "aaa", "b": "bbb"}) → {"a": "aaa", "b": "bbb"}
     mapAB({"a": "aaa", "b": "bbb", "c": "aaa"}) → {"a": "aaa", "b": "bbb", "c": "aaa"}
     */
    public static Map<String, String> mapAB(Map<String, String> map) {
        HashMap<String, String> newMap = new HashMap<>(map);
        boolean checkA = false;
        boolean checkB = false;
        String keyA = "a";
        String keyB = "b";
        for (String key : newMap.keySet()) {
            if (key.equals("a")) {
                checkA = true;
                break;
            }
        }
        for (String key : newMap.keySet()) {
            if (key.equals("b")) {
                checkB = true;
                break;
            }
        }
        if (checkA && checkB) {
            String a = newMap.get("a");
            String b = newMap.get("b");
            if (a.equals(b)) {
                newMap.remove(keyA);
                newMap.remove(keyB);
                return newMap;
            }
        }
        return newMap;
    }

    public static void main(String[] args) {
        System.out.println(centeredAverage(new ArrayList<>(List.of(1, 2, 3, 4, 100))));
        System.out.println(repeatEnd("", 1));
        System.out.println(mapAB(new HashMap<String, String>(Map.of())));
    }
}