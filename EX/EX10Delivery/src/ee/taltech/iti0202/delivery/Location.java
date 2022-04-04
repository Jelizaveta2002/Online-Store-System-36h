package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Location {
    private String name;
    private Integer amountOfPackets;

    public Location (String name , Integer amountOfPackets) {
        this.name = name;
        this.amountOfPackets = amountOfPackets;
    }

    public String getNme() {
        return this.name;
    }

    public Integer getDistanceTo(String name) {
        return null;
    }

    public void addPacket(Packet packet) {

    }

    public Optional<Packet> getPacket(String name) {
        return Optional.empty();
    }

    public void addDistance(String location, int distance) {

    }
}
