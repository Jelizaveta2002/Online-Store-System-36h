package ee.taltech.iti0202.coffee.example;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.kitchen.Kitchen;
import ee.taltech.iti0202.coffee.machine.AutomaticMachine;
import ee.taltech.iti0202.coffee.machine.CapsuleMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.storage.Storage;
import ee.taltech.iti0202.coffee.water.WaterBank;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Kitchen newKitchen = new Kitchen("kitchen"); //create a kitchen
        Storage storage = new Storage(); //create a storage (firstly it is empty)
        storage.fillStorage(); //fill our storage
        WaterBank water = new WaterBank("bank"); //create bank with water
        water.fillWaterBank(); //fill bank with water
        CoffeeMachine machine = new CoffeeMachine.CoffeeMachineBuilder("name").capacityOfRubbishBin(3).build();
        //create machine
        AutomaticMachine machine1 =
                new AutomaticMachine(new CoffeeMachine.CoffeeMachineBuilder("name1").capacityOfRubbishBin(15));
        //create machine
        CapsuleMachine machine2 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2"));
        //create machine
        newKitchen.addNewMachine(machine1); //add new machine into the kitchen
        machine.setWaterBank(water); //set water bank
        machine1.setWaterBank(water); //set water bank
        machine2.setWaterBank(water); //set water bank
        machine.setStorage(storage); //set storage of products
        machine1.setStorage(storage); //set storage of products
        machine2.setStorage(storage); //set storage of products
        System.out.println(storage.getStateOfStorage()); //get the state of storage(amount of products)
        System.out.println(newKitchen.getListOfMachines());  //list of all machines in the kitchen
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO)); //make cappuccino using ordinary machine
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO)); //make espresso using ordinary machine
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO));
        //make one more drink, but get null because not enough products
        storage.fillStorage(); //fill the storage
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO)); //make espresso using ordinary machine
        System.out.println(machine.getListOfDrinks()); //get all the drinks done by this machine (3 in total)
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.ESPRESSO)); //can not make drink, cause bin is full
        machine.cleanBin(); //clean the bin of the machine
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.ESPRESSO));
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 0
        System.out.println(machine.isBroken()); //machine is broken == true, because water bank should always be full
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO)); //null, because machine is broken
        water.fillWaterBank(); //fill bank of water
        System.out.println(machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO)); //get cappuccino
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 150
        ArrayList<Drink.TypeOfDrink> order = new ArrayList<>(); //create new order
        order.add(Drink.TypeOfDrink.CAPPUCCINO); //add new drink to order
        order.add(Drink.TypeOfDrink.CACAO); //add new drink to order
        System.out.println(newKitchen.makeAnOrder(machine1, order)); //create a new order (we get list of 3 drinks)
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 50
        machine2.setUpCapsule(Drink.TypeOfDrink.CACAO); //put a new capsule to the capsule machine
        water.fillWaterBank(); //fill bank of water
        System.out.println(machine2.produceDrinkOfCapsule()); //make drink using capsule
        System.out.println(machine2.produceDrinkOfCapsule()); //make drink again, but get null,
                                                                // because we have to set up a new capsule
        machine2.getOutCapsule(); //get out a used capsule
        machine2.setUpCapsule(Drink.TypeOfDrink.CACAO); //set up a new capsule
        System.out.println(machine2.produceDrinkOfCapsule()); //make drink using capsule again (we get a drink)
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 50
        System.out.println(newKitchen.makeAnOrder(machine1, order)); //order is null, because we do not
                                                                        // have enough water in water bank
        storage.fillStorage();
        machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO);
        machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO);
        System.out.println(storage.getStateOfStorage());
    }
}
