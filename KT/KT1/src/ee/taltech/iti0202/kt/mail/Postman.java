package ee.taltech.iti0202.kt.mail;
import java.util.List;

public class Postman {
    /**
     * Create a postman with the name and the age.
     */
    public Postman(String name, Integer age) {
    }

    public String getName() {
        return null;
    }

    public List<Letter> getLetters() {
        return null;
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
        return false;
    }
}
