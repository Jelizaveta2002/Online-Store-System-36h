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
        CoffeeMachine machine = new CoffeeMachine.CoffeeMachineBuilder("name").capacityOfRubbishBin(3).build(); //create machine
        AutomaticMachine machine1 = new AutomaticMachine(new CoffeeMachine.CoffeeMachineBuilder("name1").capacityOfRubbishBin(15)); //create machine
        CapsuleMachine machine2 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2")); //create machine
        newKitchen.addNewMachine(machine);
        newKitchen.addNewMachine(machine1);
        newKitchen.addNewMachine(machine2);
        machine.setWaterBank(water);
        machine1.setWaterBank(water);
        machine2.setWaterBank(water);
        machine.setStorage(storage);
        machine1.setStorage(storage);
        machine2.setStorage(storage);
        System.out.println(storage.getStateOfStorage()); //get the state of storage(num of products)
        System.out.println(newKitchen.getListOfMachines());  //list of all machines in the kitchen
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.CAPPUCCINO)); //make cappucino using ordinary machine
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.CAPPUCCINO)); //make espresso using ordinary machine
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.CAPPUCCINO)); //make one more drink, but get null because not enough products
        storage.fillStorage(); //fill the storage
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.CAPPUCCINO)); //make espresso using ordinary machine
        System.out.println(machine.getListOfDrinks()); //get all the drinks done by this machine (3 in total)
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.ESPRESSO)); //cant make drink, cause bin is full
        machine.cleanBin();
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.ESPRESSO));
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 0
        System.out.println(machine.isBroken()); //machine is broken, because water bank should always be full
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.CAPPUCCINO));
        water.fillWaterBank(); //fill bank of water
        System.out.println(machine.produceDrink(Drink.TypeOfCoffee.CAPPUCCINO));
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 0
        ArrayList<Drink.TypeOfCoffee> orderlist = new ArrayList<>();
        orderlist.add(Drink.TypeOfCoffee.CAPPUCCINO);
        orderlist.add(Drink.TypeOfCoffee.CACAO);
        System.out.println(newKitchen.makeAnOrder(machine1, orderlist));
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 0
        machine2.setUpCapsule(Drink.TypeOfCoffee.CACAO);
        water.fillWaterBank(); //fill bank of water
        System.out.println(machine2.produceDrinkOfCapsule()); //make drink using capsule
        System.out.println(machine2.produceDrinkOfCapsule()); //make drink again, but get null, cause we have to set up a new capsule
        machine2.setUpCapsule(Drink.TypeOfCoffee.CACAO);
        System.out.println(machine2.produceDrinkOfCapsule()); //make drink using capsule
        System.out.println(water.getMillilitersOfWater()); //check our state of water, it is 50
        System.out.println(newKitchen.makeAnOrder(machine1, orderlist)); //order is null, cause we don t have enough water in water bank
    }
}
