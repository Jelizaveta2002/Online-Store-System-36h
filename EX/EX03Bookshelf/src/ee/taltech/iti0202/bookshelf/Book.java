package ee.taltech.iti0202.bookshelf;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {
    String title;
    String author;
    int yearOfPublishing;
    int price;
    int id = getAndIncrementNextId();
    Person owner;
    static int helper;
    static ArrayList<Book> bookOfList = new ArrayList<>();

    /**
     * Get top 3 visited pages.
     *  @param title to remove
     *  @param author to remove
     *  @param yearOfPublishing to remove
     *  @param price to remove
     */

    public Book(String title, String author, int yearOfPublishing, int price) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.price = price;
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

    /**
     * Remove a bookmark.
     *
     * @param buyer boolean
     */
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

    /**
     * Remove a bookmark.
     *
     * @param title boolean
     * @param author boolean
     * @param yearOfPublishing boolean
     * @param price boolean
     */
    public static Book of(String title, String author, int yearOfPublishing, int price) {
        return of(new Book(title, author, yearOfPublishing, price));
    }

    /**
     * Remove a bookmark.
     *
     * @param bookToCheck boolean
     */
    private static Book of(Book bookToCheck) {
        if (!bookOfList.isEmpty()) {
            for (Book book : bookOfList) {
                if (book == null) {
                    continue;
                }
                if (Objects.equals(book.getTitle(), bookToCheck.getTitle())
                        && Objects.equals(book.getAuthor(), bookToCheck.getAuthor())
                        && book.getYearOfPublishing() == bookToCheck.getYearOfPublishing()
                        && book.getPrice() == bookToCheck.getPrice()) {
                    return book;
                }
            }
        }
        bookOfList.add(bookToCheck);
        return bookToCheck;
    }


    /**
     * Remove a bookmark.
     *
     * @param title boolean
     * @param price boolean
     */
    public static Book of(String title, int price) {
        if (bookOfList.isEmpty()) {
            return null;
        }
        Book neededBook = bookOfList.get(bookOfList.size() - 1);
        Book book = of(new Book(title, neededBook.getAuthor(), neededBook.getYearOfPublishing(), price));
        return book;

    }

    /**
     * Remove a bookmark.
     *
     * @param owner boolean
     */
    public static List<Book> getBooksByOwner(Person owner) {
        for (Person person : Person.bookOwners.keySet()) {
            if (person.name.equals(owner.name) && person.money == owner.money) {
                return owner.getBooks();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Remove a bookmark.
     *
     * @param list boolean
     * @param book boolean
     */
    public static boolean iterateValueList(ArrayList<Book> list, Book book) {
        if (!list.isEmpty()) {
            for (Book i : list) {
                if (i.price == book.price && Objects.equals(i.title, book.title)
                        && i.yearOfPublishing == book.yearOfPublishing && Objects.equals(i.author, book.author)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Remove a bookmark.
     *
     * @param book boolean
     */
    public static boolean removeBook(Book book) {
        if (book != null && iterateValueList(bookOfList, book)) {
            for (Person person : Person.bookOwners.keySet()) {
                if (iterateValueList(Person.bookOwners.get(person), book)) {
                    person.sellBook(book);
                    break;
                }
            }
            bookOfList.remove(book);
            return true;
        }
        return false;
    }

    /**
     * Remove a bookmark.
     *
     * @param author boolean
     */
    public static List<Book> getBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : bookOfList) {
            if (book.author.equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
}
