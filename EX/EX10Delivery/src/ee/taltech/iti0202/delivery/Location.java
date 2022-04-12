package ee.taltech.iti0202.delivery;

import java.util.HashMap;
import java.util.Optional;

public class Location {
    private String name;
    private Integer amountOfPackets;
    private HashMap<String, ee.taltech.iti0202.delivery.Packet> mapOfPackets = new HashMap<>();
    private HashMap<String, Integer> destinationDistances = new HashMap<>();
    private HashMap<String, Location> destinationDistancesNames = new HashMap<>();

    public Location (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<String, Integer> getDestinationDistances() {
        return this.destinationDistances;
    }

    public Integer getDistanceTo(String name) {
        if (destinationDistances.containsKey(name)) {
            return destinationDistances.get(name);
        }
        return Integer.MAX_VALUE;
    }

    public void addPacket(ee.taltech.iti0202.delivery.Packet packet) {
        mapOfPackets.put(packet.getName(), packet);
    }

    public Optional<Packet> getPacket(String name) {
        if (mapOfPackets.containsKey(name)) {
            ee.taltech.iti0202.delivery.Packet toFind = mapOfPackets.get(name);
            mapOfPackets.remove(name);
            return Optional.of(toFind);
        }
        return Optional.empty();
    }

    public void addDistance(String location, int distance) {
        this.destinationDistances.put(location, distance);
    }

    public HashMap<String, ee.taltech.iti0202.delivery.Packet> getMapOfPackets() {
        return mapOfPackets;
    }
}