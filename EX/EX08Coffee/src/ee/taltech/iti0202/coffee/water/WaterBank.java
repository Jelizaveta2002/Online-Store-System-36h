package ee.taltech.iti0202.coffee.water;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.ArrayList;
import java.util.logging.Logger;

public class WaterBank {

    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    public static final int TWOZEROZERO = 200;
    public static final int FIVEZERO = 50;
    private final String name;
    private Integer millilitersOfWater = TWOZEROZERO;
    private final ArrayList<CoffeeMachine> listOfConnectedMachines = new ArrayList<>();

    /**
     * Create a new water bank.
     */
    public WaterBank(String name) {
        LOGGER.info("Creating a Water Bank.");
        this.name = name;
    }

    /**
     * Get name of water bank.
     * @return the name of the object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get current state of water bank.
     * @return the name of the object
     */
    public Integer getMillilitersOfWater() {
        return this.millilitersOfWater;
    }


    /**
     * Fill the water bank with water (amount is fixed).
     */
    public void fillWaterBank() {
        this.millilitersOfWater = TWOZEROZERO;
    }


    /**
     * Use water from bank for making new drinks.
     */
    public void takeWaterFromBank() {
        if (this.millilitersOfWater >= FIVEZERO) {
            this.millilitersOfWater -= FIVEZERO;
        }
    }


    /**
     * Connect water bank with new machine.
     */
    public void connectNewMachine(CoffeeMachine machine) {
        if (!listOfConnectedMachines.contains(machine)) {
            this.listOfConnectedMachines.add(machine);
        }
    }

    /**
     * Get list of all machines taht are connected to this water bank.
     * @return the name of the object
     */
    public ArrayList<CoffeeMachine> getAllTheMachines() {
        return this.listOfConnectedMachines;
    }
}
