package ee.taltech.iti0202.zoo;

public class Lamb extends Animal {

    public Lamb(String specie, Integer daysBeforeHunger) {
        super(specie, daysBeforeHunger);
        this.setTypeLamb();
        this.setVoiceLamb();
    }

    public boolean isAnimalHungry() {
        return false;
    }

    public void setUpType(Type type) {
    }
}
