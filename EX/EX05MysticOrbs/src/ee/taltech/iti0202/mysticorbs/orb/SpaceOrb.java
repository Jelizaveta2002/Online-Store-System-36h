package ee.taltech.iti0202.mysticorbs.orb;

import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.HashMap;

public class SpaceOrb extends Orb {
    private boolean absorbed = false;

    /**
     * Create a resourceStorage.
     */
    public SpaceOrb(String creator) {
        super(creator);
        energy = 100;
    }

    /**
     * Create a resourceStorage.
     */
    public void changeState() {
        absorbed = true;
        energy = 0;
    }

    /**
     * Create a resourceStorage.
     */
    public void charge(String resource, int amount) {}

    /**
     * Create a resourceStorage.
     */
    public String toString() {
        return "SpaceOrb by " + super.getCreator();
    }

    /**
     * Create a resourceStorage.
     */
    public int getEnergy() {
        return this.energy;
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
    public boolean absorb(Orb orb) {
        if (!orb.returnState() && orb.getEnergy() < this.getEnergy()) {
            this.energy += orb.getEnergy();
            orb.changeState();
            return true;
        }
        return false;
    }

}
