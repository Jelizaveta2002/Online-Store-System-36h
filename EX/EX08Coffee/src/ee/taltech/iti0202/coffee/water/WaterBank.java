package ee.taltech.iti0202.coffee.water;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;

public class WaterBank {
    private String name;
    private Integer litersOfWater;
    private ArrayList<CoffeeMachine> listOfConnectedMachines = new ArrayList<>();

    public WaterBank(String name, Integer litersOfWater) {
        this.name = name;
        this.litersOfWater = litersOfWater;
    }

    public String getName() {
        return this.name;
    }

    public Integer getLitersOfWater() {
        return this.litersOfWater;
    }

    public void fillWaterBank(Integer litersOfWater) {
        this.litersOfWater += litersOfWater;
    }

    public boolean getWaterFromBank(Integer litersOfWater) {
        if (this.litersOfWater >= litersOfWater) {
            this.litersOfWater -= litersOfWater;
            return true;
        }
        return false;
    }

    public void connectNewMachine(CoffeeMachine machine) {
        this.listOfConnectedMachines.add(machine);
    }
}
