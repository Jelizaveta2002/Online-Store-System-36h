package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class World {
    private HashMap<ee.taltech.iti0202.delivery.Location, ArrayList<ee.taltech.iti0202.delivery.Courier>> couriersOfLocations = new HashMap<>();
    private HashMap<String, ee.taltech.iti0202.delivery.Location> mapOfLocationName = new HashMap<>();
    private HashMap<String, ee.taltech.iti0202.delivery.Courier> mapOfCourierName = new HashMap<>();


    public Optional<ee.taltech.iti0202.delivery.Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        if (mapOfLocationName.containsKey(name) || otherLocations.size() != distances.size() || otherLocations.size() < mapOfLocationName.size()) {
            return Optional.empty();
        }
        for (String location : mapOfLocationName.keySet()) {
            if (!otherLocations.contains(location)) {
                return Optional.empty();
            }
        }
        int counter = otherLocations.size();
        if (otherLocations.size() != mapOfLocationName.size()) {
            counter = otherLocations.size() - mapOfLocationName.size();
        }
        Location newLocation = new Location(name);
        for (int i = 0; i < counter; i++) {
            String destination = otherLocations.get(i);
            newLocation.addDistance(destination, distances.get(i));
            mapOfLocationName.get(destination).addDistance(newLocation.getName(), distances.get(i));
        }
        mapOfLocationName.put(name, newLocation);
        couriersOfLocations.put(newLocation, new ArrayList<>());
        return Optional.of(newLocation);
    }


    public Optional<ee.taltech.iti0202.delivery.Courier> addCourier(String name, String to) {
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