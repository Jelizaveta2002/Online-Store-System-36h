package ee.taltech.iti0202.coffee.drink;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

import java.util.HashMap;
import java.util.logging.Logger;

public class Drink {
    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private final TypeOfCoffee typeOfCoffee;
    public enum Component {
        MILK, BEANS, CACAO
    }
    protected HashMap<Component, Integer> recipe = new HashMap<>();
    public enum TypeOfCoffee {
        CACAO, ESPRESSO, CAPPUCCINO, LATTE
    }

    public Drink(TypeOfCoffee typeOfCoffee) {
        LOGGER.info("Creating Drink.");
        this.typeOfCoffee = typeOfCoffee;
        setRecipe();
    }

    private void setRecipe() {
        if (this.typeOfCoffee.equals(TypeOfCoffee.CACAO)) {
            recipe.put(Component.MILK, 100);
            recipe.put(Component.CACAO, 30);
        }
        if (this.typeOfCoffee.equals(TypeOfCoffee.CAPPUCCINO)) {
            recipe.put(Component.MILK, 100);
            recipe.put(Component.BEANS, 20);
        }

        if (this.typeOfCoffee.equals(TypeOfCoffee.ESPRESSO)) {
            recipe.put(Component.BEANS, 20);
        }

        if (this.typeOfCoffee.equals(TypeOfCoffee.LATTE)) {
            recipe.put(Component.BEANS, 30);
            recipe.put(Component.MILK, 100);
        }
    }

    public HashMap<Component, Integer> getRecipe() {
        return this.recipe;
    }

    public TypeOfCoffee getTypeOfCoffee() {
        return this.typeOfCoffee;
    }
}
