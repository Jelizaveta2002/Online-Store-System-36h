package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;

public class CapsuleMachine extends CoffeeMachine {
    private Capsule capsule;

    /**
     * Create a new capsule machine.
     */
    public CapsuleMachine(CoffeeMachineBuilder builder) {
        super(builder);
        if (this.capacityOfRubbishBin == null) { //if we do not have a capacity, we can use fixed capacity instead
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

    /**
     * Set up a new capsule.
     */
    public boolean setUpCapsule(Drink.TypeOfDrink typeOfCoffee) {
        if (this.capsule == null) { //we can set up capsule only after method getOutCapsule
            for (Capsule capsule : this.storageOfIngredients.getCapsules()) { //iterate over the storage of capsules
                if (capsule.getFilling().getTypeOfDrink().equals(typeOfCoffee)) { //if capsule filling(type of coffee) is the same that we need:
                    this.capsule = capsule; //set up this capsule into our machine
                    this.storageOfIngredients.takeCapsule(capsule); //take the capsule from storage away
                    return true;
                }
            }
        }
        return false; //return false if we do not have capsule with needed filling or already used capsule is still into the machine
    }

    /**
     * Get out a capsule from the machine.
     */
    public void getOutCapsule() {
        this.capsule = null; //change capsule state to null, that means that we can set up another capsule
    }


    @Override
    public Drink produceDrink(Drink.TypeOfDrink typeOfCoffee) {
        throw new IllegalArgumentException("This method is not supported by Capsule machine, use 'produceDrinkOfCapsule' instead!");
    }


    /**
     * Method START to crate the drink by using capsule machine.
     */
    public Drink produceDrinkOfCapsule() {
        if (this.machineWorks() && this.capsule != null && !this.capsule.isEmpty()) { //if our machine is able to produce drink
            Drink drink = new Drink(this.capsule.getFilling().getTypeOfDrink()); //create a new drink considering the filling of capsule that we set up
            this.listOfAllDrinks.add(drink); //add our drink to all the drinks that this machine produced
            this.capacityOfRubbishBin -= 1; //capacity of rubbish bin is getting smaller
            this.storageOfWater.takeWaterFromBank(); //take a fixed milliliters of water away from water bank(50 ml)
            this.capsule.useCapsule(); //capsule is used, so its filling become null
            return drink;
        }
        if (this.machineWorks() && this.capsule.getFilling() == null) { //if machine works but our capsule is used, so we get only water
            this.storageOfWater.takeWaterFromBank();
        }
        return null; //return null if we could not get a drink
    }
}
