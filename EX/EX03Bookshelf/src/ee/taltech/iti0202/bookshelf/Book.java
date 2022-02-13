package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Book {
    String title;
    String author;
    int yearOfPublishing;
    int price;
    int id = getAndIncrementNextId();
    Person owner;
    static List<Book> bookList = new ArrayList<>();
    static int helper;


    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
        bookList.add(this);
    }

    public static int getAndIncrementNextId() {
        return helper++;
    }

    public void setOwner(Person owner) {
       this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public Person getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public boolean buy(Person buyer) {
        if (buyer != null && buyer.canBuy(this) ) {
            Person prevOwner = this.owner;
            boolean two = prevOwner.sellBook(this);
            boolean one = buyer.buyBook(this);
            return one && two;
        }
        return false;
    }

}