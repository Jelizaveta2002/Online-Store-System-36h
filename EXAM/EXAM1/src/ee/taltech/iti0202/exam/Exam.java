package ee.taltech.iti0202.exam;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {

    /**
     * Given a list of numbers, count how many 2-s are alone (no 2 before or after it).
     *
     * countSingleTwos([2, 2, 1, 3]) => 0
     * countSingleTwos([7, 6, 1, 3]) => 0
     * countSingleTwos([2, 2, 1, 2]) => 1
     * countSingleTwos([2, 2, 2, 1, 3, 2, 1, 2]) => 2
     */
    public static int countSingleTwos(List<Integer> numbers) {

        ArrayList<Integer> listToIterate = new ArrayList<>(numbers);
        for (int i = 0; i < listToIterate.size(); i++) {

        }












        int counter = 0;
        int countIndex = 0;
        for (Integer number : listToIterate) {
            if (countIndex == 0 && number == 2 && listToIterate.get(1) != 2) {
                counter += 1;
            }
            else if (countIndex == listToIterate.size() - 1 && number == 2 && listToIterate.get(listToIterate.size() - 2) != 2) {
                counter += 1;
            }
            else {
                if (number == 2) {
                    if (listToIterate.get(countIndex + 1) != 2 && listToIterate.get(countIndex - 1) != 2) {
                        counter += 1;
                    }
                }
            }
            countIndex += 1;
        }
        return counter;
    }

    /**
     * Write a method that takes a string and decodes it.
     * The string may contain some numbers.
     * All numbers need to be replaced with a corresponding letter from the alphabet.
     * Each number n references to n-th character of the lowercase alphabet (abcdefghijklmnopqrstuvwxyz).
     * If n is out of bounds, then it should start from "a" again. (0, 26 and 52 correspond to "a")
     *
     * Examples:
     * decodeMessage("0") => "a"
     * decodeMessage("0b2d4f6") => "abcdefg"
     * decodeMessage("h8") => "hi"
     * decodeMessage("11o11") => "lol"
     * decodeMessage("h8 th4r30 p17ogramme43") => "hi there programmer"
     * decodeMessage(":14 19h8s 8s 84e45t34n58 54oo37e523423") => ":o this is getting cooler"
     * decodeMessage("This one doesn't need to be changed!") => "This one doesn't need to be changed!"
     *
     * @param message the message that needs to be decoded
     * @return decoded message
     */
    public static String decodeMessage(String message) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String > lestOfNums = new ArrayList<>();
        String helper = "";
        for (int i = 0; i < message.length(); i++) {
            if (i <= message.length()) {
                String toPrint = message.substring(i, i+1);
                //System.out.println(toPrint);
                if (!Character.isDigit(toPrint.charAt(0))) {
                    if (!helper.isEmpty()) {
                        Integer num = Integer.parseInt(helper);
                        if (num < alphabet.length()) {
                            String toAdd = String.valueOf(alphabet.charAt(num));
                            lestOfNums.add(toAdd);
                        } else {
                            num = num % (alphabet.length());
                            String toAdd = String.valueOf(alphabet.charAt(num));
                            lestOfNums.add(toAdd);
                        }
                        helper = "";

                    }
                    lestOfNums.add(toPrint);
                } else {
                    helper += toPrint;
                }
            }
        }
        return lestOfNums.toString();
//        ArrayList<String> messageList = new ArrayList<>();
//        ArrayList<String> alphaList = new ArrayList<>();
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        StringBuilder messageBuilder = new StringBuilder(message);
//        StringBuilder alphaBuilder = new StringBuilder(alphabet);
//        for (int i=0; i< messageBuilder.length(); i++) {
//            char ch = messageBuilder.charAt(i);
//            String letter = Character.toString(ch);
//            messageList.add(letter);
//        }
//        for (int i=0; i< alphaBuilder.length(); i++) {
//            char ch = alphaBuilder.charAt(i);
//            String letter = Character.toString(ch);
//            alphaList.add(letter);
//        }
//        for (String element : messageList) {
//            if (Integer.parseInt(element))
//        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(2);
        //System.out.println(countSingleTwos(list));
        System.out.println(decodeMessage("str52ing"));
    }
}