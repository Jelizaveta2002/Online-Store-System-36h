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
    ///static ArrayList<Book> bookList = new ArrayList<>();
    static int helper;
    static List<Book> bookOfList = new ArrayList<>();


    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
       ///bookList.add(this);
    }

    public boolean equals(Book obj) {
        return Objects.equals(obj.getTitle(), title) && Objects.equals(obj.getAuthor(), author)
                && obj.getYearOfPublishing() == yearOfPublishing && obj.getPrice() == price;
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
        if (! bookOfList.isEmpty()) {
            for (Book book : bookOfList) {
                if (book == null) {
                    continue;
                }
                if (Objects.equals(book.getTitle(), title) && Objects.equals(book.getAuthor(), author)
                        && book.getYearOfPublishing() == yearOfPublishing && book.getPrice() == price) {
                    return book;
                }
            }
        }
        Book neBook = new Book(title, author, yearOfPublishing, price);
        bookOfList.add(neBook);
        return neBook;
    }

    public static Book of(String title, int price) {
        return null;
    }

    public static List<Book> getBooksByOwner(Person owner) {
        for (Person person : Person.bookOwners.keySet()) {
            if (person.name.equals(owner.name) && person.money == owner.money) {
                System.out.println(Person.bookOwners);
                return owner.getBooks();
            }
        }return new ArrayList<>();
    }

    public static boolean iterateValueList(ArrayList<Book> list, Book book) {
        if (! list.isEmpty()) {
            for (Book i : list) {
                if (i.price == book.price && Objects.equals(i.title, book.title) && i.yearOfPublishing == book.yearOfPublishing && Objects.equals(i.author, book.author)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean removeBook(Book book) {
        if (book != null) {
            if(!bookOfList.isEmpty()) {
                bookOfList.remove(book);
                for (Person person : Person.bookOwners.keySet()) {
                    if (iterateValueList(Person.bookOwners.get(person), book)) {
                        person.sellBook(book);
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static List<Book> getBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookOfList) {
            if (book.author.equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", price=" + price +
                ", id=" + id +
                ", owner=" + owner +
                '}';
    }
}