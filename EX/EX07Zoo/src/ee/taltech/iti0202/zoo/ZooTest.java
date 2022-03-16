package ee.taltech.iti0202.zoo;

import ee.taltech.iti0202.zoo.animal.Animal;
import ee.taltech.iti0202.zoo.animal.Lamb;
import ee.taltech.iti0202.zoo.animal.Monkey;
import ee.taltech.iti0202.zoo.animal.Turtle;
import ee.taltech.iti0202.zoo.caretaker.Caretaker;
import ee.taltech.iti0202.zoo.zoo.Zoo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ZooTest {

    @org.junit.jupiter.api.Test
    public void getHungryAnimals() {
        Zoo newZoo = new Zoo("zoo");
        Zoo newZaa = new Zoo("zaa");
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
        newZaa.addAnimal(animal1); //we try to add an animal in the zoo, to another zoo
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
        assertTrue(lamb.animalInTheZoo);
        ArrayList<Animal> list1 = new ArrayList();
        assertEquals(list1, newZaa.getListOfAnimals()); //returns empty list because animal1 is already in the newZoo
                                                        //and can not be added to another zoo
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
        turtle.getDaysBeforeHunger();
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
        System.out.println(newZoo.getListOfAnimals());
        System.out.println(newZoo.getCaretakers());
        System.out.println(newZoo.getDays());
        String toCheck1 = """
                lamb (MAMMAL): Mää
                turtle (AMPHIBIAN):\s
                cat (MAMMAL):\s
                dog (MAMMAL):\s
                """;
        assertEquals(toCheck1, newZoo.getStateOfTheAnimals()); //2 animals are hungry, so they make no voice
                                                            //turtle is also hungry, but it does not have voice at all
                                                            //lamb is not hungry,because it is never hungry
        caretaker.feedAnimal(newZoo);   //caretaker feeds animals of the zoo, where he works
        String toCheck = """
                lamb (MAMMAL): Mää
                turtle (AMPHIBIAN):\s
                cat (MAMMAL): miuu
                dog (MAMMAL): gav
                """;
        assertEquals(toCheck, newZoo.getStateOfTheAnimals()); //all the animals are fed, so they are not hungry
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
        assertEquals(listToCheck, newZoo.getTheBestCaretakers());  //only caretaker2 is in list, cause it has more types
    }

    @org.junit.jupiter.api.Test
    void canFeedOnlyHungryAnimals() {
        Zoo newZoo = new Zoo("zoo");
        assertEquals("zoo", newZoo.getName());
        Caretaker caretaker = new Caretaker("liza", new ArrayList<>());
        caretaker.addNewType(Animal.Type.MAMMAL);
        caretaker.addNewType(Animal.Type.FISH);
        caretaker.addNewType(Animal.Type.BIRD);
        newZoo.addCareTaker(caretaker);
        Animal animal1 = new Animal.AnimalBuilder("cat").voice("miuu").daysBeforeHunger(2).build();
        Animal animal2 = new Animal.AnimalBuilder("birdy").voice("iii").daysBeforeHunger(5).build();
        Animal animal3 = new Animal.AnimalBuilder("sashimi").voice("...").daysBeforeHunger(3).build();
        animal1.setUpType(Animal.Type.MAMMAL);
        animal2.setUpType(Animal.Type.BIRD);
        animal3.setUpType(Animal.Type.FISH);
        newZoo.addAnimal(animal1);
        newZoo.addAnimal(animal2);
        newZoo.addAnimal(animal3);
        ArrayList<Animal.Type> listOfTypes = new ArrayList<>();
        listOfTypes.add(Animal.Type.MAMMAL);
        listOfTypes.add(Animal.Type.BIRD);
        listOfTypes.add(Animal.Type.FISH);
        assertEquals(listOfTypes, newZoo.getTypesOfAnimalsInTheZoo());
        ArrayList<Animal> listToCheck = new ArrayList<>();
        assertEquals(listToCheck, caretaker.feedAnimal(newZoo)); //list is empty because animals are not hungry yet
        newZoo.nextDay();
        newZoo.nextDay();
        newZoo.nextDay();
        listToCheck.add(animal1);
        listToCheck.add(animal3);
        assertEquals(listToCheck, caretaker.feedAnimal(newZoo)); //only two animals can be fed, cause one is not hungry
    }
}
