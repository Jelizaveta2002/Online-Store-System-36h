package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.machine.AutomaticMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Kitchen {
    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private final String name;
    private final ArrayList<CoffeeMachine> listOfMachines = new ArrayList<>();
    private final ArrayList<ArrayList<Drink>> listOfOrders = new ArrayList<>();

    public Kitchen(String name) {
        LOGGER.info("Creating a Kitchen.");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<CoffeeMachine> getListOfMachines() {
        return this.listOfMachines;
    }

    public ArrayList<ArrayList<Drink>> getListOfOrders() {
        return this.listOfOrders;
    }

    public void addNewMachine(CoffeeMachine machine) {
        this.listOfMachines.add(machine);
    }

    public ArrayList<Drink> makeAnOrder(AutomaticMachine machine, ArrayList<Drink.TypeOfCoffee> typeOfCoffees) {
        ArrayList<Drink> order = new ArrayList<>();
        if (machine.machineWorks() && machine.getCapacityOfRubbishBin() >= typeOfCoffees.size() && machine.getWaterBank().getMillilitersOfWater() >= typeOfCoffees.size() * 50) {
            for (Drink.TypeOfCoffee recipe : typeOfCoffees) {
                order.add(machine.produceDrink(recipe));
            }
            return order;
        }
        return null;
    }
}
