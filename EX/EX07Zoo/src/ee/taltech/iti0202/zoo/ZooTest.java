package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Lamb;
import ee.taltech.iti0202.zoo.animal.Monkey;
import ee.taltech.iti0202.zoo.animal.Turtle;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import ee.taltech.iti0202.zoo.zoo.Zoo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ZooTest {

    @org.junit.jupiter.api.Test
    public void getHungryAnimals() {
        Zoo newZoo = new Zoo("zoo");
        Caretaker caretaker = new Caretaker("liza", new ArrayList<>());
        caretaker.addNewType(Animal.Type.MAMMAL);
        caretaker.addNewType(Animal.Type.AMPHIBIAN);
        Animal animal1 = new Animal.AnimalBuilder("cat").voice("miuu").daysBeforeHunger(2).build();
        Animal animal2 = new Animal.AnimalBuilder("dog").voice("gav").daysBeforeHunger(3).build();
        Turtle turtle = new Turtle("turtle", 3);
        Monkey monkey = new Monkey("monkey", 5);
        Lamb lamb = new Lamb("lamb", 3);
        animal1.setUpType(Animal.Type.MAMMAL);
        animal2.setUpType(Animal.Type.MAMMAL);
        newZoo.addAnimal(lamb);
        newZoo.addAnimal(turtle);
        newZoo.addAnimal(monkey);
        newZoo.addAnimal(animal1);
        newZoo.addAnimal(animal2);
        newZoo.addCareTaker(caretaker);
        newZoo.nextDay();
        newZoo.nextDay();
        newZoo.nextDay();
        ArrayList<Animal> listToCheck = new ArrayList<>();
        listToCheck.add(turtle);
        listToCheck.add(animal1);
        listToCheck.add(animal2);
        assertEquals(listToCheck, newZoo.getHungryAnimals());
        caretaker.feedAnimal(newZoo);
        listToCheck.clear();
        assertEquals(listToCheck, newZoo.getHungryAnimals());
    }

    @org.junit.jupiter.api.Test
    void getStateOfTheAnimals() {
        Zoo newZoo = new Zoo("zoo");
        Caretaker caretaker = new Caretaker("liza", new ArrayList<>());
        caretaker.addNewType(Animal.Type.MAMMAL);   //add new type to the caretaker
        caretaker.addNewType(Animal.Type.AMPHIBIAN);   //add new type to the caretaker
        Animal animal1 = new Animal.AnimalBuilder("cat").voice("miuu").daysBeforeHunger(2).build();
        Animal animal2 = new Animal.AnimalBuilder("dog").voice("gav").daysBeforeHunger(3).build();
        Turtle turtle = new Turtle("turtle", 3);
        Lamb lamb = new Lamb("lamb", 3);
        animal1.setUpType(Animal.Type.MAMMAL);   //set up type to the animal
        animal2.setUpType(Animal.Type.MAMMAL);   //set up type to the animal
        newZoo.addAnimal(lamb);   //add animal to the zoo
        newZoo.addAnimal(turtle);   //add animal to the zoo
        newZoo.addAnimal(animal1);   //add animal to the zoo
        newZoo.addAnimal(animal2);   //add animal to the zoo
        newZoo.addCareTaker(caretaker);   //add caretaker to the zoo
        newZoo.nextDay();   //set up a next day
        newZoo.nextDay();
        newZoo.nextDay();
        caretaker.feedAnimal(newZoo);   //caretaker feeds animals of the zoo, where he works
        String toCheck = "lamb (MAMMAL): Mää\n" +
                "turtle (AMPHIBIAN): \n" +
                "cat (MAMMAL): miuu\n" +
                "dog (MAMMAL): gav\n";
        assertEquals(toCheck, newZoo.getStateOfTheAnimals());
    }

    @org.junit.jupiter.api.Test
    void profitOfCaretakers() {
        Zoo newZoo = new Zoo("zoo");
        Caretaker caretaker = new Caretaker("liza", new ArrayList<>());
        Caretaker caretaker2 = new Caretaker("anna", new ArrayList<>());
        caretaker.addNewType(Animal.Type.MAMMAL);
        caretaker.addNewType(Animal.Type.AMPHIBIAN);
        caretaker2.addNewType(Animal.Type.MAMMAL);
        caretaker2.addNewType(Animal.Type.AMPHIBIAN);
        caretaker2.addNewType(Animal.Type.BIRD);
        caretaker2.addNewType(Animal.Type.FISH);
        Animal animal1 = new Animal.AnimalBuilder("cat").voice("miuu").daysBeforeHunger(2).build();
        Animal animal2 = new Animal.AnimalBuilder("birdy").voice("iii").daysBeforeHunger(3).build();
        Animal animal3 = new Animal.AnimalBuilder("sashimi").voice("...").daysBeforeHunger(3).build();
        animal1.setUpType(Animal.Type.MAMMAL);
        animal2.setUpType(Animal.Type.BIRD);
        animal3.setUpType(Animal.Type.FISH);
        newZoo.addAnimal(animal1);
        newZoo.addAnimal(animal2);
        newZoo.addAnimal(animal3);
        newZoo.addCareTaker(caretaker);
        newZoo.addCareTaker(caretaker2);
        ArrayList<Caretaker> listToCheck = new ArrayList<>();
        listToCheck.add(caretaker2);
        assertEquals(listToCheck, newZoo.profitOfCaretakers());
    }
}
