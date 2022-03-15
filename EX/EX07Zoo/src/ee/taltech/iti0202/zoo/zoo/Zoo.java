package ee.taltech.iti0202.zoo.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;

import java.util.*;

public class Zoo {
    private final ArrayList<Animal> listOfAnimals = new ArrayList<>();
    private final ArrayList<Caretaker> listOfCaretakers = new ArrayList<>();
    private final ArrayList<Animal.Type> typesOfAnimalsInTheZoo = new ArrayList<>();
    private int nextDay = 1;
    private final String name;

    public Zoo(String name) {
        this.name = name;
    }

    /**
     * Get name of the zoo.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get all types of animals in the zoo.
     */
    public ArrayList<Animal.Type> getTypesOfAnimalsInTheZoo() {
        return this.typesOfAnimalsInTheZoo;
    }

    /**
     * Add a new caretaker to the zoo if it is possible.
     */
    public void addCareTaker(Caretaker caretaker) {
        if (caretaker != null) {
            if (caretaker.getName() != null) {
                if (!caretaker.getName().trim().isEmpty()) {
                    for (Caretaker caretaker1 : this.listOfCaretakers) {
                        if (caretaker.getName().equals(caretaker1.getName())) {
                            return;
                        }
                    }
                    listOfCaretakers.add(caretaker);
                    caretaker.setZoo(this);
                }
            }
        }
    }

    /**
     * Get the list of the all caretakers.
     */
    public ArrayList<Caretaker> getCaretakers() {
        return listOfCaretakers;
    }

    /**
     * Check if animal can be added to the zoo.
     */
    public boolean checkIfAnimalCanBeAdded(Animal animal) {
        if (animal.getSpecie() != null && animal.getVoice() != null && animal.returnType() != null && animal.getConstantDays() != 0) {
            for (Animal animal1 : this.listOfAnimals) {
                if (animal.getSpecie().equals(animal1.getSpecie()) && animal.getVoice().equals(animal1.getVoice()) && animal.returnType().equals(animal1.returnType()) && animal.getConstantDays() == animal1.getConstantDays()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Add a new animal to the zoo, if it is possible.
     */
    public void addAnimal(Animal animal) {
        if (animal != null) {
            if (checkIfAnimalCanBeAdded(animal)) {
                this.listOfAnimals.add(animal);
                addNewType(animal);
            }
        }
    }

    /**
     * Add a new type of the animal to the zoo.
     */
    public void addNewType(Animal animal) {
        for (Animal.Type type : this.typesOfAnimalsInTheZoo) {
            if (type.equals(animal.returnType())) {
                return;
            }
        }
        this.typesOfAnimalsInTheZoo.add(animal.returnType());
    }

    /**
     * Get all the animals of the zoo.
     */
    public ArrayList<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    /**
     * Button to create a next day.
     */
    public void nextDay() {
        nextDay += 1;
        for (Animal animal : listOfAnimals) {
            animal.daysBeforeHunger -= 1;
        }
    }

    /**
     * Get a current day.
     */
    public int getDays() {
        return nextDay;
    }

    /**
     * Get all the animals of the zoo, that are hungry now.
     */
    public ArrayList<Animal> getHungryAnimals() {
        ArrayList<Animal> listOfHungryAnimals = new ArrayList<>();
        for (Animal animal : this.listOfAnimals) {
            if (animal.isAnimalHungry()) {
                listOfHungryAnimals.add(animal);
            }
        }
        return listOfHungryAnimals;
    }

    /**
     * Get the current state of all animals in the zoo:
     * Example:
     * Muki (MAMMAL): "auh!"
     * Abu (MAMMAL): "BANANA"
     */
    public String getStateOfTheAnimals() {
        StringBuilder newBuilder = new StringBuilder();
        for (Animal animal : this.getListOfAnimals()) {
            String str = animal.getSpecie() + " " + "(" + animal.returnType() + ")" + ":" + " " + animal.getVoice() + "\n";
            newBuilder.append(str);
        }
        return newBuilder.toString();
    }

    /**
     * Get a caretaker who is able to feed the most animals of the zoo.
     */
    public ArrayList<Caretaker> profitOfCaretakers() {
        HashMap<Caretaker, Integer> mapWithProfit = new HashMap<>();
        for (Caretaker caretaker : this.listOfCaretakers) {
            int value = 0;
            for (Animal.Type type : caretaker.getTypeOfAnimals()) {
                if (this.typesOfAnimalsInTheZoo.contains(type)) {
                    value += 1;
                }
            }
            mapWithProfit.put(caretaker, value);
        }
        return findTheBestCaretakers(mapWithProfit);
    }

    /**
     * Method that helps to find the best caretaker.
     */
    public ArrayList<Caretaker> findTheBestCaretakers(HashMap<Caretaker, Integer> mapOfCaretakers) {
        int maxValueInMap=(Collections.max(mapOfCaretakers.values()));
        ArrayList<Caretaker> listOfBestCaretakers = new ArrayList<>();
        if (maxValueInMap != 0) {
            for (Map.Entry<Caretaker, Integer> entry : mapOfCaretakers.entrySet()) {  // Itrate through hashmap
                if (entry.getValue() == maxValueInMap) {
                    listOfBestCaretakers.add(entry.getKey());
                }
            }
        }
        return listOfBestCaretakers;
    }
}
