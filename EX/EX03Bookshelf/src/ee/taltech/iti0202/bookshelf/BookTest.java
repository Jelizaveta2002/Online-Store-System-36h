package ee.taltech.iti0202.bookshelf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void getAndIncrementNextId() {
        Book book = new Book("Truth and Justice", "Tammsaare", 1926, 100);
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        int toCheck = 3;
        assertEquals(toCheck, Book.getAndIncrementNextId());
    }

    @Test
    void getTitle() {
        Book book = new Book("Truth and Justice", "Tammsaare", 1926, 100);
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        String toCheck = "Truth and Justice";
        assertEquals(toCheck, book.getTitle());
    }

    @Test
    void getAuthor() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        String toCheck = "VnaGoh";
        assertEquals(toCheck, oneBook.getAuthor());
    }

    @Test
    void getYearOfPublishing() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        int toCheck = 1900;
        assertEquals(toCheck, oneBook.getYearOfPublishing());
    }

    @Test
    void getOwner() {
        Person mati = new Person("Mati", 200);
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        mati.buyBook(oneBook);
        Person person = mati;
        assertEquals(person, oneBook.getOwner());
    }

    @Test
    void getPrice() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        int toCheck = 100;
        assertEquals(toCheck, oneBook.getPrice());
    }

    @Test
    void getId() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        int toCheck = 0;
        assertEquals(toCheck, oneBook.getId());
    }

    @Test
    void buy() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Person mati = new Person("Mati", 200);
        Person kati = new Person("Kati", 300);
        mati.buyBook(oneBook);
        boolean toCheck = true;
        assertEquals(toCheck, oneBook.buy(kati));
    }

    @Test
    void buy2() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 600);
        Person mati = new Person("Mati", 200);
        Person kati = new Person("Kati", 300);
        mati.buyBook(oneBook);
        boolean toCheck = false;
        assertEquals(toCheck, mati.buyBook(oneBook));
    }

    @Test
    void buy3() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Person mati = new Person("Mati", 200);
        mati.buyBook(oneBook);
        mati.sellBook(oneBook);
        Person kati = new Person("Kati", 400);
        boolean toCheck = true;
        assertEquals(toCheck, oneBook.buy(kati));
    }

    @Test
    void buy5() {
        Book oneBook = null;
        Person mati = new Person("Mati", 200);
        Person kati = new Person("Kati", 400);
        boolean toCheck = false;
        assertEquals(toCheck, mati.sellBook(oneBook));
    }

    @Test
    void buy6() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Person mati = new Person("Mati", 200);
        mati.buyBook(oneBook);
        Person kati = new Person("Kati", 400);
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void buy7() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Person mati = null;
        mati.buyBook(oneBook);
        Person kati = new Person("Kati", 400);
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void buy4() {
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Person mati = null;
        Person kati = new Person("Kati", 50);
        boolean toCheck = false;
        assertEquals(toCheck, oneBook.buy(mati));
    }

    @Test
    void of() {
        Book toCheck = new Book("Nothing", "VnaGoh", 1900, 100);
        assertEquals(toCheck, Book.of("Nothing", "VnaGoh", 1900, 100));
    }

    @Test
    void testOf() {
    }

    @Test
    void getBooksByOwner() {
        Person kati = new Person("Kati", 500);
        Book book = new Book("Truth and Justice", "Tammsaare", 1926, 100);
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Book twoBook = new Book("Nun", "VnaGoh", 1905, 160);
        kati.buyBook(book);
        kati.buyBook(oneBook);
        kati.buyBook(book);
        ArrayList<Book> toCheck = new ArrayList<>();
        toCheck.add(book);
        toCheck.add(oneBook);
        assertEquals(toCheck, Book.getBooksByOwner(kati));
    }

    @Test
    void getBooksByOwner2() {
        Person kati = new Person("Kati", 50);
        Book book = new Book("Truth and Justice", "Tammsaare", 1926, 100);
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Book twoBook = new Book("Nun", "VnaGoh", 1905, 160);
        kati.buyBook(null);
        kati.buyBook(null);
        kati.buyBook(book);
        ArrayList<Book> toCheck = new ArrayList<>();
        assertEquals(toCheck, Book.getBooksByOwner(kati));
    }

    @Test
    void getBooksByOwner3() {
        Person kati = new Person("Kati", 500);
        Book book = new Book("Truth and Justice", "Tammsaare", 1926, 100);
        Book oneBook = new Book("Nothing", "VnaGoh", 1900, 100);
        Book twoBook = new Book("Nun", "VnaGoh", 1905, 160);
        kati.buyBook(book);
        kati.buyBook(oneBook);
        kati.buyBook(twoBook);
        kati.sellBook(twoBook);
        ArrayList<Book> toCheck = new ArrayList<>();
        toCheck.add(book);
        toCheck.add(oneBook);
        assertEquals(toCheck, Book.getBooksByOwner(kati));
    }

    @Test
    void removeBook() {
        Person kati = new Person("Kati", 500);
        Book toCheck = Book.of("Nothing", "VnaGoh", 1900, 100);
        kati.buyBook(toCheck);
        Book toCheck2 = new Book("Somthing", "No one", 1970, 500);
        Book toCheck3 = new Book("Num", "VnaGoh3", 1960, 56);
        boolean result = true;
        assertEquals(result, Book.removeBook(toCheck));
    }

    @Test
    void removeBook2() {
        Person kati = new Person("Kati", 500);
        Book toCheck = null;
        kati.buyBook(toCheck);
        Book toCheck2 = new Book("Somthing", "No one", 1970, 500);
        Book toCheck3 = new Book("Num", "VnaGoh3", 1960, 56);
        boolean result = false;
        assertEquals(result, Book.removeBook(toCheck));
    }

    @Test
    void removeBook3() {
        Book toCheck = Book.of("Nothing", "VnaGoh", 1900, 100);
        Book toCheck2 = new Book("Somthing", "No one", 1970, 500);
        Book toCheck3 = new Book("Num", "VnaGoh3", 1960, 56);
        boolean result = true;
        assertEquals(result, Book.removeBook(toCheck));
    }


    @Test
    void getBooksByAuthor() {
        Book toCheck2 = Book.of("Nothing", "No one", 1900, 100);
        Book toCheck3 = Book.of("Sun", "VnaGoh", 1900, 170);
        Book toCheck4 = Book.of("Nun", "No one", 1960, 70);
        Person kati = new Person("Kati", 500);
        kati.buyBook(toCheck4);
        kati.buyBook(toCheck4);
        kati.buyBook(toCheck3);
        ArrayList<Book> toCheck = new ArrayList<Book>();
        toCheck.add(toCheck2);
        toCheck.add(toCheck4);
        assertEquals(toCheck, Book.getBooksByAuthor("No one"));
    }
}