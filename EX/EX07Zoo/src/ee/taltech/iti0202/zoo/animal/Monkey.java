package ee.taltech.iti0202.zoo.animal;

public class Monkey extends Animal{

    public Monkey(String specie, Integer daysBeforeHunger) {
        super(specie, daysBeforeHunger);
        this.setVoiceMonkey();
        this.setTypeMonkey();
    }

    /**
     * Type can not be updated.
     */
    @Override
    public void setUpType(Type type) {
    }

    /**
     * If monkey is hungry, it screams "BANANA".
     */
    @Override
    public String getVoice() {
        if (!this.isAnimalHungry()) {
            return this.voice;
        }
        return "BANANA";
    }
}
