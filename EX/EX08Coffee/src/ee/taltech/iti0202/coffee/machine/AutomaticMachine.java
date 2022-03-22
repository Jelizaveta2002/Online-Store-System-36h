package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.recipe.Recipe;

public class AutomaticMachine extends CoffeeMachine {
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
    public Drink produceDrink(Recipe recipe) {
        if (machineWorks()) {
            Drink drink = new Drink(this, recipe);
            this.listOfAllDrinks.add(drink);
            this.capacityOfRubbishBin -= 1;
            this.storageOfWater.getWaterFromBank();
            return drink;
        }
        return null;
    }
}
