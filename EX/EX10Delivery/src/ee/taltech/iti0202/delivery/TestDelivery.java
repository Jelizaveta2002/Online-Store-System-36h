//package ee.taltech.iti0202.delivery;
//
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//
//class TestDelivery {
//
//    @Test
//    void waterBankTest() {
//        World world = new World();
//        Location start = world.addLocation("start", new ArrayList<>(), new ArrayList<>()).get();
//        Location end = world.addLocation("end", Collections.singletonList("start"), Collections.singletonList(3)).get();
//        Courier courier = world.addCourier("Courier", "start").get();
//
//        LinkedList<Action> actions = new LinkedList<>();
//        actions.add(new Action(end));
//        actions.add(new Action(start));
//        DummyStrategy dummyStrategy = new DummyStrategy(actions);
//        world.giveStrategy("Courier", dummyStrategy);
//
//        Optional<Location> location1 = courier.getLocation();
//        assertThat(location1.isPresent(), is(true));
//        assertThat(location1.get(), is(start));
//        world.tick();
//        Optional<Location> location2 = courier.getLocation();
//        assertThat(location2.isEmpty(), is(true));
//        world.tick();
//        Optional<Location> location3 = courier.getLocation();
//        assertThat(location3.isEmpty(), is(true));
//        world.tick();
//        Optional<Location> location4 = courier.getLocation();
//        assertThat(location4.isPresent(), is(true));
//        assertThat(location4.get(), is(end));
//
//    }
//}
//
