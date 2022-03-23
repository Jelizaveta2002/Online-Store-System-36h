package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drink.Drink;

public class AutomaticMachine extends CoffeeMachine {

    public static final int SEVEN = 7;
    public static final int ZERO = 0;
    public static final int ONE = 1;

    /**
     * Create a new automatic machine.
     *
     * @param builder builder
     */
    public AutomaticMachine(CoffeeMachineBuilder builder) {
        super(builder);
        if (this.capacityOfRubbishBin == null) {
            this.capacityOfRubbishBin = SEVEN;
            this.capacityOfRubbishBinConstant = SEVEN;
        }
    }

    @Override
    public boolean machineWorks() {
        if (this.storageOfWater != null && this.capacityOfRubbishBin > ZERO) {
            return !isBroken();
        }
        return false;
    }

    @Override
    public Drink produceDrink(Drink.TypeOfDrink typeOfCoffee) {
        if (machineWorks()) { //here we only need to have enough water and free
                                // capacity of rubbish bin in order to produce new drink
            Drink drink = new Drink(typeOfCoffee);
            this.listOfAllDrinks.add(drink);
            this.capacityOfRubbishBin -= ONE;
            this.storageOfWater.takeWaterFromBank();
            return drink;
        }
        return null;
    }
}
