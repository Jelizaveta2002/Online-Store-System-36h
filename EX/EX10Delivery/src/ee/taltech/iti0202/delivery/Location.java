package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Location {
    private String name;
    private Integer amountOfPackets;
    private ArrayList<Packet> listOfPackets = new ArrayList<>();
    private HashMap<String, Integer> destinationDistances = new HashMap<>();

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
        for (String destination : destinationDistances.keySet()) {
            if (name.equals(destination)) {
                return destinationDistances.get(destination);
            }
        }
        return Integer.MAX_VALUE;
    }

    public void addPacket(Packet packet) {
        if (packet != null) {
            this.listOfPackets.add(packet);
        }
    }

    public Optional<Packet> getPacket(String name) {
        for (Packet packet : this.listOfPackets) {
            if (packet.getName().equals(name)) {
                this.listOfPackets.remove(packet);
                return Optional.of(packet);
            }
        }
        return Optional.empty();
    }

    public void addDistance(String location, int distance) {
        this.destinationDistances.put(location, distance);
    }

    public ArrayList<Packet> getListOfPackets() {
        return this.listOfPackets;
    }
}
