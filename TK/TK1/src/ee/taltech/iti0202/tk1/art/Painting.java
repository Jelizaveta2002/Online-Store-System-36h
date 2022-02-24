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

    @Override
    public String toString() {
        return "Painting{}";
    }

    public String getAuthor() {
        return this.author;
    }

}
