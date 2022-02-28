package ee.taltech.iti0202.mysticorbs.orb;

import java.util.HashMap;

public class Orb {

    private final String creator;
    protected Integer energy = 0;
    private boolean absorbed = false;
    private boolean isSpaceOrb = false;
    private HashMap<String, Integer> mapOfOrbs = new HashMap<String, Integer>();

    public Orb(String creator) {
        this.creator = creator;
    }

    public boolean returnIsSpace() {
        return this.isSpaceOrb;
    }

    public String getCreator() {
        return this.creator;
    }

    public boolean returnState() {
        return this.absorbed;
    }

    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.trim().isEmpty() && amount > 0) {
            energy += resource.length() * amount;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void changeState() {
        this.absorbed = true;
        this.energy = 0;
    }

    public String toString() {
        return "Orb by " + this.creator;
    }

}
