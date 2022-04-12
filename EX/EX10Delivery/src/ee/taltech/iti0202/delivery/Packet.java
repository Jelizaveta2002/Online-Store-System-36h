package ee.taltech.iti0202.delivery;

public class Packet {
    private String name;
    private ee.taltech.iti0202.delivery.Location target;

    public Packet(String name, ee.taltech.iti0202.delivery.Location target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return this.name;
    }

    public ee.taltech.iti0202.delivery.Location getTarget() {
        return this.target;
    }
}
