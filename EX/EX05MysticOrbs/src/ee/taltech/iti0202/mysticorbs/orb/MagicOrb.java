package ee.taltech.iti0202.mysticorbs.orb;

public class MagicOrb extends Orb {
    private boolean absorbed = false;

    /**
     * Create a resourceStorage.
     */
    public MagicOrb(String creator) {
        super(creator);
    }

    /**
     * Create a resourceStorage.
     */
    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.trim().isEmpty() && amount > 0) {
            energy += resource.length() * amount * 2;
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
    @Override
    public String toString() {
        return "MagicOrb by " + super.getCreator();
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
    public void changeState() {
        this.absorbed = true;
        this.energy = 0;
    }
}
