package ee.taltech.iti0202.webbrowser;
import java.util.*;

public class WebBrowser {
    private String homePage = "google.com";
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String currentPage = homePage;
    List<String> history = new ArrayList<>();
    List<String> MyBookmark = new ArrayList<>();
    HashMap<String, Integer> popularMap = new HashMap<>();
    HashMap<String, Integer> myMapp = new HashMap<>();

    /**
     * Goes to homepage.
     */
    public void homePage() {
        //TODO: implement
        history.add(homePage);
        back.add(homePage);
        forward.clear();
    }

    /**
     * Goes back to previous page.
     */
    public void back() {
        //TODO: implement
        if (currentPage != null) {
            forward.push(currentPage);;
        }
        if (! back.isEmpty()) {
            currentPage = back.pop();
        }
        history.add(currentPage);
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        //TODO: implement
        if (currentPage != null) {
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
        back.push(currentPage);
        currentPage = url;
        forward.clear();
        history.add(currentPage);
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
    public void help1(HashMap<String, Integer> map) {
        int maxVisits = 0;
        String result = null;
        for (String key : map.keySet()) {
            int value = map.get(key);
            if (value > maxVisits) {
                maxVisits = value;
                result = key;
            }
        } popularMap.put(result, maxVisits);
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
        } help1(myMapp);
        help1(myMapp);
        help1(myMapp);
        StringBuilder myString = new StringBuilder();
        for (String key : popularMap.keySet()) {
            if (popularMap.get(key) != 1) {
                myString.append(key + " " +  "-" + " " + popularMap.get(key) + " " + "visits" + "\n");
            } else {
                myString.append(key + " " +  "-" + " " + popularMap.get(key) + " " + "visit" + "\n");
            }
        } String finalResult = myString.toString();
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
}

