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

    public Animal(String specie, Integer daysBeforeHunger) {
        this.specie = specie;
        this.voice = "";
        this.daysBeforeHunger = daysBeforeHunger;
        this.constantDays = daysBeforeHunger;
        this.type = Type.AMPHIBIAN;
    }

    protected void setVoiceMonkey() {
        ArrayList<String> listWithVoices = new ArrayList<>();
        listWithVoices.add("uuh");
        listWithVoices.add("ääh");
        Random rand = new Random();
        this.voice = listWithVoices.get(rand.nextInt(listWithVoices.size()));
    }

    protected void setTypeMonkey() {
        this.type = Type.MAMMAL;
    }

    protected void setTypeLamb() {
        this.type = Type.MAMMAL;
    }

    protected void setVoiceLamb() {
        this.voice = "Mää";
    }


    public Animal(AnimalBuilder builder) {
        this.specie = builder.specie;
        this.voice = builder.voice;
        this.daysBeforeHunger = builder.daysBeforeHunger;
        this.constantDays = builder.daysBeforeHunger;
    }

    public static class AnimalBuilder {
        private final String specie;
        private String voice;
        Integer daysBeforeHunger;
        private Integer constantDays;

        public AnimalBuilder(String specie) {
            this.specie = specie;
        }

        public AnimalBuilder voice(String voice) {
            this.voice = voice;
            return this;
        }

        public AnimalBuilder daysBeforeHunger(Integer daysBeforeHunger) {
            this.daysBeforeHunger = daysBeforeHunger;
            return this;
        }

        public AnimalBuilder constantDays(Integer daysBeforeHunger) {
            this.constantDays = daysBeforeHunger;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal(this);
            return animal;
        }
    }

    public int getConstantDays() {
        return this.constantDays;
    }

    public String getSpecie() {
        return this.specie;
    }

    public String getVoice() {
        if (!this.isAnimalHungry()) {
            return this.voice;
        }
        return "";
    }

    public int getDaysBeforeHunger() {
        return daysBeforeHunger;
    }

    public boolean isAnimalHungry() {
        return this.daysBeforeHunger <= 0;
    }

    public void setUpType(Type type) {
        this.type = type;
    }

    public Type returnType() {
        return this.type;
    }
}
