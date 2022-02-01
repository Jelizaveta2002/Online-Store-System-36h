package ee.taltech.iti0202.introduction;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Introduction {


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
        boolean test1 = valueOne < 5 || valueTwo < 5;
        boolean test2 = valueTwo / valueOne == 2 || valueOne / valueTwo == 2;
        boolean test3 = valueOne >= 5 && valueTwo >= 5;
        System.out.println(test3);
        if (test1 && test2) {
            return "bad";
        } if (test2 && test3) {
            return "good";
        } if (test1) {
            return "bad";
        } if (test2) {
            return "good";
        } if (test3) {
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
        for (int i = 0; i < numbers.size(); i++) {
            int a = numbers.get(i);
            if (a % 2 == 0) {
                evenNumberList.add(a);
            }
        }return evenNumberList;
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
        for (int i: numbers) {
            allNumberList.add(i);
        }System.out.println(allNumberList);
        for (int i = 0; i < allNumberList.size(); i++) {
            int a = allNumberList.get(i);
            if (a % 2 == 0) {
                evenNumberList.add(a);
            }
        }System.out.println(evenNumberList);
        int[] result = new int[evenNumberList.size()];
        for (int i = 0; i <evenNumberList.size() ; i++) {
            result[i] = evenNumberList.get(i);
        }
        return result;
    }

    /**
     * Method gets two Strings as parameters.
     * If two words have the same length, just put them together. If the length is
     * different, remove so many letters from the beginning of the longer word that the two words are the same length, and
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
                firstB.deleteCharAt(0);
            } String myString = firstB.toString();
            String result = myString + second;
            return result.toLowerCase(Locale.ROOT);
        } else if (first.length() < second.length()) {
            StringBuilder secondB = new StringBuilder(second);
            while (secondB.length() > first.length()) {
                secondB.deleteCharAt(0);
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
    public int countTripleChars(String word){
        int counter = 0;
        int wordLength = word.length();
        int last = wordLength - 1;
        int prelast = last - 1;
        for (int i = 0; i < word.length(); i++) {
            if (i != last && i != prelast && i != 0 && i != 1) {
                char symbol = word.charAt(i);
                char right = word.charAt(i + 1);
                char left =  word.charAt(i - 1);
                char check1 =  word.charAt(i + 2);
                char check2 =  word.charAt(i - 2);
                if (symbol == right && symbol == left && symbol != check1 && symbol != check2) {
                    counter += 1;
                }
            } if (i == 0) {
                char symbol = word.charAt(i);
                char right = word.charAt(i + 1);
                char check1 =  word.charAt(i + 2);
                char check2 =  word.charAt(i + 3);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += 0;
                }
            } if (i == 1) {
                char symbol = word.charAt(i);
                char right = word.charAt(i + 1);
                char check1 =  word.charAt(i - 1);
                char check2 =  word.charAt(i + 2);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += 1;
                }
            } if (i == last) {
                char symbol = word.charAt(i);
                char right = word.charAt(i - 1);
                char check1 =  word.charAt(i - 2);
                char check2 =  word.charAt(i - 3);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += 0;
                }
            } if (i == prelast) {
                char symbol = word.charAt(i);
                char right = word.charAt(i - 1);
                char check1 =  word.charAt(i + 1);
                char check2 =  word.charAt(i - 2);
                if (symbol == right && symbol == check1 && symbol != check2) {
                    counter += 1;
                }
            }
        } return counter;
    }

    /**
     * Run tests.
     * @param args Arguments from command line.
     */
    public static void main(String[] args) {
        Introduction introduction = new Introduction();
        System.out.println(introduction.howIsOutcome(1, 10)); // "bad"

        List<Integer> nums = new ArrayList<>(Arrays.asList(7, 5, 3, 6, 2, 5, 7, 8, 12));
        System.out.println(introduction.findEvenNumbersList(nums)); // [4, 2, 2, -2, 0]

        int[] array = {9, 0, 24, -6, 3};
        System.out.println(Arrays.toString(introduction.findEvenNumbersArray(array))); // [0, 24, -6]

        String result = introduction.findTheString("Good", "afternoon");
        System.out.println(result);  // GOODNOON
        result = introduction.findTheString("Hello", "lo");
        System.out.println(result);  // lolo
        System.out.println(introduction.findTheString("", ""));  // FALSE
        System.out.println(introduction.findTheString("", "   "));  // FALSE
        System.out.println(introduction.findTheString("  ", "a"));  //  a  (with space in front)

        System.out.println(introduction.countTripleChars("aaabbbabbb"));  // 3
//        System.out.println(introduction.countTripleChars("aaa"));  // 1
        System.out.println(introduction.countTripleChars("aaaabbb"));  // 0
        System.out.println(introduction.countTripleChars("aaaabbbabbbcCc"));  // 2
    }
}
