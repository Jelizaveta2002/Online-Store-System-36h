package ee.taltech.iti0202.webbrowser;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WebBrowser {
    private String homePage;
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String currentPage;
    List<String> history = new ArrayList<>();

    /**
     * Goes to homepage.
     */
    public WebBrowser() {
        homePage();
    }
    public void homePage() {
        //TODO: implement
        goTo(homePage);
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        //TODO: implement
        forward.push(currentPage);
        currentPage = back.pop();
        history.add(currentPage);
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        //TODO: implement
        back.push(currentPage);
        currentPage = forward.pop();
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        //TODO: implement
        back.push(currentPage);
        currentPage = url;
        forward.clear();
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        //TODO: implement
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        //TODO: implement
    }

    public List<String> getBookmarks() {
        //TODO: implement
        return null;
    }

    public void setHomePage(String homePage) {
        //TODO: implement
    }


    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        //TODO: implement
        return null;
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
        //TODO: implement
        return history;
    }


    /**
     * Returns the active web page (string).
     *
     * @return active web page
     */
    public String getCurrentUrl() {
        //TODO: implement
        return currentPage;
    }
}
