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
    static List<Book> bookOfList = new ArrayList<>();


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
        if (buyer != this.owner && buyer != null && buyer.canBuy(this) && this.owner != null) {
            Person prevOwner = this.owner;
            prevOwner.sellBook(this);
            buyer.buyBook(this);
            return true;
        }
        if (buyer != this.owner && buyer != null && buyer.canBuy(this) && this.owner == null) {
            buyer.buyBook(this);
            return true;
        }
        if (buyer != this.owner && buyer == null) {
            this.owner.sellBook(this);
            return true;
        }
        return false;
    }

    public static Book of(String title, String author, int yearOfPublishing, int price) {
        for (Book i : bookOfList) {
            if (Objects.equals(i.getTitle(), title) && Objects.equals(i.getAuthor(), author)
                    && i.getYearOfPublishing() == yearOfPublishing && i.getPrice() == price) {
                return i;
            }
        }
        bookOfList.add(new Book(title, author, yearOfPublishing, price));
        return new Book(title, author, yearOfPublishing, price);
    }

    public static Book of(String title, int price) {
        return null;
    }
}