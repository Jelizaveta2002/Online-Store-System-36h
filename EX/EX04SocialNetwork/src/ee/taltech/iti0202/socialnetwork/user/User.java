package ee.taltech.iti0202.socialnetwork.user;

import ee.taltech.iti0202.socialnetwork.group.Group;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private final String name;
    private final Integer age;
    private final HashMap<User, ArrayList<Group>> groupsOfOwners = new HashMap<>();


    /**
     * @param name the name of the stock.
     */
    public User(String name) {
        this.name = name;
        this.age = null;
        if (name != null) {
            groupsOfOwners.put(this, new ArrayList<>());
        }
    }

    /**
     * Create a new stock with the given name and the max capacity for the products.
     *
     * @param name the name of the stock.
     * @param age max amount of products allowed in the stock.
     */
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        if (name != null) {
            groupsOfOwners.put(this, new ArrayList<>());
        }
    }

    public HashMap<User, ArrayList<Group>> getGroupsOfOwners() {
        return groupsOfOwners;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
