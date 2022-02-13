package ee.taltech.iti0202.bookshelf;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Person {
    String name;
    int money;
    //static HashMap<Book, Person> bookOwners = new HashMap<>();
    static List<Person> persons = new ArrayList<>();


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

    public boolean buyBook(Book book) {
        if (book == null || book.owner != null || book.price > money ) {
            return false;
        }
        book.setOwner(this);
        money = money - book.price;
        return true;
    }

    public boolean sellBook(Book book) {
        if (book == null || book.owner != this) {
            return false;
        }
        book.setOwner(null);
        money = money + book.price;
        return true;
    }
}