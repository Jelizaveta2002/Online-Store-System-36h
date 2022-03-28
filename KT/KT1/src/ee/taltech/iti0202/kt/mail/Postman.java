package ee.taltech.iti0202.kt.mail;
import java.util.ArrayList;
import java.util.List;

public class Postman {
    private String name;
    private Integer age;
    Integer limitOfLetters;
    ArrayList<Letter> letters = new ArrayList<>();
    /**
     * Create a postman with the name and the age.
     */
    public Postman(String name, Integer age) {
        this.name = name;
        this.age = age;
        if (this.age >= 40) {
            limitOfLetters = age - name.length();
        }
        else {
            limitOfLetters = age + name.length();
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Adds a letter to postman.
     * The letter can be added if the name of the postman and the name of the letter's address
     * start with the same symbol.
     * Also, each postman has a letter limit.
     * If the age of the postman is 40 or larger, then the limit of the letters is: age - name length
     * If the age of the postman is below 40, the limit is age + name length.
     * If the first letters do not match or the letter limit is reached, returns false.
     * Otherwise returns true and letter is added to postman.
     */
    public boolean addLetter(Letter letter) {
        char nameChar = this.name.charAt(0);
        String name = Character.toString(nameChar);
        char nameLetterChar = letter.getAddress().charAt(0);
        String nameLetter = Character.toString(nameLetterChar);
        if (name.equalsIgnoreCase(nameLetter) && letters.size() < limitOfLetters) {
            letters.add(letter);
            return true;
        }
        return false;
    }
}
