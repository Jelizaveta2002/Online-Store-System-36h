package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SocialNetworkTest {

    public static final int TWOZERO = 20;
    public static final int ONEEIGHT = 18;
    public static final int TEN = 10;

    @Test
    void userGetters() {
        User user1 = new User("user1");
        User user2 = new User("user2", TEN);
        User user3 = new User("user2", TWOZERO);
        String checkName = "user2";
        assertEquals(checkName, user2.getName());
    }

    @Test
    void userGetters2() {
        User user1 = new User("user1");
        User user2 = new User("user2", TEN);
        User user3 = new User("user2", TWOZERO);
        Integer checkAge = TEN;
        assertEquals(checkAge, user2.getAge());
    }

    @Test
    void userGetters3() {
        User user1 = new User("user1");
        User user2 = new User("user2", TEN);
        User user3 = new User("user2", TWOZERO);
        Integer checkAge = null;
        assertEquals(checkAge, user1.getAge());
    }

    @Test
    void messageGetter() {
        User user1 = new User("user1");
        Group group2 = new Group("group1", user1);
        Message message1 = new Message("title1", "content1", user1);
        String title = "title1";
        assertEquals(title, message1.getTitle());
    }

    @Test
    void messageGetter2() {
        User user1 = new User("user1");
        Group group2 = new Group("group1", user1);
        Message message1 = new Message("title1", "content1", user1);
        String message = "content1";
        assertEquals(message, message1.getMessage());
    }

    @Test
    void messageGetter3() {
        User user1 = new User("user1");
        Group group2 = new Group("group1", user1);
        Message message1 = new Message("title1", "content1", user1);
        User user = user1;
        assertEquals(user, message1.getAuthor());
    }

    @Test
    void groupGetter() {
        User user1 = new User("user1");
        Group group2 = new Group("group1", user1);
        Message message1 = new Message("title1", "content1", user1);
        group2.setName("group3");
        String name = "group3";
        assertEquals(name, group2.getName());
    }

    @Test
    void groupGetter2() {
        User user1 = new User("user1");
        Group group2 = new Group("group1", user1);
        Message message1 = new Message("title1", "content1", user1);
        User name = user1;
        assertEquals(name, group2.getOwner());
    }

    @Test
    void getParticipants() {
        User user1 = new User("user1");
        User user2 = new User("user2", TEN);
        User user3 = new User("user2", TWOZERO);
        Group group2 = new Group("group1", user1);
        group2.addUser(user2);
        group2.addUser(user3);
        Set<User> set = new HashSet<User>();
        set.add(user1);
        set.add(user2);
        set.add(user3);
        assertEquals(set, group2.getParticipants());
    }

    @Test
    void getMessages() {
        User user1 = new User("user1");
        User user2 = new User("user2", TEN);
        User user3 = new User("user2", TWOZERO);
        Group group2 = new Group("group1", user1);
        group2.addUser(user2);
        Message message1 = new Message("title1", "content1", user1);
        Message message2 = new Message("title2", "content2", user2);
        Message message3 = new Message("title3", "content3", user3);
        group2.publishMessage(message1);
        group2.publishMessage(message2);
        group2.publishMessage(message3);
        ArrayList<Message> checkList = new ArrayList<>(Arrays.asList(message1, message2));
        assertEquals(checkList, group2.getMessages());
    }

    @Test
    void getGroups() {
        SocialNetwork socialNetwork = new SocialNetwork();
        User user1 = new User("user1");
        User user2 = new User("user2", TEN);
        User user3 = new User("user2", TWOZERO);
        Group group2 = new Group("group1", user1);
        Group group3 = new Group("group2", user2);
        socialNetwork.registerGroup(group2);
        socialNetwork.registerGroup(group3);
        Set<Group> set = new HashSet<Group>();
        set.add(group2);
        set.add(group3);
        assertEquals(set, socialNetwork.getGroups());
    }

    @Test
    void getFeedForUser() {
        SocialNetwork socialNetwork = new SocialNetwork();
        User user1 = new User("user1", ONEEIGHT);
        User user2 = new User("user2", TEN);
        Group group = new Group("group1", user1);
        Message message = new Message("title", "message", user1);
        socialNetwork.registerGroup(group);
        group.addUser(user2);
        group.publishMessage(message);
        Feed feed1 = socialNetwork.getFeedForUser(user2);
        Feed feed2 = new Feed(user2, Set.of(message));
        assertEquals(feed1.getUser(), feed1.getUser());
        assertEquals(feed2.getMessages(), feed2.getMessages());
    }

    @Test
    void getGroups2() {
        SocialNetwork socialNetwork = new SocialNetwork();
        User user2 = new User("user2", TEN);
        Group group = new Group("group1", user2);
        socialNetwork.registerGroup(group);
        assertEquals(socialNetwork.getGroups(), Set.of(group));
    }
}
