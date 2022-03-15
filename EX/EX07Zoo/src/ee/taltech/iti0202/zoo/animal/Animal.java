package ee.taltech.iti0202.zoo.animal;

import java.util.ArrayList;
import java.util.Random;

public class Animal {

    private final String specie;
    public String voice;
    public Integer daysBeforeHunger;
    Type type;
    private final Integer constantDays;

    public enum Type {
        BIRD, MAMMAL, FISH, REPTILE, AMPHIBIAN
    }

    /**
     * Constructor for unusual animals.
     */
    public Animal(String specie, Integer daysBeforeHunger) {
        this.specie = specie;
        this.voice = "";
        this.daysBeforeHunger = daysBeforeHunger;
        this.constantDays = daysBeforeHunger;
        this.type = Type.AMPHIBIAN;
    }

    /**
     * Set voice of monkey (only for constructor is used).
     */
    protected void setVoiceMonkey() {
        ArrayList<String> listWithVoices = new ArrayList<>();
        listWithVoices.add("uuh");
        listWithVoices.add("ääh");
        Random rand = new Random();
        this.voice = listWithVoices.get(rand.nextInt(listWithVoices.size()));
    }

    /**
     * Set type of monkey (only for constructor is used).
     */
    protected void setTypeMonkey() {
        this.type = Type.MAMMAL;
    }

    /**
     * Set type of lamb (only for constructor is used).
     */
    protected void setTypeLamb() {
        this.type = Type.MAMMAL;
    }

    /**
     * Set voice of lamb (only for constructor is used).
     */
    protected void setVoiceLamb() {
        this.voice = "Mää";
    }


    /**
     * Constructor for usual animals.
     */
    public Animal(AnimalBuilder builder) {
        this.specie = builder.specie;
        this.voice = builder.voice;
        this.daysBeforeHunger = builder.daysBeforeHunger;
        this.constantDays = builder.daysBeforeHunger;
    }

    /**
     * Builder pattern.
     */
    public static class AnimalBuilder {
        private final String specie;
        private String voice;
        Integer daysBeforeHunger;
        private Integer constantDays;

        /**
         * Builder pattern.
         */
        public AnimalBuilder(String specie) {
            this.specie = specie;
        }

        /**
         * Builder pattern.
         */
        public AnimalBuilder voice(String voice) {
            this.voice = voice;
            return this;
        }

        /**
         * Builder pattern.
         */
        public AnimalBuilder daysBeforeHunger(Integer daysBeforeHunger) {
            this.daysBeforeHunger = daysBeforeHunger;
            return this;
        }

        /**
         * Builder pattern.
         */
        public AnimalBuilder constantDays(Integer daysBeforeHunger) {
            this.constantDays = daysBeforeHunger;
            return this;
        }

        /**
         * Builder pattern.
         */
        public Animal build() {
            Animal animal = new Animal(this);
            return animal;
        }
    }

    /**
     * Get days that animal can live without food.
     */
    public int getConstantDays() {
        return this.constantDays;
    }

    /**
     * Get specie of the animal.
     */
    public String getSpecie() {
        return this.specie;
    }

    /**
     * Get voice of the animal.
     */
    public String getVoice() {
        if (!this.isAnimalHungry()) {
            return this.voice;
        }
        return "";
    }

    /**
     * Get days before animal get hungry.
     */
    public int getDaysBeforeHunger() {
        return daysBeforeHunger;
    }

    /**
     * Check if animal is hungry.
     */
    public boolean isAnimalHungry() {
        return this.daysBeforeHunger <= 0;
    }

    /**
     * Before animal can be added to the zoo, the type must be set up.
     */
    public void setUpType(Type type) {
        this.type = type;
    }

    /**
     * Get the type of the animal.
     */
    public Type returnType() {
        return this.type;
    }
}
