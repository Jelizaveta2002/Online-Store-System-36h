package ee.taltech.iti0202.delivery;

import java.util.ArrayList;
import java.util.List;

public class Action {
    private ee.taltech.iti0202.delivery.Location location;
    private ArrayList<String> take = new ArrayList<>();
    private ArrayList<String> deposit = new ArrayList<>();

    public Action(Location location) {
        this.location = location;
    }

    public List<String> getDeposit() {
        return this.deposit;
    }

    public List<String> getTake() {
        return this.take;
    }

    public Location getGoTo() {
        return this.location;
    }

    public void addDeposit(String packetName) {
        deposit.add(packetName);
    }

    public void addTake(String packetName) {
        take.add(packetName);
    }
}
