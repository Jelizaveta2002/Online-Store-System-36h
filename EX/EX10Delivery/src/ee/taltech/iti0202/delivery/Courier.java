package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.Optional;

public class Courier {
    private ee.taltech.iti0202.delivery.Location location;
    private Integer amountOfPackets;
    private ArrayList<ee.taltech.iti0202.delivery.Packet> listOfPackets = new ArrayList<>();
    private String name;
    private ee.taltech.iti0202.delivery.Strategy strategy;

    public Courier (String name, ee.taltech.iti0202.delivery.Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public Optional<ee.taltech.iti0202.delivery.Location> getLocation() {
        return Optional.empty();
    }

    public void setStrategy(ee.taltech.iti0202.delivery.Strategy strategy) {
        this.strategy = strategy;
    }

    public ee.taltech.iti0202.delivery.Strategy getStrategy() {
        return this.strategy;
    }

    public void takePacketsFromLocation() {
    }

}