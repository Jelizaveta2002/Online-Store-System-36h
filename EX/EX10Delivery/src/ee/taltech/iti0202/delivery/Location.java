package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

public class Location {
    private String name;
    private Integer amountOfPackets;
    private HashMap<String, Packet> mapOfPackets = new HashMap<>();
    private LinkedHashMap<String, Integer> destinationDistances = new LinkedHashMap<>();
    private HashMap<String, Location> destinationDistancesNames = new HashMap<>();
    private ArrayList<Packet> listOfPackets = new ArrayList<>();

    public Location(String name) {
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

    public void addPacket(Packet packet) {
        mapOfPackets.put(packet.getName(), packet);
    }

    public void removePacket(Packet packet) {
        mapOfPackets.remove(packet.getName());
    }

    public Optional<Packet> getPacket(String name) {
        if (mapOfPackets.containsKey(name)) {
            Packet toFind = mapOfPackets.get(name);
            mapOfPackets.remove(name);
            return Optional.of(toFind);
        }
        return Optional.empty();
    }

    public void addDistance(String location, int distance) {
        this.destinationDistances.put(location, distance);
    }

    public HashMap<String, Packet> getMapOfPackets() {
        return mapOfPackets;
    }
}
