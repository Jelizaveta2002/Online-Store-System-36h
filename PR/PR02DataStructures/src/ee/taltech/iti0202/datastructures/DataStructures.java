package ee.taltech.iti0202.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStructures {
    HashMap<String, Integer> studentsMap = new HashMap<>();
    /**
     * Given String is a sentence with some words.
     * There are only single whitespace between every word and no punctuation marks.
     * Also there are no capital letters in input string.
     * <p>
     * Return the longest word from the input sentence.
     * <p>
     * If there are more than one word with the same length then return the word which comes alphabetically first.
     * <p>
     * Hints:
     * You can split words into an array using "str.split()"
     * Sorting the list with the longest words can definitely help you to find the word which comes alphabetically
     * first.
     *
     * @param sentence input String to find the longest words
     * @return the longest String from input
     */
    public static String findLongestWord(String sentence) {
        String[] myArray = sentence.split(" ");
        List<String> longestOne = new ArrayList<>();
        int maxLength = 0;
        String longest = null;
        for (String a : myArray) {
            if (a.length() > maxLength) {
                maxLength = a.length();
                longest = a;
            }
        } for (String a : myArray) {
            if (a.length() == maxLength) {
                longestOne.add(a);
            }
        } java.util.Collections.sort(longestOne);
        return longestOne.get(0);
    }

    /**
     * Classic count the words exercise.
     * <p>
     * From input count all the words and collect results to map.
     *
     * @param sentence array of strings, can't be null.
     * @return map containing all word to count mappings.
     */
    public static Map<String, Integer> wordCount(String[] sentence) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : sentence) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        } return map;
    }

    /**
     * Loop over the given list of strings to build a resulting list of string like this:
     * when a string appears the 2nd, 4th, 6th, etc. time in the list, append the string to the result.
     * <p>
     * Return the empty list if no string appears a 2nd time.
     * <p>
     * Use map to count times that the string has appeared.
     *
     * @param words input list to filter
     * @return list of strings matching criteria
     */
    public static List<String> onlyEvenWords(List<String> words) {
        List<String> resultList = new ArrayList<>();
        String[] strings = words.toArray(String[]::new);
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : strings) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
                if (map.get(a) % 2 == 0) {
                    resultList.add(a);
                }
            } else {
                map.put(a, 1);
            }
        } return resultList;
    }


    /**
     * Method to save student and student's grade(you should use a Map here).
     * Only add student if his/hers grade is in the range of 0-5.
     *
     * @param studentInfo String with a pattern (name:grade)
     */
    public void addStudent(String studentInfo) {

        String[] myArray = studentInfo.split(":");
        String grade = myArray[1];
        int finalGrade = Integer.parseInt(grade);
        if (finalGrade >= 0 && finalGrade <= 5) {
            studentsMap.put(myArray[0], finalGrade);
        }
    }

    /**
     * Method to get student's grade.
     * Return the student's grade by his/hers name.
     * You can assume that the user is already added(previous function with student's info already called).
     *
     * @param name String students name
     * @return int student's grade.
     */
    public int getStudentGrade(String name) {
        Integer grade = studentsMap.get(name);
        return grade != null ? grade : -1;
    }

    /**
     * Main.
     * @param args Commend line arguments.
     */
    public static void main(String[] args) {
        System.out.println(findLongestWord("nimi on salastatud aaaaaaaaaa"));  // "salastatud"
        System.out.println(findLongestWord("aaa bbbbb"));  // "bbbbb"
        System.out.println(findLongestWord("hello ahllo")); // "ahllo"

        System.out.println(wordCount(new String[]{})); // empty
        System.out.println(wordCount(new String[]{"eggs", "SPAM", "eggs", "bacon", "SPAM", "bacon", "SPAM"}));

        System.out.println(onlyEvenWords(Arrays.asList("foo", "bar", "baz", "baz", "bar", "foo"))); // [baz, bar, foo]
        // any order
        System.out.println(onlyEvenWords(Arrays.asList("a", "b", "b", "a"))); // [b, a] any order
        System.out.println(onlyEvenWords(Arrays.asList("eggs", "bacon", "SPAM", "ham", "SPAM", "SPAM"))); // [SPAM]

        DataStructures dataStructures = new DataStructures();
        dataStructures.addStudent("Ago:5");
        dataStructures.addStudent("Martin:0");
        dataStructures.addStudent("Margo:3");
        dataStructures.addStudent("Cheater:6");

        System.out.println(dataStructures.getStudentGrade("Ago")); // 5
        System.out.println(dataStructures.getStudentGrade("Martin")); // 0
        System.out.println(dataStructures.getStudentGrade("Margo")); // 3
        System.out.println(dataStructures.getStudentGrade("Cheater")); // -1
    }
}
