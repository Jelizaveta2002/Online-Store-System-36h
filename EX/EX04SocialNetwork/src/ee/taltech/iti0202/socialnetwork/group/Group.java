package ee.taltech.iti0202.socialnetwork.group;

import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    String name;
    User owner;
    ArrayList<Message> listOfMessages = new ArrayList<>();
    int numOfMessage = -1;
    static Set<User> hashOfUsers = new HashSet<>();

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

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void addUser(User user) {
        if (user != null) {
            hashOfUsers.add(user);
        }
    }

    public Set<User> getParticipants() {
        return hashOfUsers;
    }

    public void publishMessage(Message message) {
        if (message != null) {
            if (hashOfUsers.contains(message.getAuthor())) {
                listOfMessages.add(message);
            }
        }
    }

    public List<Message> getMessages() {
        return listOfMessages;
    }
}
