package ee.taltech.iti0202.mysticorbs.orb;

import java.util.HashMap;

public class Orb {

    private final String creator;
    protected Integer energy = 0;
    private boolean absorbed = false;
    private boolean isSpaceOrb = false;
    private HashMap<String, Integer> mapOfOrbs = new HashMap<String, Integer>();

    /**
     * Create a resourceStorage.
     */
    public Orb(String creator) {
        this.creator = creator;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean returnIsSpace() {
        return this.isSpaceOrb;
    }

    /**
     * Create a resourceStorage.
     */
    public String getCreator() {
        return this.creator;
    }

    /**
     * Create a resourceStorage.
     */
    public boolean returnState() {
        return this.absorbed;
    }

    /**
     * Create a resourceStorage.
     */
    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.trim().isEmpty() && amount > 0) {
            energy += resource.length() * amount;
        }
    }

    /**
     * Create a resourceStorage.
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Create a resourceStorage.
     */
    public void changeState() {
        this.absorbed = true;
        this.energy = 0;
    }

    /**
     * Create a resourceStorage.
     */
    public String toString() {
        return "Orb by " + this.creator;
    }

}
