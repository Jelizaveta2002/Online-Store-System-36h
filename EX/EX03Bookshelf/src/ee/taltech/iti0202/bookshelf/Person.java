package ee.taltech.iti0202.bookshelf;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

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
        if (book == null) {
            return false;
        }
        else if (! bookOwners.isEmpty()) {
            for (Book key : bookOwners.keySet()) {
                if (key.equals(book) && bookOwners.get(key) != null) {
                    return false;
                }
                else if (key.equals(book) && bookOwners.get(key) == null) {
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
        else if (money > book.price) {
            bookOwners.put(book, getName());
            money = money - book.price;
            return true;
        }
        return  false;
    }

    public boolean sellBook(Book book) {
        if (book == null) {
            return false;
        }
        else if (! bookOwners.isEmpty()) {
            for (Book key : bookOwners.keySet()) {
                if (key == book) {
                    if (Objects.equals(bookOwners.get(book), getName())) {
                        money = money + book.price;
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        } return false;
    }
}