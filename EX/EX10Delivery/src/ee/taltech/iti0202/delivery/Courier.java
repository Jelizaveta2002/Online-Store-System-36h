package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Courier {
    private Location location;
    private Integer amountOfPackets;
    private String name;

    public Courier (String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public Optional<Location> getLocation() {
        return Optional.empty();
    }

    public void setStrategy(Strategy strategy) {

    }

    public Strategy getStrategy() {
        return null;
    }
}
