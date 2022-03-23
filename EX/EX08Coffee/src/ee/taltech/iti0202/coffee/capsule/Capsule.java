package ee.taltech.iti0202.coffee.capsule;

import ee.taltech.iti0202.coffee.drink.Drink;

import java.util.logging.Logger;


public class Capsule {
    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private Drink fillingOfCapsule;


    /**
     * Create a new capsule.
     */
    public Capsule(Drink fillingOfCapsule) {
        LOGGER.info("Creating a Capsule.");

        this.fillingOfCapsule = fillingOfCapsule;
    }

    /**
     * Get out filling of capsule after using it.
     */
    public void useCapsule() {
        this.fillingOfCapsule = null;
    }

    /**
     * Check if capsule is not empty.
     */
    public boolean isEmpty() {
        return this.fillingOfCapsule == null;
    }

    /**
     * Get filling of capsule.
     */
    public Drink getFilling() {
        return this.fillingOfCapsule;
    }
}
