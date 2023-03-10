package ee.taltech.iti0202.webbrowser;

import java.util.List;
import java.util.Stack;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;

public class WebBrowser {
    private String homePage = "google.com";
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String currentPage = homePage;
    List<String> history = new ArrayList<>();
    List<String> myBookmark = new ArrayList<>();
    HashMap<String, Integer> popularMap = new HashMap<>();
    Map<String, Integer> myMapp = new LinkedHashMap<>();
    List<String> toStorePop = new ArrayList<>();

    /**
     * Goes to homepage.
     */

    public WebBrowser() {
        history.add(currentPage);
    }

    public void homePage() {
        goTo(homePage);
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        forward.push(currentPage);
        int sizeOfStack = back.size();
        if (sizeOfStack >= 1) {
            currentPage = back.pop();
            history.add(currentPage);
        }
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        back.push(currentPage);
        if (!forward.isEmpty()) {
            currentPage = forward.pop();
            history.add(currentPage);
        }
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        if (url.equals(currentPage)) {
            return;
        }
        back.push(currentPage);
        currentPage = url;
        forward.clear();
        history.add(currentPage);
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        String myPage = currentPage.toString();
        for (String i : myBookmark) {
            if (Objects.equals(i, myPage)) {
                return;
            }
        } myBookmark.add(currentPage);
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */

    public void removeBookmark(String bookmark) {
        myBookmark.remove(bookmark);
    }

    public List<String> getBookmarks() {
        return myBookmark;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    /**
     * Get top 3 visited pages.
     *  @param map to remove
     *  @param i to remove
     */
    public void help1(Map<String, Integer> map, int i) {
        int maxVisits = 0;
        String result = null;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value > maxVisits) {
                maxVisits = value;
                result = key;
            }
        }
        if (maxVisits != 1) {
            toStorePop.add(i, result + " " +  "-" + " " + maxVisits + " " + "visits" + "\n");
        } else {
            toStorePop.add(i, result + " " +  "-" + " " + maxVisits + " " + "visit" + "\n");
        }
        myMapp.remove(result);
    }

    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (String url : history) {
            if (myMapp.containsKey(url)) {
                myMapp.put(url, myMapp.get(url) + 1);
            } else {
                myMapp.put(url, 1);
            }
        } int mapSize = myMapp.size();
        if (mapSize >= 3) {
            for (int i = 0; i < 3; i++) {
                help1(myMapp, i);
            }
        } else {
            for (int i = 0; i < mapSize; i++) {
                help1(myMapp, i);
            }
        }
        StringBuilder myString = new StringBuilder();
        for (String a : toStorePop) {
            myString.append(a);
        }
        String finalResult = myString.toString();
        return finalResult;
    }

    /**
     * Returns a list of all visited pages.
     *
     * Not to be confused with pages in your back-history.
     *
     * For example, if you visit "facebook.com" and hit back(),
     * then the whole history would be: ["google.com", "facebook.com", "google.com"]
     * @return list of all visited pages
     */
    public List<String> getHistory() {
        return history;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        return currentPage;
    }

    public static void main(String[] args) {
        WebBrowser browser = new WebBrowser();
        browser.setHomePage("neti.ee"); //
        browser.goTo("google.com");
        browser.goTo("google.com");
        browser.forward();
        browser.addAsBookmark();
        browser.setHomePage("ois.ee");
        browser.goTo("google.com");
        browser.setHomePage("facebook.com");
        browser.back();
        browser.homePage();
        System.out.println(browser.getBookmarks());
    }
}
