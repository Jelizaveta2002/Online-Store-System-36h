package ee.taltech.iti0202.socialnetwork.message;

import ee.taltech.iti0202.socialnetwork.user.User;

public class Message {
    private final String title;
    private final String message;
    private final User author;


    /**
     * Create a new stock with the given name and the max capacity for the products.
     * @param message the name of the stock.
     * @param title the name of the stock.
     * @param author the name of the stock.
     */
    public Message(String title, String message, User author) {
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public User getAuthor() {
        return author;
    }
}
