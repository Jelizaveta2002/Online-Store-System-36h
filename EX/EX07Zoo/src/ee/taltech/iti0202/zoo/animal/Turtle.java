package ee.taltech.iti0202.zoo.animal;

public class Turtle extends Animal {

    /**
     * Create a turtle.
     */
    public Turtle(String specie, Integer daysBeforeHunger) {
        super(specie, daysBeforeHunger);
    }

    /**
     * Type can not be updated.
     */
    @Override
    public void setUpType(Type type) {
    }
}
