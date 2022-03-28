package ee.taltech.iti0202.kt.mail;
import java.util.ArrayList;
import java.util.List;

public class Postman {
    public static final int FORTY = 40;
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
        if (this.age >= FORTY) {
            this.limitOfLetters = age - name.length();
        } else {
            this.limitOfLetters = age + name.length();
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Letter> getLetters() {
        return this.letters;
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
        if (this.name != null && letter != null && letter.getAddress() != null) {
            char nameChar = this.name.charAt(0);
            String name = Character.toString(nameChar);
            char nameLetterChar = letter.getAddress().charAt(0);
            String nameLetter = Character.toString(nameLetterChar);
            if (name.equals(nameLetter) && this.letters.size() < this.limitOfLetters) {
                this.letters.add(letter);
                return true;
            }
            return false;
        }
        return false;
    }
}
