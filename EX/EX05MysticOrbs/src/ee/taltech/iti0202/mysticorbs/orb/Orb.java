package ee.taltech.iti0202.mysticorbs.orb;

import java.util.HashMap;

public class Orb {

    private final String creator;
    private Integer energy = 0;
    private HashMap<String, Integer> mapOfOrbs = new HashMap<String, Integer>();

    public Orb(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return this.creator;
    }

    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.trim().isEmpty() && amount != 0) {
            energy += resource.length() * amount;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public String toString() {
        return "Orb by " + this.creator;
    }
}
