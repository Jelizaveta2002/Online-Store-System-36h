package ee.taltech.iti0202.delivery;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

public class World {
    private HashMap<Location, ArrayList<Courier>> couriersOfLocations = new HashMap<>();
    private HashMap<String, Location> mapOfLocationName = new HashMap<>();
    private HashMap<String, Courier> mapOfCourierName = new HashMap<>();


    public Optional<Location> addLocation(String name, List<String> otherLocations, List<Integer> distances) {
        Set<String> otherLocationSet = new HashSet<>(otherLocations);
        if (mapOfLocationName.containsKey(name) || otherLocations.size() != distances.size()
                || !otherLocationSet.containsAll(mapOfLocationName.keySet())) {
            return Optional.empty();
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
        for (String courierName : mapOfCourierName.keySet()) {
            Courier courier = mapOfCourierName.get(courierName);
            if (courier.getLocation().isEmpty()) {
                courier.moveToTarget();
            } else {
                Action actionToTake = courier.getStrategy().getAction();
                courier.setAction(actionToTake);
                courier.setTarget(courier.getAction().getGoTo());
                for (String packet : courier.getAction().getTake()) {
                    if (courier.getLocation().get().getMapOfPackets().containsKey(packet)) {
                        courier.addPacket(courier.getLocation().get().getMapOfPackets().get(packet));
                        courier.getLocation().get().getMapOfPackets().remove(packet);
                    }
                }
                for (String packet : courier.getAction().getDeposit()) {
                    if (courier.getMapOfPackets().containsKey(packet)) {
                        courier.getLocation().get().addPacket(courier.getMapOfPackets().get(packet));
                        courier.getMapOfPackets().remove(packet);
                    }
                }
                courier.locationMakeNull();
            }
        }
    }
}
