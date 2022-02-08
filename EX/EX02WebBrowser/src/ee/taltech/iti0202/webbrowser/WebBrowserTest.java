package ee.taltech.iti0202.webbrowser;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebBrowserTest {

    @Test
    void getBookmarks() {
        WebBrowser browser = new WebBrowser();
        browser.setHomePage("neti.ee"); //
        browser.goTo("facebook.com"); //
        browser.goTo("google.com"); //
        browser.back(); //
        browser.addAsBookmark(); //
        browser.forward(); //
        browser.homePage(); //
        browser.addAsBookmark(); //
        List<String> myList = Arrays.asList("facebook.com", "neti.ee");;
        assertEquals(browser.getBookmarks(), myList);
    }

    @Test
    void getBookmarksRemove() {
        WebBrowser browser = new WebBrowser();
        browser.setHomePage("neti.ee"); //
        browser.goTo("facebook.com"); //
        browser.goTo("google.com"); //
        browser.back(); //
        browser.addAsBookmark(); //
        browser.setHomePage("neti.ee");
        browser.forward(); //
        browser.goTo("facebook.com");
        browser.goTo("facebook.com");
        browser.addAsBookmark();
        browser.setHomePage("google.ee");
        browser.homePage(); //
        browser.goTo("google.com");
        browser.addAsBookmark();
        browser.removeBookmark("facebook.com"); //
        List<String> myList = List.of("google.com");;
        assertEquals(browser.getBookmarks(), myList);
    }

    @Test
    void getTop3VisitedPages() {
        WebBrowser browser = new WebBrowser();
        browser.setHomePage("neti.ee"); //
        browser.goTo("facebook.com"); //
        browser.goTo("google.com"); //
        browser.back(); //
        String check = "google.com - 2 visits" + "\n" + "facebook.com - 2 visits" + "\n";
        assertEquals(check, browser.getTop3VisitedPages());
    }

    @Test
    void getTop3VisitedPagesNoPages() {
        WebBrowser browser = new WebBrowser();
        browser.setHomePage("neti.ee"); //
        String check = "google.com - 1 visit" + "\n";
        assertEquals(check, browser.getTop3VisitedPages());
    }

    @Test
    void getHistory() {
        WebBrowser mine = new WebBrowser();
        mine.setHomePage("neti.ee");
        mine.goTo("facebook.com");
        mine.forward();
        mine.forward();
        List<String> checkList = Arrays.asList("google.com", "facebook.com");
        assertEquals(checkList, mine.getHistory());
    }

    @Test
    void getCurrentUrl() {
        WebBrowser mine = new WebBrowser();
        mine.setHomePage("neti.ee");
        mine.goTo("google.com");
        mine.back();
        mine.goTo("ois.com");
        mine.goTo("jetbrains.com");
        mine.back();
        String checkList = "ois.com";
        assertEquals(checkList, mine.getCurrentUrl());
    }


    @Test
    void getCurrentUrl2() {
        WebBrowser mine = new WebBrowser();
        mine.setHomePage("google");
        mine.goTo("ois.com");
        mine.back();
        mine.back();
        mine.back();
        mine.back();
        mine.goTo("facebook.com");
        mine.goTo("jetbrains.com");
        mine.back();
        mine.forward();
        String checkList = "jetbrains.com";
        assertEquals(checkList, mine.getCurrentUrl());
    }

    @Test
    void main() {
    }
}