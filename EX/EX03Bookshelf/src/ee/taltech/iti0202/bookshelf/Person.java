package ee.taltech.iti0202.bookshelf;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person {
    String name;
    int money;
    HashMap<Book, String> bookOwners = new HashMap<>();

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public boolean buyBook(Book book) {
        for (Book key : bookOwners.keySet()) {
            if (key.equals(book)) {
                if (bookOwners.get(book).equals(null)) {
                    if (money > book.price) {
                        bookOwners.put(book, getName());
                        money = money - book.price;
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean sellBook(Book book) {
        return false;
    }
}
