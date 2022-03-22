package ee.taltech.iti0202.coffee.capsule;

import ee.taltech.iti0202.coffee.recipe.Recipe;

public class Capsule {
    private Recipe fillingOfCapsule;

    public Capsule(Recipe fillingOfCapsule) {
        this.fillingOfCapsule = fillingOfCapsule;
    }

    public void useCapsule() {
        this.fillingOfCapsule = null;
    }

    public boolean isEmpty() {
        return this.fillingOfCapsule == null;
    }

    public Recipe getFilling() {
        return this.fillingOfCapsule;
    }
}
