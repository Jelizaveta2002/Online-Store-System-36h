package ee.taltech.iti0202.coffee;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.example.Main;
import ee.taltech.iti0202.coffee.kitchen.Kitchen;
import ee.taltech.iti0202.coffee.machine.AutomaticMachine;
import ee.taltech.iti0202.coffee.machine.CapsuleMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.storage.Storage;
import ee.taltech.iti0202.coffee.water.WaterBank;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;


class CoffeeTest {

    public static final int ONE = 1;
    public static final int FOUR = 4;
    public static final int ONEFOUR = 14;
    public static final int ONEFIVE = 15;
    public static final int KOLM = 3;
    public static final int ONEFIVEZERO = 150;
    public static final int TWOZEROZERO = 200;
    public static final int TWOZERO = 20;

    @org.junit.Test
    public void capsuleTest() {
        Drink drink = new Drink(Drink.TypeOfDrink.CAPPUCCINO);
        Capsule capsule = new Capsule(drink);
        capsule.useCapsule(); //use it after the drink is done
        assertNull(capsule.getFilling()); //filling of capsule become null
        assertTrue(capsule.isEmpty());
    }

    @org.junit.Test
    void drinkTest() {
        Drink drink = new Drink(Drink.TypeOfDrink.ESPRESSO);
        HashMap<Drink.Component, Integer> mapToCheck = new HashMap<>();
        mapToCheck.put(Drink.Component.BEANS, TWOZERO);
        assertEquals(mapToCheck, drink.getRecipe());
        assertEquals(Drink.TypeOfDrink.ESPRESSO, drink.getTypeOfDrink());
    }

    @org.junit.jupiter.api.Test
    void waterBankTest() {
        WaterBank bank = new WaterBank("water");
        CapsuleMachine machine2 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2"));
        bank.fillWaterBank();
        assertEquals(TWOZEROZERO, bank.getMillilitersOfWater()); //bank has 200ml of water
        ArrayList<CoffeeMachine> list = new ArrayList<>();
        assertEquals(list, bank.getAllTheMachines());
        bank.takeWaterFromBank();
        assertEquals(ONEFIVEZERO, bank.getMillilitersOfWater()); //after taking water we have 150ml
        assertEquals("water", bank.getName());
        bank.connectNewMachine(machine2); //connect new machine to the water bank
        list.add(machine2);
        assertEquals(list, bank.getAllTheMachines());
        Main.main(null);

    }

    @org.junit.jupiter.api.Test
    void productStorageTest() {
        WaterBank bank = new WaterBank("water");
        bank.fillWaterBank();
        Storage storage = new Storage(); //create a storage (firstly it is empty)
        storage.fillStorage(); //fill our storage
        AutomaticMachine machine1 = new AutomaticMachine(new CoffeeMachine.CoffeeMachineBuilder("name1").
                capacityOfRubbishBin(ONEFIVE)); //create machine
        CoffeeMachine machine = new CoffeeMachine.CoffeeMachineBuilder("name").capacityOfRubbishBin(KOLM).build();
                                                                                                //create machine
        CapsuleMachine machine2 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2"));
        machine.setWaterBank(bank);
        machine2.setStorage(storage);
        machine.setStorage(storage);
        machine2.setUpCapsule(Drink.TypeOfDrink.CAPPUCCINO); //set up a new capsule
        machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO); //produce new drink
        machine1.produceDrink(Drink.TypeOfDrink.CACAO); //produce new drink, but get null
                                                            // (because we did not get out capsule)
        assertEquals(storage.getCapsules().size(), ONEFOUR);
        String toCheck = "|||  Milliliters of Milk: 100\n"
                + "Grams of Coffee beans: 40\n"
                + "Grams of Cacao: 500\n"
                + "Number of capsules: 14 |||";
        assertEquals(toCheck, storage.getStateOfStorage());
    }

    @org.junit.jupiter.api.Test
    void kitchenTest() {
        Storage storage = new Storage(); //create a storage (firstly it is empty)
        storage.fillStorage(); //fill our storage
        Kitchen kitchen = new Kitchen("kitchen");
        assertEquals("kitchen", kitchen.getName());
        WaterBank bank = new WaterBank("water");
        bank.fillWaterBank();
        AutomaticMachine machine1 = new AutomaticMachine(new CoffeeMachine.CoffeeMachineBuilder("name1").
                capacityOfRubbishBin(FOUR)); //create machine
        machine1.setWaterBank(bank);
        machine1.setStorage(storage);
        kitchen.addNewMachine(machine1);
        ArrayList<Drink.TypeOfDrink> order = new ArrayList<>();
        order.add(Drink.TypeOfDrink.CACAO);
        order.add(Drink.TypeOfDrink.CAPPUCCINO);
        order.add(Drink.TypeOfDrink.LATTE);
        kitchen.makeAnOrder(machine1, order); //make a new order
        kitchen.makeAnOrder(machine1, order); //make one more order, but get null (because water is not enough)
        assertEquals(ONE, kitchen.getListOfOrders().size()); //only one order is done
    }

    @org.junit.jupiter.api.Test
    void capsuleMachineTest() {
        Storage storage = new Storage(); //create a storage (firstly it is empty)
        storage.fillStorage(); //fill our storage
        WaterBank bank = new WaterBank("water");
        bank.fillWaterBank();
        CapsuleMachine machine1 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2"));
        machine1.setWaterBank(bank);
        machine1.setStorage(storage);
        machine1.setUpCapsule(Drink.TypeOfDrink.CAPPUCCINO);
        machine1.produceDrinkOfCapsule();
        machine1.produceDrinkOfCapsule(); //can not produce because we did not get capsule out
        assertEquals(ONE, machine1.getListOfDrinks().size());
    }
}

