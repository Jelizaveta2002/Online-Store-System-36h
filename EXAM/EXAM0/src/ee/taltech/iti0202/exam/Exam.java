package ee.taltech.iti0202.exam;

import java.lang.reflect.Array;
import java.util.*;

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
    public static Integer recSeparate(int text) {
        System.out.println(text / 3);
        return 60 % text;

//        ArrayList<String> listWhere = new ArrayList<>();
//        StringBuilder result = new StringBuilder();
//        for (int i=0; i< text.length(); i++) {
//            char ch = text.charAt(i);
//            String letter = Character.toString(ch);
//            listWhere.add(letter);
//        }
//        String toRemember = "";
//        for (String letter : listWhere) {
//            if (letter.equals(toRemember)) {
//                result.append(letter);
//            }
//            else {
//                toRemember = letter;
//                if (!result.toString().isEmpty()) {
//                    result.append(" ");
//                }
//                result.append(letter);
//            }
//        }
//        return result.toString();
    }

    /**
     * Write a  method where you have to find out, how many times "search" String is found in "where" String.
     * If boolean "ordered" is TRUE, then we search from left to right, otherwise if FALSE, then we search from right
     * to left.
     * findWordBothSides("kferfoesvsvfbr", "koer", true) -> 1
     * findWordBothSide("wdhbsdbc", "kass", true) -> 0
     * findWordBothSide("llfvafamdfmmmhjfagdaurtss", "lamas", true) -> 2
     * findWordBothSide("ednjhubsdwnonvnvh", "hobune", false) -> 1
     * findWordBothSide("aaa", "a", true) -> 3
     * findWordBothSide("aaa", "aa", true) -> 1
     * findWordBothSide("hahaha", "ha", false) -> 2
     * findWordBothSide("babananana", "banana", true) -> 1
     */
    public static int findWordBothSides(String where, String search, boolean ordered) {
        int counter = 0;
        ArrayList<String> arrayResult = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        ArrayList<String> listWhere = new ArrayList<>();
        ArrayList<String> listSearch = new ArrayList<>();
        StringBuilder newWhere = new StringBuilder(where);
        StringBuilder newSearch = new StringBuilder(search);
        for (int i=0; i< newWhere.length(); i++) {
            char ch = newWhere.charAt(i);
            String letter = Character.toString(ch);
            listWhere.add(letter);
        }
        for (int i=0; i< newSearch.length(); i++) {
            char ch = newSearch.charAt(i);
            String letter = Character.toString(ch);
            listSearch.add(letter);
        }
        if (!ordered) {
            Collections.reverse(listWhere);
        }
        StringBuilder word = new StringBuilder();
        boolean toCheck = true;
        while (toCheck) {
            for (String letter : listSearch) {
                if (listWhere.contains(letter)) {
                    word.append(letter);
                    listWhere.remove(letter);
                }
                else {
                    toCheck = false;
                }
                if (word.toString().equals(search)) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    /**
     * Write a method that finds from given array two elements of which sum of cross sum is the largest.
     * Cross sum is sum of all numbers in the element (23 => 2 + 3 = 5).
     * In given method you have to apply cross sum, until it is smaller than 10 (one-digit).
     * For example cross sum of 123 is 1+2+3 = 6.
     * Cross sum on 991 is 9+9+1=19, this number has 2 digits, so we apply cross sum again,
     * 1+9=10, and again, 1+0 = 1. So the final cross sum is 1.
     * <p>
     * Two elements are always in the same order as in the list:
     * in case 1,2,3 you have to consider pairs:
     * 1,2
     * 1,3
     * 2,3
     * <p>
     * 3,2 is NOT allowed
     * <p>
     * combineNumbers([1, 2, 3]) => 23 (2+3 is largest)
     * combineNumbers([1]) => 0 (only one element)
     * combineNumbers([1, 2, 3, 12, 66]) => 312 (3+1+2=6 is largest or
     * for example 1266 => 1+2+6+6=15 => 6. return one that is first in the array)
     * combineNumbers([1, 2, 1, 3]) => 23 (2+3 is largest)
     */

    public static int combineNumbers(int[] numbers) {
        HashMap<Integer, Integer> mapOfSum = new HashMap<>();
        ArrayList<Integer> listOfNum = new ArrayList<>();
        ArrayList<Integer> listToFindMax = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i : numbers) {
            listOfNum.add(i);
        }
        if (listOfNum.size() == 1) {
            return 0;
        }
        for (Integer i : listOfNum) {
            for (int u=listOfNum.indexOf(i) + 1; u < listOfNum.size(); u++) {
                String pair = String.valueOf(i) + listOfNum.get(u);
                listToFindMax.add(Integer.parseInt(pair));
            }
        }
        for (Integer i : listToFindMax) {
            int sumOfPair = findCrossSum(i);
            mapOfSum.put(sumOfPair, i);
            resultList.add(sumOfPair);
        }
        int max = Collections.max(resultList);
        return mapOfSum.get(max);
    }

    public static int findCrossSum(int num) {
        String sumS = String.valueOf(num);
        ArrayList<Integer> listOfNum = new ArrayList<>();
        int counter = 0;
        StringBuilder builder = new StringBuilder(sumS);
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            int number = Character.getNumericValue(ch);
            listOfNum.add(number);
        }
        for (int n : listOfNum) {
            counter += n;
        }
        if (counter < 10) {
            return counter;
        }
        else {
            return findCrossSum(counter);
        }

    }

    /**
     * Given a list of score information,
     * return a map with name and the
     * corresponding sum of score for that name.
     * <p>
     * Each line is in format: "score:name1,name2,name3".
     * Score part is always non-negative integer.
     * Names do not contain spaces.
     * There can be one or more names.
     * One line does not have duplicate names.
     * <p>
     * One line indicates the score for the given names.
     * If the same name (case-sensitive) is present in another line,
     * the score is added.
     * <p>
     * The order of the output Map is not important.
     * Map should not contain names with 0 score.
     * <p>
     * Example:
     * "10:Ago,Mati"
     * "20:Ago,Kati"
     * =>
     * {Ago=30, Kati=20, Mati=10}
     * <p>
     * "1:Ago"
     * "2:ago"
     * =>
     * {Ago=1, ago=2}
     * <p>
     * "0:Ago"
     * =>
     * {}
     */
    public static Map<String, Integer> findScore(List<String> scores) {
        HashMap<String, Integer> finalMap = new HashMap<>();
        HashMap<String, Integer> helpMap = new HashMap<>();
        for (String line : scores) {
            String [] arrayToIterate = line.split(":");
            String number = (String) Array.get(arrayToIterate, 0);
            String names = (String) Array.get(arrayToIterate, 1);
            String [] arrayOfNames = names.split(",");
            ArrayList<String> listOfNames = new ArrayList<>(Arrays.asList(arrayOfNames));
            for (String name : listOfNames) {
                if (finalMap.containsKey(name)) {
                    finalMap.put(name, finalMap.get(name) + Integer.parseInt(number));
                }
                else {
                    finalMap.put(name, Integer.parseInt(number));
                }
            }
        }
        return finalMap;
    }

    /* Write a  method that finds correct difference between two timestamps. Timestamps are given in format HH:MM where
     * HH is two-digit hour marker and MM is two-digit
     * minutes marker. Result must be also in format HH:MM. Difference means basically "time2" minus "time1".
            * timeDiff("10:00", "10:00") => "00:00"
            * timeDiff("10:00", "11:01") => "01:01"
            * timeDiff("10:00", "09:01") => "23:01"
            * timeDiff("10:00", "08:59") => "22:59"
            * timeDiff("10:01", "10:00") => "23:59"
            *
            * @param time1 time as HH:MM
     * @param time2 time as HH:MM
     * @return time difference as HH:MM
     */
    public static String differenTime(String time1, String time2) {
        String result = "";
        int h1 = Integer.parseInt(time1.substring(0, 2));
        int m1 = Integer.parseInt(time1.substring(3));
        int h2 = Integer.parseInt(time2.substring(0, 2));
        int m2 = Integer.parseInt(time2.substring(3));
        int h3;
        int m3;
        int minLoan = 0;
        if (m1 > m2) {
            m2 += 60;
            minLoan = 1;
        }
        m3 = m2 - m1;
        if (h1 > (h2 - minLoan)) {
            h2 += 24;
        }
        h3 = h2 - h1 - minLoan;
        String hours = "";
        String minutes = "";
        if (m3 < 10) {
            minutes += "0";
        }
        minutes += m3;
        if (h3 < 10) {
            hours += "0";
        }
        hours += h3;
        result = hours + ":" + minutes;

        return result;
    }

            /* Given a string, encode the string using Run-length encoding.
            * RLE is a form of data compression, where runs (consecutive data elements)
     * are replaced by just one data value and count.
     * <p>
     * encode("TalTech") => "Taltech"
            * encode("TTU") => "2TU"
            * encode("WWWABBBA") => "3WA3BA"
            * encode("  ") => "2 "
            *
            * @param data string to encode
     * @return encoded string
     */
    public static String coding(String data) {
        StringBuilder toReturn = new StringBuilder();
        StringBuilder builder = new StringBuilder(data);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            String letter = Character.toString(ch);
            list.add(letter);
        }
        String toRemember = "";
        int rememberNum = 0;
        for (String let : list) {
            if (let.equals(toRemember)) {
                rememberNum += 1;
            }
            else {
                if (rememberNum > 1) {
                    toReturn.append(rememberNum);
                    toReturn.append(toRemember);
                }
                else {
                    toReturn.append(toRemember);
                }
                toRemember = let;
                rememberNum = 1;
            }

        }
        if (rememberNum > 1) {
            toReturn.append(rememberNum);
            toReturn.append(toRemember);
        }
        else {
            toReturn.append(toRemember);
        }
        return toReturn.toString();
    }

    

    public static void main(String[] args) {
        int[] myNum = {10, 15, 6, 7, 98, 67896};
        ArrayList<String> list = new ArrayList<>();
        list.add("10:Ago,Mati");
        list.add("20:Ago,Kati");
        System.out.println(combineNumbers(myNum));
        System.out.println(findScore(list));
        System.out.println(differenTime("10:30", "10:09"));
        System.out.println(coding("TalTech"));
        System.out.println(recSeparate(13));
        System.out.println(findWordBothSides("kferfoesvsvfbr", "koer", true));
    }
}
