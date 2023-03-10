package ee.taltech.iti0202.bookshelf;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person {
    String name;
    int money;
    static HashMap<Person, ArrayList<Book>> bookOwners = new HashMap<>();
    static List<Person> persons = new ArrayList<>();

    /**
     * Remove a bookmark.
     *
     * @param name boolean
     * @param money boolean
     */
    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        persons.add(this);
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    /**
     * Remove a bookmark.
     *
     * @param book boolean
     */
    public boolean canBuy(Book book) {
        return book != null && book.price < this.money;
    }

    /**
     * Remove a bookmark.
     *
     * @param book boolean
     */
    public boolean buyBook(Book book) {
        if (book == null || book.owner != null || book.price > this.money) {
            return false;
        }
        for (Person key : bookOwners.keySet()) {
            if (key.equals(this)) {
                bookOwners.get(this).add(book);
                book.setOwner(this);
                this.money = this.money - book.price;
                System.out.println(bookOwners);
                return true;
            }
        }
        bookOwners.put(this, new ArrayList<>());
        bookOwners.get(this).add(book);
        //System.out.println(bookOwners);
        book.setOwner(this);
        this.money = this.money - book.price;
        return true;
    }

    /**
     * Remove a bookmark.
     *
     * @param book boolean
     */
    public boolean sellBook(Book book) {
        if (book == null || book.owner != this) {
            return false;
        }
        bookOwners.get(this).remove(book);
        book.setOwner(null);
        this.money = this.money + book.price;
        return true;
    }


    public List<Book> getBooks() {
        return bookOwners.get(this);
    }
}
