package ee.taltech.iti0202.coffee.water;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.logging.Logger;

public class WaterBank {
    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private final String name;
    private Integer millilitersOfWater = 200;
    private final ArrayList<CoffeeMachine> listOfConnectedMachines = new ArrayList<>();

    public WaterBank(String name) {
        LOGGER.info("Creating a Water Bank.");
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
