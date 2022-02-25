package ee.taltech.iti0202.tk1.art;

public class Painting {
    private String author;
    private String title;
    public Painting(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Painting(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        if (this.getAuthor() != null) {
            return "This is a painting named " + this.getTitle() + " and made by " + this.getAuthor() + ".";
        }
        return "This is a painting named " + this.getTitle() + " and made by an unknown artist.";
    }

}
