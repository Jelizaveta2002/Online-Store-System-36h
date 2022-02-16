package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    public static final int ONENINETWOSIX = 1926;
    public static final int ONEZEROZERO = 100;
    public static final int ONENINEZEROZERO = 1900;
    public static final int TWOZEROZERO = 200;
    public static final int ONENINEFIVEZERO = 1950;
    public static final int THREEZEROZERO = 300;
    public static final int SIXZEROZERO = 600;
    public static final int NINEZEROZERO = 900;
    public static final int FIVEZEROZERO = 500;
    public static final int FIVEZERO = 50;
    public static final int ONESEVENZERO = 170;
    public static final int ONENINESIXZERO = 1960;
    public static final int SEVENZERO = 70;

    @Test
    void getAndIncrementNextId() {
        int toCheck = 2;
        assertEquals(toCheck, Book.getAndIncrementNextId());
    }

    @Test
    void getTitle() {
        Book book = new Book("Truth and Justice", "Tammsaare", ONENINETWOSIX, ONEZEROZERO);
        String toCheck = "Truth and Justice";
        assertEquals(toCheck, book.getTitle());
    }

    @Test
    void getAuthor() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        String toCheck = "VnaGoh";
        assertEquals(toCheck, oneBook.getAuthor());
    }

    @Test
    void getYearOfPublishing() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        int toCheck = ONENINEZEROZERO;
        assertEquals(toCheck, oneBook.getYearOfPublishing());
    }

    @Test
    void getOwner() {
        Person mati = new Person("Mati", TWOZEROZERO);
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        mati.buyBook(oneBook);
        assertEquals(mati, oneBook.getOwner());
    }

    @Test
    void getPrice() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        int toCheck = ONEZEROZERO;
        assertEquals(toCheck, oneBook.getPrice());
    }

    @Test
    void getId() {
        Book book = new Book("Smth", "VnaGoh22", ONENINEFIVEZERO, ONEZEROZERO);
        int toCheck = 1;
        assertEquals(toCheck, book.getId());
    }

    @Test
    void buy() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        Person mati = new Person("Mati", TWOZEROZERO);
        Person kati = new Person("Kati", THREEZEROZERO);
        mati.buyBook(oneBook);
        boolean toCheck = true;
        assertEquals(toCheck, oneBook.buy(kati));
    }

    @Test
    void buy2() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, SIXZEROZERO);
        Person mati = new Person("Mati", NINEZEROZERO);
        boolean toCheck = true;
        assertEquals(toCheck, mati.buyBook(oneBook));
    }

    @Test
    void buy3() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        Person mati = null;
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void buy5() {
        Book oneBook = null;
        Person mati = new Person("Mati", TWOZEROZERO);
        boolean toCheck = false;
        assertEquals(toCheck, mati.sellBook(oneBook));
    }

    @Test
    void buy6() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        Person mati = new Person("Mati", TWOZEROZERO);
        mati.buyBook(oneBook);
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void buy7() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        Person mati = new Person("Mati", FIVEZEROZERO);
        mati.buyBook(oneBook);
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void buy4() {
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        Person mati = null;
        Person kati = new Person("Kati", FIVEZERO);
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void of1() {
        Book first = Book.of("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        assertEquals(first, Book.of("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO));
    }

    @Test
    void of2() {
        Book second = Book.of("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        assertEquals(second, Book.of("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO));
    }

    @Test
    void testOf() {
    }

    @Test
    void getBooksByOwner() {
        Person kati = new Person("Kati", FIVEZEROZERO);
        Book book = new Book("Truth and Justice", "Tammsaare", ONENINETWOSIX, ONEZEROZERO);
        Book oneBook = new Book("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        kati.buyBook(book);
        kati.buyBook(oneBook);
        ArrayList<Book> toCheck = new ArrayList<>();
        toCheck.add(book);
        toCheck.add(oneBook);
        assertEquals(toCheck, Book.getBooksByOwner(kati));
    }

    @Test
    void getBooksByOwner3() {
        Person kati = new Person("Kati", FIVEZEROZERO);
        Book book = new Book("Truth and Justice", "Tammsaare", ONENINETWOSIX, ONEZEROZERO);
        kati.buyBook(book);
        kati.sellBook(book);
        ArrayList<Book> toCheck = new ArrayList<>();
        assertEquals(toCheck, Book.getBooksByOwner(kati));
    }

    @Test
    void removeBook() {
        Person kati = new Person("Kati", FIVEZEROZERO);
        Book toCheck = Book.of("Nothing", "VnaGoh", ONENINEZEROZERO, ONEZEROZERO);
        kati.buyBook(toCheck);
        boolean result = true;
        assertEquals(result, Book.removeBook(toCheck));
    }

    @Test
    void removeBook2() {
        Book toCheck = null;
        boolean result = false;
        assertEquals(result, Book.removeBook(toCheck));
    }


    @Test
    void getBooksByAuthor() {
        Book toCheck2 = Book.of("Nothing", "No one", ONENINEZEROZERO, ONEZEROZERO);
        Book toCheck3 = Book.of("Sun", "VnaGoh", ONENINEZEROZERO, ONESEVENZERO);
        Book toCheck4 = Book.of("Nun", "No one", ONENINESIXZERO, SEVENZERO);
        ArrayList<Book> toCheck = new ArrayList<Book>();
        toCheck.add(toCheck2);
        toCheck.add(toCheck4);
        assertEquals(toCheck, Book.getBooksByAuthor("No one"));
    }

    @Test
    void personBuy() {
        Book toCheck2 = Book.of("Nothing", "No one", ONENINEZEROZERO, ONEZEROZERO);
        Book toCheck3 = Book.of("Sun", "VnaGoh", ONENINEZEROZERO, ONESEVENZERO);
        Book toCheck4 = Book.of("Nun", "No one", ONENINESIXZERO, SEVENZERO);
        ArrayList<Book> toCheck = new ArrayList<Book>();
        toCheck.add(toCheck2);
        toCheck.add(toCheck4);
        assertEquals(toCheck, Book.getBooksByAuthor("No one"));
    }
}