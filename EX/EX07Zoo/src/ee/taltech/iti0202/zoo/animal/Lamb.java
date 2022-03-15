package ee.taltech.iti0202.zoo.animal;

public class Lamb extends Animal {

    /**
     * Create a new lamb.
     */
    public Lamb(String specie, Integer daysBeforeHunger) {
        super(specie, daysBeforeHunger);
        this.setTypeLamb();
        this.setVoiceLamb();
    }

    /**
     * Lamb is never getting hungry.
     */
    @Override
    public boolean isAnimalHungry() {
        return false;
    }

    /**
     * Type can not be updated.
     */
    @Override
    public void setUpType(Type type) {
    }
}
