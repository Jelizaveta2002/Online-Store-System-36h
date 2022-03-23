package ee.taltech.iti0202.coffee.machine;


import ee.taltech.iti0202.coffee.drink.Drink;
import ee.taltech.iti0202.coffee.storage.Storage;
import ee.taltech.iti0202.coffee.water.WaterBank;

import java.util.*;
import java.util.logging.Logger;

public class CoffeeMachine {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    protected String name;
    protected Integer capacityOfRubbishBin;
    protected Integer capacityOfRubbishBinConstant;

    protected WaterBank storageOfWater;
    protected Storage storageOfIngredients;

    protected final ArrayList<Drink> listOfAllDrinks = new ArrayList<>(); //list of all drinks,
                                                                        // that coffee machine produced


    /**
     * Create coffee machine using builder.
     */
    public CoffeeMachine(CoffeeMachineBuilder builder) {
        this.name = builder.name;
        this.capacityOfRubbishBin = builder.capacityOfRubbishBin;
        this.capacityOfRubbishBinConstant = builder.capacityOfRubbishBinConstant;
    }


    /**
     * Create builder for coffee machine.
     */
    public static class CoffeeMachineBuilder {
        private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
        private String name;
        private Integer capacityOfRubbishBin ;
        private Integer capacityOfRubbishBinConstant;

        public CoffeeMachineBuilder(String name) {
            LOGGER.info("Creating CoffeeMachineBuilder.");
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
        if (waterbank != null) {
            this.storageOfWater = waterbank;
            waterbank.connectNewMachine(this); //add machine to the list of machines,
                                                // that get water from exact water bank
        }
    }

    /**
     * Set the storage where machine can get needed products
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
            return this.storageOfWater.getMillilitersOfWater() <= ZERO; //machine is broken, if its water bank is empty
        }
        return false;
    }

    /**
     * Check if machine can work.
     */
    public boolean machineWorks() {
        if (this.storageOfWater != null && this.storageOfIngredients != null && this.capacityOfRubbishBin > ZERO) {
            return !isBroken() && !storageOfIngredients.isEmpty(); //machine can work if it is not broken and
                                                                    // its product storage is not empty
        }
        return false;

    }

    /**
     * Get storage of water.
     */
    public WaterBank getWaterBank() {
        return this.storageOfWater;
    }

    public Drink produceDrink(Drink.TypeOfDrink typeOfCoffee) {
        Drink drink = new Drink(typeOfCoffee); //create a new drink
        if (machineWorks()) {
            HashMap<Drink.Component, Integer> ingredients = drink.getRecipe(); //get recipe of drink, that we have done
            Storage storageOfIngredients = this.storageOfIngredients;
            for (Drink.Component component : ingredients.keySet()) { //iterate over map that consist
                                                                    // key:ingredient, value:number of ingredient
                if (component.equals(Drink.Component.MILK)) { //if one ingredient is milk:
                    if (ingredients.get(component) > storageOfIngredients.getMillilitersOfMilk()){ //check that our
                                                                                            // storage has enough milk
                        return null; //if not, return null instead of drink
                    }
                }
                if (component.equals(Drink.Component.BEANS)) { //if one ingredient are beans:
                    if (ingredients.get(component) > storageOfIngredients.getGramsOfBeans()){ //check that our
                                                                                            // storage has enough beans
                        return null; //if not, return null instead of drink
                    }
                }
                if (component.equals(Drink.Component.CACAO)) { //if one ingredient is cacao:
                    return null; //return null, because manual machine can not make cacao
                }
            }
            for (Drink.Component component : ingredients.keySet()) {  //iterate over map that consists of
                                                                        // key:ingredient, value:number of ingredient
                if (component.equals(Drink.Component.MILK)) { //if ingredient is milk:
                    storageOfIngredients.takeMilkFromStorage(drink.getRecipe().get(component)); //take milk from
                                                // storage, considering the number of ingredients in milliliters/grams
                }
                if (component.equals(Drink.Component.BEANS)) { //if ingredient are beans:
                    storageOfIngredients.takeBeansFromStorage(drink.getRecipe().get(component)); //take beans from
                                                // storage, considering the number of ingredients in milliliters/grams
                }
            }
            this.listOfAllDrinks.add(drink); //if method is here, so we can produce drink, so we add
                                                // it to the list of all the produced drinks byt this machine
            this.capacityOfRubbishBin -= ONE; //capacity of rubbish bin is getting smaller
            this.storageOfWater.takeWaterFromBank(); //take water from bank(every cup takes 50ml)
            return drink; //return drink, because it can be produced
        }
        return null; //return null if machine does not work
    }

}