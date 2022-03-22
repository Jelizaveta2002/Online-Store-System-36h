package ee.taltech.iti0202.coffee.capsule;

import ee.taltech.iti0202.coffee.drink.Drink;

public class Capsule {
    private Drink fillingOfCapsule;

    public Capsule(Drink fillingOfCapsule) {
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
