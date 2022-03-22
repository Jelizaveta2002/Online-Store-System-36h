package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.machine.AutomaticMachine;
import ee.taltech.iti0202.coffee.machine.CapsuleMachine;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.recipe.Recipe;

import java.util.ArrayList;

public class Kitchen {
    private String name;
    private ArrayList<CoffeeMachine> listOfMachines = new ArrayList<>();
    private ArrayList<ArrayList<Drink>> listOfOrders = new ArrayList<>();
    public Kitchen(String name) {
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

    public boolean addNewMachine(CoffeeMachine machine) {
        this.listOfMachines.add(machine);
        return true;
    }

    public ArrayList<Drink> makeAnOrder(AutomaticMachine machine, ArrayList<Recipe> recipes) {
        ArrayList<Drink> order = new ArrayList<>();
        if (machine.machineWorks() && machine.getCapacityOfRubbishBin() >= recipes.size() && machine.getWaterBank().getMillilitersOfWater() >= recipes.size() * 50) {
            for (Recipe recipe : recipes) {
                order.add(machine.produceDrink(recipe));
            }
            return order;
        }
        return null;
    }
}
