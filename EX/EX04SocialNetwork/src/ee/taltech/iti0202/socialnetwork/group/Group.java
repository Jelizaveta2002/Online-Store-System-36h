package ee.taltech.iti0202.socialnetwork.group;

import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private String name;
    private final User owner;
    private final ArrayList<Message> listOfMessages = new ArrayList<>();
    private int numOfMessage = -1;
    private final Set<User> hashOfUsers = new HashSet<>();


    /**
     * Create a new stock with the given name and the max capacity for the products.
     * @param name the name of the stock.
     * @param owner the name of the stock.
     */
    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        if (owner != null) {
            hashOfUsers.add(owner);
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Create a new stock with the given name and the max capacity for the products.
     * @param name the name of the stock.
     */
    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    /**
     * Create a new stock with the given name and the max capacity for the products.
     * @param user the name of the stock.
     */
    public boolean ifUserAlreadyInHash(User user) {
        for (User us : hashOfUsers) {
            if (us.getName().equals(user.getName()) && us.getAge().equals(user.getAge())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Create a new stock with the given name and the max capacity for the products.
     * @param user the name of the stock.
     */
    public void addUser(User user) {
        if (user != null && ifUserAlreadyInHash(user)) {
            hashOfUsers.add(user);
            user.getGroupsOfOwners().get(user).add(this);
        }
    }

    public Set<User> getParticipants() {
        return hashOfUsers;
    }

    /**
     * Create a new stock with the given name and the max capacity for the products.
     * @param message the name of the stock.
     */
    public void publishMessage(Message message) {
        if (message != null && message.getAuthor() != null) {
            if (hashOfUsers.contains(message.getAuthor())) {
                numOfMessage += 1;
                listOfMessages.add(numOfMessage, message);
            }
        }
    }

    public List<Message> getMessages() {
        return listOfMessages;
    }
}
