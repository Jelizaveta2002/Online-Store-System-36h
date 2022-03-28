package ee.taltech.iti0202.kt0;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    /**
     * Given lists nums1 and nums2 of the same length,
     * for every element in nums1, consider the corresponding
     * element in nums2 (at the same index).
     * Return the count of the number of times
     * that the two elements differ by 2 or less, but are not equal.
     *
     * matchUp([1, 2, 3], [2, 3, 10]) => 2
     * matchUp([1, 2, 3], [2, 3, 5]) => 3
     * matchUp([1, 2, 3], [2, 3, 3]) => 2
     */
    public static int matchUp(List<Integer> a, List<Integer> b) {
        ArrayList<Integer> list1 = new ArrayList<>(a);
        ArrayList<Integer> list2 = new ArrayList<>(b);
        int numberToReturn = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) > list2.get(i)) {
                if (list1.get(i) - list2.get(i) > 0 && list1.get(i) - list2.get(i) <= 2) {
                    numberToReturn += 1;
                }
            }
            if (list1.get(i) < list2.get(i)) {
                if (list2.get(i) - list1.get(i) > 0 && list2.get(i) - list1.get(i) <= 2) {
                    numberToReturn += 1;
                }
            }
        }
        return numberToReturn;
    }

    /**
     * Given two strings, word and a separator sep,
     * return a big string made of count occurrences of the word,
     * separated by the separator string.
     *
     * repeatSeparator("Word", "X", 3) => "WordXWordXWord"
     * repeatSeparator("This", "And", 2) => "ThisAndThis"
     * repeatSeparator("This", "And", 1) => "This"
     */
    public static String repeatSeparator(String word, String sep, int count) {
        return "wat";
    }

//    public static void main(String[] args) {
//        System.out.println(matchUp(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<>(List.of(2, 3, 10))));
//    }

}