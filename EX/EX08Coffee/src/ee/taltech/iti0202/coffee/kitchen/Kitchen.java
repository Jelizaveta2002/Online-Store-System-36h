package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.machine.AutomaticMachine;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Kitchen {
    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    public static final int FIVEZERO = 50;
    private final String name;
    private final ArrayList<AutomaticMachine> listOfMachines = new ArrayList<>();
    private final ArrayList<ArrayList<Drink>> listOfOrders = new ArrayList<>();

    /**
     * Create a new kitchen (kitchen can have only automatic machines).
     */
    public Kitchen(String name) {
        LOGGER.info("Creating a Kitchen.");
        this.name = name;
    }

    /**
     * Get name of the kitchen.
     * @return the name of the object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get list of all machines in the kitchen.
     * @return the name of the object
     */
    public ArrayList<AutomaticMachine> getListOfMachines() {
        return this.listOfMachines;
    }

    /**
     * Check if our kitchen has at least one machine.
     * @return the name of the object
     */
    public boolean isListOfMachinesEmpty() {
        return !this.listOfMachines.isEmpty();
    }

    /**
     * Get list of all orders that were done by this kitchen.
     * @return the name of the object
     */
    public ArrayList<ArrayList<Drink>> getListOfOrders() {
        return this.listOfOrders;
    }

    /**
     * Add a new machine into the kitchen
     */
    public void addNewMachine(AutomaticMachine machine) {
        this.listOfMachines.add(machine);
    }


    /**
     * Make an order for the automatic machine.
     * @return the name of the object
     */
    public ArrayList<Drink> makeAnOrder(AutomaticMachine machine, ArrayList<Drink.TypeOfDrink> typeOfCoffees) {
        if (this.isListOfMachinesEmpty()) { //if we have at least one machine
            ArrayList<Drink> order = new ArrayList<>(); //create a new order list
            if (machine.machineWorks() && machine.getCapacityOfRubbishBin() >= typeOfCoffees.size()
                    //check if our machine has enough water and capacity of bin to produce all the drinks in order
                    && machine.getWaterBank().getMillilitersOfWater() >= typeOfCoffees.size() * FIVEZERO) {
                for (Drink.TypeOfDrink typeOfCoffee : typeOfCoffees) {
                    order.add(machine.produceDrink(typeOfCoffee));
                    //produce a new drink and add it into the order list
                }
                this.listOfOrders.add(order);
                return order;
            }
        }
        return null; //null if we can not produce all the drinks in order
    }
}
