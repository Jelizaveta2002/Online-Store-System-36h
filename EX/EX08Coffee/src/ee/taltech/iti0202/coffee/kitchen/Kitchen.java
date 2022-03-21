package ee.taltech.iti0202.coffee.kitchen;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;

public class Kitchen {
    private String name;
    private ArrayList<CoffeeMachine> listOfMachines = new ArrayList<>();
    public Kitchen(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<CoffeeMachine> getListOfMachines() {
        return this.listOfMachines;
    }

    public boolean addNewMachine(CoffeeMachine machine) {
        this.listOfMachines.add(machine);
        return true;
    }
}
