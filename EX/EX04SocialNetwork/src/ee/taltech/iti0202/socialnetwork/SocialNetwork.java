package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.HashSet;
import java.util.Set;

public class SocialNetwork {
    static Set<Group> hashOfGroups = new HashSet<>();
    public void registerGroup(Group group) {
        if (group != null) {
            hashOfGroups.add(group);
        }
    }

    public Set<Group> getGroups() {
        return hashOfGroups;
    }

    public Feed getFeedForUser(User user) {
        return null;
    }
}
