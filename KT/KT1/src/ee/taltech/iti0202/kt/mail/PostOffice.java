package ee.taltech.iti0202.kt.mail;
import java.util.ArrayList;
import java.util.List;

public class PostOffice {
    private String location;
    ArrayList<Letter> lettersInOffice = new ArrayList<>();
    ArrayList<Postman> postmenInOffice = new ArrayList<>();
    /**
     * Create a post office with the location.
     */
    public PostOffice(String location) {
        this.location = location;
    }

    /**
     * Adds a letter to the post office.
     * Letter is added only if the letter's destination city matches the location of the office.
     */
    public void addLetter(Letter letter) {
        if (letter.getDestinationCity() != null && !letter.getDestinationCity().trim().isEmpty()) {
            if (this.location.equals(letter.getDestinationCity())) {
                this.lettersInOffice.add(letter);
            }
        }
    }

    /**
     * Adds a postman to the office.
     * If there is a postman with the same first letter already in the office,
     * then this postman is not added.
     * Otherwise postman is added to the office.
     */
    public void addPostman(Postman postman) {
        if (postman != null && postman.getName() != null && !postman.getName().trim().isEmpty()) {
            for (Postman man : this.postmenInOffice) {
                char firstChar = man.getName().charAt(0);
                String firstLetter = Character.toString(firstChar);
                char firstPostC = postman.getName().charAt(0);
                String firstPost = Character.toString(firstPostC);
                if (firstLetter.equals(firstPost)) {
                    return;
                }
                postmenInOffice.add(postman);
            }
        }
    }

    /**
     * Returns all the letter in the post office.
     */
    public List<Letter> getAllLetters() {
        return this.lettersInOffice;
    }

    /**
     * Returns all the postmen in the office.
     */
    public List<Postman> getPostmen() {
        return this.postmenInOffice;
    }

    /**
     * Divide letter in the office to postmen.
     * The division algorithm is as follows:
     * Each letter is assigned to each postman.
     * If the postman can take this letter (addLetter method), then this letter
     * is added to the postman and removed from the office.
     * If no postman can take the letter, then this letter remains in the office.
     */
    public void divideLetters() {
        for (Postman man : this.postmenInOffice) {
            for (Letter letter : this.lettersInOffice) {
                if (man.addLetter(letter)) {
                    this.lettersInOffice.remove(letter);
                }
                else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice("Tallinn");

        Postman postman = new Postman("Martin", 40);

        postOffice.addPostman(postman);

        postOffice.addLetter(new Letter("Toomas", "Tartu", "Rahu tn"));
        postOffice.addLetter(new Letter("Erki", "Tallinn", "Männi tee"));

        postOffice.divideLetters();

        System.out.println(postman.getLetters());   // [City: Tallinn, Address: Männi tee, Recipient: Erki]
    }
}
