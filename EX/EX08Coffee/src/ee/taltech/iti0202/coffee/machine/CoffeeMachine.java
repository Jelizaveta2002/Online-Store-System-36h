package ee.taltech.iti0202.coffee.machine;

import ee.taltech.iti0202.coffee.drinks.Drink;

import java.util.*;

public class CoffeeMachine {
    protected String name;
    protected Integer cupsOfCoffeeCanBeDone;
    protected Integer capacityOfRubbishBin;
    protected Integer gramsOfBeans;
    protected Integer millilitersOfWater;
    protected final ArrayList<String> listOfAllDrinks = new ArrayList<>();

    public CoffeeMachine(CoffeeMachineBuilder builder) {
        this.name = builder.name;
        this.capacityOfRubbishBin = builder.capacityOfRubbishBin;
        this.cupsOfCoffeeCanBeDone = builder.cupsOfCoffeeCanBeDone;
    }


    public static class CoffeeMachineBuilder {
        private String name;
        private Integer cupsOfCoffeeCanBeDone;
        private Integer capacityOfRubbishBin = 5;

        public CoffeeMachineBuilder(String name) {
            this.name = name;
        }

        public CoffeeMachineBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CoffeeMachineBuilder cupsOfCoffeeCanBeDone(Integer cupsOfCoffeeCanBeDone) {
            this.cupsOfCoffeeCanBeDone = cupsOfCoffeeCanBeDone;
            return this;
        }

        public CoffeeMachineBuilder capacityOfRubbishBin(Integer capacityOfRubbishBin) {
            this.capacityOfRubbishBin = capacityOfRubbishBin;
            return this;
        }

        public CoffeeMachine build() {
            if (this.name == null || this.cupsOfCoffeeCanBeDone == null) {
                throw new IllegalArgumentException("All the parameters should exist!");
            }
            if (this.cupsOfCoffeeCanBeDone < 0 || this.name.trim().isEmpty()) {
                throw new IllegalArgumentException("Parameters are inserted improperly!");
            }
            return new CoffeeMachine(this);
        }

    }

    public String getName() {
        return this.name;
    }

    public Integer getCupsOfCoffeeCanBeDone() {
        return this.cupsOfCoffeeCanBeDone;
    }

    public Integer getCapacityOfRubbishBin() {
        return this.capacityOfRubbishBin;
    }

    public boolean makeDrink(String drink) {
        return false;
    }
}
