package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Courier {
    private Location location;
    private Integer timeToGo;
    private Integer amountOfPackets;
    private HashMap<String, Packet> mapOfPackets = new HashMap<>();
    private String name;
    private Strategy strategy;
    private Action currentAction;
    private Integer distanceToTarget = 0;
    private Location target;

    public Courier (String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public Optional<Location> getLocation() {
        if (location != null) {
            return Optional.of(location);
        }
        return Optional.empty();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return this.strategy;
    }

    public Integer getDistanceToTarget() {
        return this.distanceToTarget;
    }

    public void setDistanceToTarget(Integer distance) {
        this.distanceToTarget = distance;
    }

    public void minimizeDistanceToTarget() {
        this.distanceToTarget -= 1;
    }

    public HashMap<String, Packet> getMapOfPackets() {
        return mapOfPackets;
    }

    public void addPacket(Packet packet) {
        mapOfPackets.put(packet.getName(), packet);
    }

    public void removePacket(Packet packet) {
        mapOfPackets.remove(packet.getName());
    }

    public void setAction(Action action) {
        this.currentAction = action;
    }

    public Action getAction() {
        return this.currentAction;
    }

    public void removeAction() {
        this.currentAction = null;
    }

    public void setTimeToGo(Integer timeToGo) {
        this.timeToGo = timeToGo;
    }

    public void setTarget(Location target) {
        this.target = target;
    }

    public Location getTarget() {
        return this.target;
    }

    public void locationMakeNull() {
        this.location = null;
    }


    public void moveToTarget() {
        if (this.distanceToTarget != 0) {
            distanceToTarget -= 1;
        }
        else {
            this.location = this.target;
            this.target = null;
        }
    }
}