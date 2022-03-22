package ee.taltech.iti0202.coffee.machine;


import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.storage.Storage;
import ee.taltech.iti0202.coffee.water.WaterBank;

import java.util.*;

public class CoffeeMachine {
    protected String name;
    protected Integer capacityOfRubbishBin;
    protected Integer capacityOfRubbishBinConstant;

    protected WaterBank storageOfWater;
    protected Storage storageOfIngredients;

    protected boolean isBroken;
    protected final ArrayList<Drink> listOfAllDrinks = new ArrayList<>(); //list of all drinks, that coffee machine produced

    public CoffeeMachine(CoffeeMachineBuilder builder) {
        this.name = builder.name;
        this.capacityOfRubbishBin = builder.capacityOfRubbishBin;
        this.capacityOfRubbishBinConstant = builder.capacityOfRubbishBinConstant;
    }

    public static class CoffeeMachineBuilder {
        private String name;
        private Integer capacityOfRubbishBin ;
        private Integer capacityOfRubbishBinConstant;

        public CoffeeMachineBuilder(String name) {
            this.name = name;
        }

        public CoffeeMachineBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CoffeeMachineBuilder capacityOfRubbishBin(Integer capacityOfRubbishBin) {
            this.capacityOfRubbishBin = capacityOfRubbishBin;
            this.capacityOfRubbishBinConstant = capacityOfRubbishBin;
            return this;
        }

        public CoffeeMachine build() {
            if (this.name == null) {
                throw new IllegalArgumentException("All the parameters should exist!");
            }
            if (this.name.trim().isEmpty()) {
                throw new IllegalArgumentException("Parameters are inserted improperly!");
            }
            return new CoffeeMachine(this);
        }

    }

    /**
     * Get name.
     */
    public String getName() {
        return this.name;
    }

    public ArrayList<Drink> getListOfDrinks() {
        return this.listOfAllDrinks;
    }

    /**
     * Get capacity of rubbish bin.
     */
    public Integer getCapacityOfRubbishBin() {
        return this.capacityOfRubbishBin;
    }

    /**
     * Connect machine with water bank.
     */
    public void setWaterBank(WaterBank waterbank) {
        this.storageOfWater = waterbank;
        waterbank.connectNewMachine(this);
    }

    /**
     * Connect machine with water bank.
     */
    public void setStorage(Storage storageOfIngredients) {
        this.storageOfIngredients = storageOfIngredients;
    }

    /**
     * Button for cleaning rubbish bin.
     */
    public void cleanBin() {
        this.capacityOfRubbishBin = capacityOfRubbishBinConstant;
    }


    /**
     * Check if water bank is not empty and machine is not broken.
     */
    public boolean isBroken() {
        if (this.storageOfWater != null) {
            return this.storageOfWater.getMillilitersOfWater() <= 0;
        }
        return false;
    }

    /**
     * Check if machine can work.
     */
    public boolean machineWorks() {
        if (this.storageOfWater != null && this.storageOfIngredients != null && this.capacityOfRubbishBin > 0) {
            return !isBroken() && !storageOfIngredients.isEmpty();
        }
        return false;

    }

    public WaterBank getWaterBank() {
        return this.storageOfWater;
    }

    public Drink produceDrink(Drink.TypeOfCoffee typeOfCoffee) {
        Drink drink = new Drink(typeOfCoffee);
        if (machineWorks()) {
            HashMap<Drink.Component, Integer> ingredients = drink.getRecipe();
            Storage storageOfIngredients = this.storageOfIngredients;
            for (Drink.Component component : ingredients.keySet()) {
                if (component.equals(Drink.Component.MILK)) {
                    if (ingredients.get(component) > storageOfIngredients.getMillilitersOfMilk()){
                        return null;
                    }
                }
                if (component.equals(Drink.Component.BEANS)) {
                    if (ingredients.get(component) > storageOfIngredients.getGramsOfBeans()){
                        return null;
                    }
                }
                if (component.equals(Drink.Component.CACAO)) {
                    return null;
                }
            }
            for (Drink.Component component : ingredients.keySet()) {
                if (component.equals(Drink.Component.MILK)) {
                    storageOfIngredients.takeMilkFromStorage(drink.getRecipe().get(component));
                }
                if (component.equals(Drink.Component.BEANS)) {
                    storageOfIngredients.takeBeansFromStorage(drink.getRecipe().get(component));
                }
            }
            this.listOfAllDrinks.add(drink);
            this.capacityOfRubbishBin -= 1;
            this.storageOfWater.getWaterFromBank();
            return drink;
        }
        return null;
    }

}