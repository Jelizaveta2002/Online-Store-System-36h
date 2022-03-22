package ee.taltech.iti0202.coffee.water;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;

public class WaterBank {
    private String name;
    private Integer millilitersOfWater = 200;
    private ArrayList<CoffeeMachine> listOfConnectedMachines = new ArrayList<>();

    public WaterBank(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMillilitersOfWater() {
        return this.millilitersOfWater;
    }

    public void fillWaterBank() {
        this.millilitersOfWater = 200;
    }

    public void getWaterFromBank() {
        if (this.millilitersOfWater >= 50) {
            this.millilitersOfWater -= 50;
        }
    }

    public void connectNewMachine(CoffeeMachine machine) {
        this.listOfConnectedMachines.add(machine);
    }

    public ArrayList<CoffeeMachine> getAllTheMachines() {
        return this.listOfConnectedMachines;
    }
}
