package ee.taltech.iti0202.webbrowser;
import java.util.*;

public class WebBrowser {
    private String homePage;
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String currentPage = homePage;
    List<String> history = new ArrayList<>();
    List<String> MyBookmark = new ArrayList<>();
    HashMap<String, Integer> popularMap = new HashMap<>();
    HashMap<String, Integer> myMapp = new HashMap<>();
    List<String> toStorePop = new ArrayList<>();

    /**
     * Goes to homepage.
     */

    public WebBrowser() {
        this.homePage = "google.com";
        currentPage = homePage;
        history.add(homePage);
        back.push(homePage);
    }

    public void homePage() {
        //TODO: implement
        if (currentPage != homePage){
            history.add(homePage);
            back.push(homePage);
        }
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        //TODO: implement
        if (currentPage != null) {
            forward.push(currentPage);;
        } if (! back.isEmpty()) {
            currentPage = back.pop();
        } history.add(currentPage);
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        //TODO: implement
        if (currentPage != homePage) {
            back.push(currentPage);
        } if (! forward.isEmpty()) {
            currentPage = forward.pop();
        } history.add(currentPage);
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        //TODO: implement
        if (currentPage != homePage) {
            history.add(currentPage);
        }
        back.push(currentPage);
        currentPage = url;
        forward.clear();
    }

    /**
     * Add a webpage as a bookmark.
     */
    public void addAsBookmark() {
        //TODO: implement
        String myPage = currentPage.toString();
        for (String i : MyBookmark) {
            if (Objects.equals(i, myPage)) {
                return;
            }
        } MyBookmark.add(currentPage);
    }

    /**
     * Remove a bookmark.
     *
     * @param bookmark to remove
     */
    public void removeBookmark(String bookmark) {
        //TODO: implement
        MyBookmark.remove(bookmark);
    }

    public List<String> getBookmarks() {
        //TODO: implement
        return MyBookmark;
    }

    public void setHomePage(String homePage) {
        //TODO: implement
        goTo(homePage);
    }

    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public void help1(HashMap<String, Integer> map, Integer i) {
        int maxVisits = 0;
        String result = null;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value > maxVisits) {
                maxVisits = value;
                result = key;
            }
        } if (maxVisits != 1) {
            toStorePop.add(i, result + " " +  "-" + " " + maxVisits + " " + "visits" + "\n");
        }
        else {
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
        //TODO: implement
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String url : history) {
            if (myMapp.containsKey(url)) {
                myMapp.put(url, myMapp.get(url) + 1);
            } else {
                myMapp.put(url, 1);
            }
        } for (int i = 0; i < 3; i++ ) {
            help1(myMapp, i);
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

    public static void main(String[] args) {
        WebBrowser browser = new WebBrowser();
        browser.goTo("google.com");
        browser.goTo("yahoo.com");
        browser.goTo("facebook.com");
        browser.goTo("ois.ee");
        browser.goTo("jetbrains.com");
        browser.goTo("taltech.com");
        browser.goTo("solnet.net");
        browser.goTo("instagram.com");
        browser.goTo("google.com");
        browser.goTo("facebook.com");
        browser.goTo("ois.ee");
        browser.goTo("google.com");
        browser.forward();
        browser.forward();
        browser.forward();
        browser.back();
        System.out.println(browser.getTop3VisitedPages());
    }
}