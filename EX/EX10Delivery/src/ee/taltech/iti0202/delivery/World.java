package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class World {
    private ArrayList<Location> listOfLocations;

    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        for (String location : otherLocations) {
            if (location.equals(name)) {
                return Optional.empty();
            }
        }
        for (Integer distance : distances) {
            if (distance == null) {
                return Optional.empty();
            }
        }
        if (otherLocations.size() == distances.size()) {
            Location newLocation = new Location(name);
            listOfLocations.add(newLocation);
            return Optional.of(newLocation);
        }
        return Optional.empty();
    }

    public Optional<Courier> addCourier(String name, String to) {
        return Optional.empty();
    }

    boolean giveStrategy(String name, Strategy strategy) {
        return false;
    }

    void tick() {
    }
}
