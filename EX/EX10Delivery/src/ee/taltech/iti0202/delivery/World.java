package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class World {
    private ArrayList<Location> listOfLocations = new ArrayList<>();
    private ArrayList<Courier> listOfCouriers = new ArrayList<>();
    private HashMap<Location, ArrayList<Courier>> mapOfLocations = new HashMap<>();


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
        if (otherLocations.size() == distances.size() && otherLocations.size() == listOfLocations.size() && name != null) {
            Location newLocation = new Location(name);
            for (int i = 0; i < otherLocations.size(); i++) {
                newLocation.addDistance(otherLocations.get(i), distances.get(i));
            }
            listOfLocations.add(newLocation);
            mapOfLocations.put(newLocation, new ArrayList<>());
            return Optional.of(newLocation);
        }
        return Optional.empty();
    }

    public Optional<Courier> addCourier(String name, String to) {
        if (name != null && to != null) {
            for (Courier courier : this.listOfCouriers) {
                if (courier.getName().equals(name)) {
                    return Optional.empty();
                }
            }
            for (Location location : this.listOfLocations) {
                if (location.getName().equals(to)) {
                    Courier newCourier = new Courier(name, location);
                    this.listOfCouriers.add(newCourier);
                    mapOfLocations.get(location).add(newCourier);
                    return Optional.of(newCourier);
                }
            }
        }
        return Optional.empty();
    }

    public boolean giveStrategy(String name, Strategy strategy) {
        for (Courier courier : this.listOfCouriers) {
            if (courier.getName().equals(name)) {
                courier.setStrategy(strategy);
                return true;
            }
        }
        return false;
    }

    public void tick() {
        for (Courier courier : this.listOfCouriers) {

        }
    }
}
