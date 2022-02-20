package ee.taltech.iti0202.socialnetwork.user;

import ee.taltech.iti0202.socialnetwork.group.Group;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private final String name;
    private final Integer age;
    public static HashMap<User, ArrayList<Group>> groupsOfOwners = new HashMap<>();

    public User(String name) {
        this.name = name;
        this.age = null;
        if (name != null) {
            groupsOfOwners.put(this, new ArrayList<>());
        }
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        if (name != null) {
            groupsOfOwners.put(this, new ArrayList<>());
        }
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}