package ee.taltech.iti0202.delivery;

import java.util.List;

public class Action {
    private Location location;

    public Action(Location location) {
        this.location = location;
    }

    public List<String> getDeposit() {
        return null;
    }

    public List<String> getTake() {
        return null;
    }

    public Location getGoTo() {
        return null;
    }

    public void addDeposit(String packetName) {

    }

    public void addTake(String packetName) {

    }
}
