package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class World {
    private HashMap<Location, ArrayList<Courier>> couriersOfLocations = new HashMap<>();
    private HashMap<String, Location> mapOfLocationName = new HashMap<>();
    private HashMap<String, Courier> mapOfCourierName = new HashMap<>();


    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        if (mapOfLocationName.containsKey(name) || otherLocations.size() != distances.size() || otherLocations.size() != mapOfLocationName.size()) {
            return Optional.empty();
        }
        Location newLocation = new Location(name);
        for (int i = 0; i < otherLocations.size(); i++) {
            String destination = otherLocations.get(i);
            newLocation.addDistance(destination, distances.get(i));
            mapOfLocationName.get(destination).addDistance(newLocation.getName(), distances.get(i));
        }
        mapOfLocationName.put(name, newLocation);
        couriersOfLocations.put(newLocation, new ArrayList<>());
        return Optional.of(newLocation);
    }


    public Optional<Courier> addCourier(String name, String to) {
        if (name != null && to != null && !mapOfCourierName.containsKey(name) && mapOfLocationName.containsKey(to)) {
            Courier newCourier = new Courier(name, mapOfLocationName.get(to));
            mapOfCourierName.put(name, newCourier);
            couriersOfLocations.get(mapOfLocationName.get(to)).add(newCourier);
            return Optional.of(newCourier);
        }
        return Optional.empty();
    }

    public boolean giveStrategy(String name, Strategy strategy) {
        if (mapOfCourierName.containsKey(name) && strategy != null) {
            mapOfCourierName.get(name).setStrategy(strategy);
            return true;
        }
        return false;
    }

    public void tick() {

    }
}