package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drink.Drink;

public class AutomaticMachine extends CoffeeMachine {

    /**
     * Create a new automatic machine.
     */
    public AutomaticMachine(CoffeeMachineBuilder builder) {
        super(builder);
        if (this.capacityOfRubbishBin == null) {
            this.capacityOfRubbishBin = 7;
            this.capacityOfRubbishBinConstant = 7;
        }
    }

    @Override
    public boolean machineWorks() {
        if (this.storageOfWater != null && this.capacityOfRubbishBin > 0) {
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
            this.capacityOfRubbishBin -= 1;
            this.storageOfWater.takeWaterFromBank();
            return drink;
        }
        return null;
    }
}
