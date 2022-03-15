package ee.taltech.iti0202.zoo.caretaker;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.zoo.Zoo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class Caretaker {
    private final String name;
    private final ArrayList<Animal.Type> listOfTypes;
    private Zoo zoo;

    /**
     * Create a new caretaker.
     */
    public Caretaker(String name, ArrayList<Animal.Type> listOfTypes) {
        this.name = name;
        this.listOfTypes = listOfTypes;
        this.zoo = null;
    }

    /**
     * Get name of the caretaker.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set a zoo, where the caretaker works (this method can be done only, when zoo adds a new caretaker).
     */
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    /**
     * Get zoo where the caretaker works.
     */
    public Zoo getZoo() {
        return this.zoo;
    }

    /**
     * Get the list with types of animals that can be fed by one caretaker.
     */
    public ArrayList<Animal.Type> getTypeOfAnimals() {
        return this.listOfTypes;
    }

    /**
     * Add a new type for the caretaker.
     */
    public void addNewType(Animal.Type type) {
        if (!this.listOfTypes.contains(type)) {
            this.listOfTypes.add(type);
        }
    }

    /**
     * Method that takes the zoo, check which animals of the zoo can be
     * fed by this caretaker and then feed those animals.
     */
    public ArrayList<Animal> feedAnimal(Zoo zoo) {
        ArrayList<Animal> animalsCanFeed = new ArrayList<>();
        ArrayList<Animal> animalsToFeed = new ArrayList<>();
        if (this.zoo != null) {
            if (this.zoo.getName().equals(zoo.getName())) {
                for (Animal animal : zoo.getListOfAnimals()) {
                    if (animal.returnType() != null) {
                        if (this.listOfTypes.contains(animal.returnType())) {
                            animalsCanFeed.add(animal);
                        }
                    }
                }
                if (!animalsCanFeed.isEmpty()) {
                    for (Animal animal : animalsCanFeed) {
                        if (animal.isAnimalHungry()) {
                            animal.daysBeforeHunger = animal.getConstantDays();
                            animalsToFeed.add(animal);
                        }
                    }
                }
            }
            return animalsToFeed;
        }
        return animalsToFeed;
    }
}
