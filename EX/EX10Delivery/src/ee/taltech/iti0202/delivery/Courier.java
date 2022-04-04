package ee.taltech.iti0202.delivery;

import java.util.Optional;

public class Courier {
    private Location location;
    private Integer amountOfPackets;

    public Courier (Location location, Integer amountOfPackets) {
        this.location = location;
        this.amountOfPackets = amountOfPackets;
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
