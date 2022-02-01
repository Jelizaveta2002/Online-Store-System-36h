package ee.taltech.iti0202.introduction;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Introduction {


    public static final int INT = 5;
    public static final int INT1 = 2;
    public static final int I = 0;
    public static final int INT2 = 1;
    public static final int INT3 = 3;
    public static final int VALUE_TWO = 6;
    public static final int INT4 = 9;
    public static final int INT5 = 24;
    public static final int INT6 = 7;
    public static final int INT7 = 8;
    public static final int INT8 = 12;

    /**
     * Method gets two numbers as parameters.
     * Method must answer if the given pair gives bad, normal or good outcome.
     * Outcome is "bad" if any of values is less than 5.
     * Outcome is "good" if one value equals doubled second value.
     * Outcome is "ok" if both values equal at least 5.
     * The priority is as follows: "bad", "good", "ok" (if several cases apply, take the higher / earlier).
     *
     * @param valueOne int
     * @param valueTwo int
     * @return String based on the values of valueOne and valueTwo
     */
    public String howIsOutcome(int valueOne, int valueTwo) {
        boolean test1 = valueOne < INT || valueTwo < INT;
        boolean test2 = valueTwo / valueOne == INT1 || valueOne / valueTwo == INT1;
        boolean test3 = valueOne >= INT && valueTwo >= INT;
        System.out.println(test3);
        if (test1 && test2) {
            return "bad";
        }
        if (test2 && test3) {
            return "good";
        }
        if (test1) {
            return "bad";
        }
        if (test2) {
            return "good";
        }
        if (test3) {
            return "ok";
        }
        return null;
    }

    /**
     * Method gets a list of numbers.
     * Return a list containing only even numbers of the given list.
     * If the given list does not contain any even numbers, return an empty list.
     *
     * @param numbers given list that contains numbers.
     * @return list of even numbers.
     */
    public List<Integer> findEvenNumbersList(List<Integer> numbers) {
        List<Integer> evenNumberList = new ArrayList<>();
        for (int i = I; i < numbers.size(); i++) {
            int a = numbers.get(i);
            if (a % INT1 == I) {
                evenNumberList.add(a);
            }
        }
        return evenNumberList;
    }

    /**
     * Method gets an array of numbers.
     * Return an array containing only even numbers of the given array.
     * If the given array does not contain any even numbers, return an empty array.
     *
     * You must not use the previous function in this function!
     *
     * @param numbers given array that contains numbers.
     * @return array of even numbers.
     */
    public int[] findEvenNumbersArray(int[] numbers) {
        List<Integer> evenNumberList = new ArrayList<>();
        List<Integer> allNumberList = new ArrayList<>();
        for (int i : numbers) {
            allNumberList.add(i);
        } System.out.println(allNumberList);
        for (int i = I; i < allNumberList.size(); i++) {
            int a = allNumberList.get(i);
            if (a % INT1 == I) {
                evenNumberList.add(a);
            }
        } System.out.println(evenNumberList);
        int[] result = new int[evenNumberList.size()];
        for (int i = I ; i < evenNumberList.size() ; i++) {
            result[i] = evenNumberList.get(i);
        }
        return result;
    }

    /**
     * Method gets two Strings as parameters.
     * If two words have the same length, just put them together. If the length is
     * different, remove so many letters from the beginning of the longer word that the two words are the same
     * length, and
     * then put them together.
     * If the first word was longer, return the answer in lower case. If the second word was longer,
     * return the answer in capital letters.
     * If both words are empty or with spaces, return FALSE.
     *
     * @param first String
     * @param second String
     * @return String based on the values of first and second
     */
    public String findTheString(String first, String second) {
        if (first.length() == second.length()) {
            return first + second;
        } else if (first.length() > second.length()) {
            //int diff = first.length() - second.length();
            StringBuilder firstB = new StringBuilder(first);
            while (firstB.length() > second.length()) {
                firstB.deleteCharAt(I);
            } String myString = firstB.toString();
            String result = myString + second;
            return result.toLowerCase(Locale.ROOT);
        } else if (first.length() < second.length()) {
            StringBuilder secondB = new StringBuilder(second);
            while (secondB.length() > first.length()) {
                secondB.deleteCharAt(I);
            } String myString = secondB.toString();
            String result = first + myString;
            return result.toUpperCase(Locale.ROOT);
        }
        return null;
    }

    /**
     * Method gets one String as a parameter.
     * In a given string, count the number of characters that appear exactly three times in a row.
     *
     * @param word String
     * @return The number of triples
     */
    public int countTripleChars(String word) {
        int counter = I;
        int wordLength = word.length();
        int last = wordLength - INT2;
        int prelast = last - INT2;
        if (word.length() == INT3) {
            char symbol = word.charAt(I);
            char right = word.charAt(INT2);
            char check1 =  word.charAt(INT1);
            if (symbol == right && symbol == check1) {
                counter += INT2;
                return counter;
            }
        }
        if (word.length() < INT3) {
            return counter;
        }
        for (int i = I; i < word.length(); i++) {
            if (i != last && i != prelast && i != I && i != INT2) {
                char symbol = word.charAt(i);
                char right = word.charAt(i + INT2);
                char left =  word.charAt(i - INT2);
                char check1 =  word.charAt(i + INT1);
                char check2 =  word.charAt(i - INT1);
                if (symbol == right && symbol == left && symbol != check1 && symbol != check2) {
                    counter += INT2;
                }
            }
            if (i == I) {
                char symbol = word.charAt(i);
                char right = word.charAt(i + INT2);
                char check1 =  word.charAt(i + INT1);
                char check2 =  word.charAt(i + INT3);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += I;
                }
            }
            if (i == INT2) {
                char symbol = word.charAt(i);
                char right = word.charAt(i + INT2);
                char check1 =  word.charAt(i - INT2);
                char check2 =  word.charAt(i + INT1);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += INT2;
                }
            }
            if (i == last) {
                char symbol = word.charAt(i);
                char right = word.charAt(i - INT2);
                char check1 =  word.charAt(i - INT1);
                char check2 =  word.charAt(i - INT3);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += I;
                }
            }
            if (i == prelast) {
                char symbol = word.charAt(i);
                char right = word.charAt(i - INT2);
                char check1 =  word.charAt(i + INT2);
                char check2 =  word.charAt(i - INT1);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += INT2;
                }
            }
        }
        return counter;
    }

    /**
     * Run tests.
     * @param args Arguments from command line.
     */
    public static void main(String[] args) {
        Introduction introduction = new Introduction();
        System.out.println(introduction.howIsOutcome(INT3, VALUE_TWO)); // "bad"

        List<Integer> nums = new ArrayList<>(Arrays.asList(INT6, INT, INT3, VALUE_TWO, INT1, INT, INT6, INT7, INT8));
        System.out.println(introduction.findEvenNumbersList(nums)); // [4, 2, 2, -2, 0]

        int[] array = {INT4, I, INT5, -VALUE_TWO, INT3};
        System.out.println(Arrays.toString(introduction.findEvenNumbersArray(array))); // [0, 24, -6]

        String result = introduction.findTheString("Good", "afternoon");
        System.out.println(result);  // GOODNOON
        result = introduction.findTheString("Hello", "lo");
        System.out.println(result);  // lolo
        System.out.println(introduction.findTheString("", ""));  // FALSE
        System.out.println(introduction.findTheString("", "   "));  // FALSE
        System.out.println(introduction.findTheString("  ", "a"));  //  a  (with space in front)

        System.out.println(introduction.countTripleChars("aaabbbabbb"));  // 3
        System.out.println(introduction.countTripleChars("aaa"));  // 1
        System.out.println(introduction.countTripleChars("aaaabbb"));  // 0
        System.out.println(introduction.countTripleChars("aaaabbbabbbcCc"));  // 2
    }
}
