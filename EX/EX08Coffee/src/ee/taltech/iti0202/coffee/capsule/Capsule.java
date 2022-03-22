package ee.taltech.iti0202.coffee.capsule;

import ee.taltech.iti0202.coffee.drink.Drink;

import java.util.logging.Logger;

public class Capsule {
    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private Drink fillingOfCapsule;

    public Capsule(Drink fillingOfCapsule) {
        LOGGER.info("Creating a Capsule.");

        this.fillingOfCapsule = fillingOfCapsule;
    }

    public void useCapsule() {
        this.fillingOfCapsule = null;
    }

    public boolean isEmpty() {
        return this.fillingOfCapsule == null;
    }

    public Drink getFilling() {
        return this.fillingOfCapsule;
    }
}
