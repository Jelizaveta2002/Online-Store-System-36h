package ee.taltech.iti0202.coffee;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.kitchen.Kitchen;
import ee.taltech.iti0202.coffee.machine.AutomaticMachine;
import ee.taltech.iti0202.coffee.machine.CapsuleMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.storage.Storage;
import ee.taltech.iti0202.coffee.water.WaterBank;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class CoffeeTest {

    public static final int ONE = 1;
    public static final int FOUR = 4;
    public static final int ONEFOUR = 14;
    public static final int ONEFIVE = 15;
    public static final int KOLM = 3;
    public static final int ONEFIVEZERO = 150;
    public static final int TWOZEROZERO = 200;

    @Test
    public void CapsuleTest() {
        Drink drink = new Drink(Drink.TypeOfDrink.CAPPUCCINO);
        Capsule capsule = new Capsule(drink);
        capsule.useCapsule();
        assertNull(capsule.getFilling());
        assertTrue(capsule.isEmpty());
    }

    @org.junit.Test
    void DrinkTest() {
        Drink drink = new Drink(Drink.TypeOfDrink.ESPRESSO);
        HashMap<Drink.Component, Integer> mapToCheck = new HashMap<>();
        mapToCheck.put(Drink.Component.BEANS, 20);
        assertEquals(mapToCheck, drink.getRecipe());
        assertEquals(Drink.TypeOfDrink.ESPRESSO, drink.getTypeOfDrink());
    }

    @org.junit.jupiter.api.Test
    void waterBankTest() {
        WaterBank bank = new WaterBank("water");
        CapsuleMachine machine2 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2"));
        bank.fillWaterBank();
        assertEquals(TWOZEROZERO, bank.getMillilitersOfWater());
        ArrayList<CoffeeMachine> list = new ArrayList<>();
        assertEquals(list, bank.getAllTheMachines());
        bank.takeWaterFromBank();
        assertEquals(ONEFIVEZERO, bank.getMillilitersOfWater());
        assertEquals("water", bank.getName());
        bank.connectNewMachine(machine2);
        list.add(machine2);
        assertEquals(list, bank.getAllTheMachines());

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
        machine2.setUpCapsule(Drink.TypeOfDrink.CAPPUCCINO);
        machine.produceDrink(Drink.TypeOfDrink.CAPPUCCINO);
        machine1.produceDrink(Drink.TypeOfDrink.CACAO);
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
        kitchen.makeAnOrder(machine1, order);
        kitchen.makeAnOrder(machine1, order);
        assertEquals(ONE, kitchen.getListOfOrders().size());
    }

    @org.junit.jupiter.api.Test
    void CapsuleMachineTest() {
        Storage storage = new Storage(); //create a storage (firstly it is empty)
        storage.fillStorage(); //fill our storage
        WaterBank bank = new WaterBank("water");
        bank.fillWaterBank();
        CapsuleMachine machine1 = new CapsuleMachine(new CoffeeMachine.CoffeeMachineBuilder("name2"));
        machine1.setWaterBank(bank);
        machine1.setStorage(storage);
        machine1.setUpCapsule(Drink.TypeOfDrink.CAPPUCCINO);
        machine1.produceDrinkOfCapsule();
        machine1.produceDrinkOfCapsule();
        assertEquals(ONE, machine1.getListOfDrinks().size());
    }
}

