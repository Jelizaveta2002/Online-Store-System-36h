package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.recipe.Recipe;

public class CapsuleMachine extends CoffeeMachine {
    private Capsule capsule;

    public CapsuleMachine(CoffeeMachineBuilder builder) {
        super(builder);
        if (this.capacityOfRubbishBin == null) {
            this.capacityOfRubbishBin = 10;
            this.capacityOfRubbishBinConstant = 10;
        }
    }


    @Override
    public boolean machineWorks() {
        if (this.storageOfWater != null && this.storageOfIngredients != null && this.capacityOfRubbishBin > 0) {
            return !isBroken() && this.storageOfIngredients.getCapsules().size() != 0;
        }
        return false;

    }

    public boolean setUpCapsule(Recipe recipe) {
        for (Capsule capsule : this.storageOfIngredients.getCapsules()) {
            if (capsule.getFilling().getName().equals(recipe.getName())) {
                this.capsule = capsule;
                this.storageOfIngredients.takeCapsule(capsule);
                return true;
            }
        }
        return false;
    }

    public void getOutCapsule() {
        this.capsule = null;
    }


    @Override
    public Drink produceDrink(Recipe recipe) {
        throw new IllegalArgumentException("This method is not supported by Capsule machine, use 'produceDrinkOfCapsule' instead!");
    }

    public Drink produceDrinkOfCapsule() {
        if (this.machineWorks() && this.capsule != null && this.capsule.getFilling() != null) {
            Drink drink = new Drink(this, this.capsule.getFilling());
            this.listOfAllDrinks.add(drink);
            this.capacityOfRubbishBin -= 1;
            this.storageOfWater.getWaterFromBank();
            this.capsule = null;
            return drink;
        }
        if (this.machineWorks()) {
            this.storageOfWater.getWaterFromBank();
        }
        return null;
    }
}
