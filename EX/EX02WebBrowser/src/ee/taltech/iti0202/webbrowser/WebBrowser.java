package ee.taltech.iti0202.webbrowser;
import java.util.*;

public class WebBrowser {
    private String homePage;
    Stack<String> back = new Stack<>();
    Stack<String> forward = new Stack<>();
    String currentPage;
    List<String> history = new ArrayList<>();
    List<String> MyBookmark = new ArrayList<>();

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
        if (currentPage != null) {
            forward.push(currentPage);;
        }
        if (! back.isEmpty()) {
            currentPage = back.pop();
        }
        addHistory();
    }

    private void addHistory() {
        if (currentPage != null) {
            history.add(currentPage);
        }
    }

    /**
     * Goes forward to next page.
     */
    public void forward() {
        //TODO: implement
        if (currentPage != null) {
            back.push(currentPage);
        }
        if (! forward.isEmpty()) {
            currentPage = forward.pop();
        }
        addHistory();
    }

    /**
     * Go to a webpage.
     *
     * @param url url to go to
     */
    public void goTo(String url) {
        if (url == null) {
            return;
        }
        //TODO: implement
        if (currentPage != null) {
            back.push(currentPage);
        }
        currentPage = url;
        forward.clear();
        addHistory();
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
        if (homePage != null) {
            goTo(homePage);
        }
    }


    public String  helpFunction(HashMap<String, Integer>  resultMap) {
        StringBuilder myString = new StringBuilder();
        for (String key : resultMap.keySet()) {
            myString.append(key + " " +  "-" + " " + resultMap.get(key) + " " + "visits" + "\n");
        }
        return myString.toString();
    }



    /**
     * Get top 3 visited pages.
     *
     * @return a String that contains top three visited pages separated with a newline "\n"
     */
    public String getTop3VisitedPages() {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String url : history) {
            if (map.containsKey(url)) {
                map.put(url, map.get(url) + 1);
            } else {
                map.put(url, 1);
            }
        }
        List<UrlVisits> result = new ArrayList<>();
        for (String key : map.keySet()) {
            int value = map.get(key);
            result.add(new UrlVisits(key, value));

        }
        //System.out.println(result);
        Collections.sort(result);
        StringBuilder myString = new StringBuilder();
        int count = 0;
        for (UrlVisits urlVisits : result) {
            count += 1;
            myString.append(urlVisits.url + " " +  "-" + " " + urlVisits.visits + " " + "visits" + "\n");
            if (count == 3) {
                break;
            }
        }
        return myString.toString();

    }
//    public String getTop3VisitedPages() {
//        //TODO: implement
//        HashMap<String, Integer> map = new HashMap<>();
//        HashMap<String, Integer> resultMap = new HashMap<>();
//        for (String url : history) {
//            if (map.containsKey(url)) {
//                map.put(url, map.get(url) + 1);
//            } else {
//                map.put(url, 1);
//            }
//        }
//        if (map.size() == 1) {
//            return helpFunction(map);
//        }
//        if (map.size() == 1)
//        int maxVisits = 0;
//        String result = null;
//        for (String key : map.keySet()) {
//            int value = map.get(key);
//            if (value > maxVisits) {
//                maxVisits = value;
//                result = key;
//            }
//        } resultMap.put(result, maxVisits);
//        map.remove(result);
//        System.out.println(map);
//        int maxVisits1 = 0;
//        String result1 = null;
//        for (String key : map.keySet()) {
//            int value = map.get(key);
//            if (value > maxVisits1) {
//                maxVisits1 = value;
//                result1 = key;
//            }
//        } resultMap.put(result1, maxVisits1);
//         map.remove(result1);
//        int maxVisits2 = 0;
//        String result2 = null;
//        for (String key : map.keySet()) {
//            int value = map.get(key);
//            if (value > maxVisits2) {
//                maxVisits2 = value;
//                result2 = key;
//            }
//        } resultMap.put(result2, maxVisits2);
//        map.remove(result2);
//        StringBuilder myString = new StringBuilder();
//        for (String key : resultMap.keySet()) {
//            myString.append(key + " " +  "-" + " " + resultMap.get(key) + " " + "visits" + "\n");
//        } String finalResult = myString.toString();
//        return finalResult;
//    }

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
//        browser.goTo("google.com");
//        browser.goTo("yahoo.com");
//        browser.goTo("facebook.com");
//        browser.goTo("ois.ee");
//        browser.goTo("jetbrains.com");
//        browser.goTo("taltech.com");
//        browser.goTo("solnet.net");
//        browser.goTo("instagram.com");
//        browser.goTo("google.com");
//        browser.goTo("facebook.com");
//        browser.goTo("ois.ee");
//        browser.goTo("google.com");
        browser.forward();
        System.out.println(browser.getTop3VisitedPages());

    }
    public static class UrlVisits implements Comparable<UrlVisits>{
        private String url;
        private Integer visits;
        UrlVisits(String url, Integer visits) {
            this.url = url;
            this.visits = visits;
        }

        @Override  public int compareTo(UrlVisits o) {
            return o.visits.compareTo(visits);
        }

        @Override  public String toString() {
            return "UrlVisits{" +
                    "url='" + url + '\'' +
                    ", visits=" + visits +
                    '}';
        }
    }
}
