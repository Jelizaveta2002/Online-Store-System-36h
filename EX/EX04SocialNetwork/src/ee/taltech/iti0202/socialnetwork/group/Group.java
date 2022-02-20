package ee.taltech.iti0202.socialnetwork.group;

import ee.taltech.iti0202.socialnetwork.SocialNetwork;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.*;

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
        changeNameOfGroup(name);
        changeNameOfGroupInHashMap(name);
        this.name = name;
    }

    public void changeNameOfGroup(String newName) {
        for (Group group : SocialNetwork.hashOfGroups) {
            if (group.getOwner().equals(this.owner) && group.getName().equals(this.name)) {
                group.name = newName;
            }
        }
    }

    public void changeNameOfGroupForPerson(String newName, ArrayList<Group> list) {
        for (Group group : list) {
            if (group.getOwner().equals(this.owner) && group.getName().equals(this.name)) {
                group.name = newName;
            }
        }
    }

    public void changeNameOfGroupInHashMap(String newName) {
        for (User key : User.groupsOfOwners.keySet()) {
            changeNameOfGroupForPerson(newName, User.groupsOfOwners.get(key));
        }
    }

    public User getOwner() {
        return owner;
    }

    public boolean checkUser(User user) {
        for (User i : hashOfUsers ) {
            if (Objects.equals(user.getAge(), i.getAge()) && user.getName().equals(i.getName())) {
                return false;
            }
        }
        return true;
    }

    public void addUser(User user) {
        if (user != null && checkUser(user) && user != this.getOwner()) {
            hashOfUsers.add(user);
            if (User.groupsOfOwners.containsKey(user)) {
                User.groupsOfOwners.get(user).add(this);
            }
            else {
                ArrayList<Group> newList = new ArrayList<>();
                newList.add(this);
                User.groupsOfOwners.put(user, newList);
            }
        }
    }

    public Set<User> getParticipants() {
        return hashOfUsers;
    }

    public void publishMessage(Message message) {
        if (message != null) {
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
