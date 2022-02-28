package ee.taltech.iti0202.mysticorbs.orb;

import java.util.HashMap;

public class SpaceOrb extends Orb {
    private Integer energy = 100;
    private boolean absorbed = false;
    private HashMap<String, Integer> mapOfOrbs = new HashMap<String, Integer>();

    public SpaceOrb(String creator) {
        super(creator);
    }

    public void charge(String resource, int amount) {}

    public String toString() {
        return "SpaceOrb by " + super.getCreator();
    }

    public int getEnergy() {
        return this.energy;
    }

    public boolean returnState() {
        return this.absorbed;
    }

    public boolean absorb(Orb orb) {
        if (!orb.returnState() && orb.getEnergy() < this.getEnergy()) {
            this.energy += orb.getEnergy();
            orb.changeState();
            return true;
        }
        return false;
    }
}
