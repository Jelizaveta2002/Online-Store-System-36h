package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SocialNetwork {
    public static Set<Group> hashOfGroups = new HashSet<>();
    public void registerGroup(Group group) {
        if (group != null) {
            hashOfGroups.add(group);
        }
    }

    public Set<Group> getGroups() {
        return hashOfGroups;
    }

    public Feed getFeedForUser(User user) {
        Set<Message> hashOfAllGroups = new HashSet<>();
        for (Group group : User.groupsOfOwners.get(user)) {
            if (!group.getMessages().isEmpty()) {
                hashOfAllGroups.addAll(group.getMessages());
            }
        }
        return new Feed(user, hashOfAllGroups);
    }
}
