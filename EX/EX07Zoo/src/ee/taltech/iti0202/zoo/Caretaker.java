package ee.taltech.iti0202.zoo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class Caretaker {
    private final String name;
    private final ArrayList<Animal.Type> listOfTypes;
    private Zoo zoo;

    public Caretaker(String name, ArrayList<Animal.Type> listOfTypes) {
        this.name = name;
        this.listOfTypes = listOfTypes;
        this.zoo = null;
    }
    public String getName() {
        return this.name;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Zoo getZoo() {
        return this.zoo;
    }

    public ArrayList<Animal.Type> getTypeOfAnimals() {
        return this.listOfTypes;
    }

    public void addNewType(Animal.Type type) {
        if (!this.listOfTypes.contains(type)) {
            this.listOfTypes.add(type);
        }
    }

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
