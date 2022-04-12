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
        for (String courierName : mapOfCourierName.keySet()) {
            Courier courier = mapOfCourierName.get(courierName);
            if (courier.getStrategy() != null) {
                if (courier.getLocation().isEmpty()) {
                    courier.moveToTarget();
                }
                else {
                    courier.setAction(courier.getStrategy().getAction());
                    courier.setTarget(courier.getAction().getGoTo());
                    List<String> listOfPacksToTake = courier.getAction().getTake();
                    List<String> listOfPacksToLeave = courier.getAction().getDeposit();
                    for (String packet : courier.getLocation().get().getMapOfPackets().keySet()) {
                        if (listOfPacksToTake.contains(packet)) {
                            Packet packetToTake = courier.getLocation().get().getMapOfPackets().get(packet);
                            courier.addPacket(packetToTake);
                            listOfPacksToTake.remove(packet);
                        }
                    }
                    for (String packet : courier.getMapOfPackets().keySet()) {
                        if (listOfPacksToLeave.contains(packet)) {
                            courier.getLocation().get().getMapOfPackets().put(packet, courier.getMapOfPackets().get(packet));
                            courier.getMapOfPackets().remove(packet);
                        }
                    }
                    courier.locationMakeNull();
                }
            }
        }
    }
}