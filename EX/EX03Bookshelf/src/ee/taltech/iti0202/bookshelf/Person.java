package ee.taltech.iti0202.bookshelf;


import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int money;
    List<Book> bookList = new ArrayList<>();

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
        if (bookList.isEmpty()) {
            return false;
        }
        else if (bookList.contains(book)) {
            return false;
        }
        else if (book.price > money) {
            return false;
        }
        else {
            bookList.add(book);
            money = money - book.price;
            return true;
        }
    }

    public boolean sellBook(Book book) {
        return false;
    }
}
