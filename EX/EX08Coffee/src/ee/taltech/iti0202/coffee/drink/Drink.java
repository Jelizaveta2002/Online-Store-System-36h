package ee.taltech.iti0202.coffee.drink;

import java.util.HashMap;
import java.util.logging.Logger;

public class Drink {

    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private final TypeOfDrink typeOfDrink;
    public enum Component { //ingredient of the drink
        MILK, BEANS, CACAO
    }
    protected HashMap<Component, Integer> recipe = new HashMap<>();
    public enum TypeOfDrink { //type of drinks
        CACAO, ESPRESSO, CAPPUCCINO, LATTE
    }

    /**
     * Create a new drink.
     */
    public Drink(TypeOfDrink typeOfCoffee) {
        LOGGER.info("Creating Drink.");
        this.typeOfDrink = typeOfCoffee;
        setRecipe();
    }


    /**
     * Set the recipe of the drink considering its type.
     */
    private void setRecipe() {
        if (this.typeOfDrink.equals(TypeOfDrink.CACAO)) {
            recipe.put(Component.MILK, 100);
            recipe.put(Component.CACAO, 30);
        }
        if (this.typeOfDrink.equals(TypeOfDrink.CAPPUCCINO)) {
            recipe.put(Component.MILK, 100);
            recipe.put(Component.BEANS, 20);
        }

        if (this.typeOfDrink.equals(TypeOfDrink.ESPRESSO)) {
            recipe.put(Component.BEANS, 20);
        }

        if (this.typeOfDrink.equals(TypeOfDrink.LATTE)) {
            recipe.put(Component.BEANS, 30);
            recipe.put(Component.MILK, 100);
        }
    }

    /**
     * Get map of all the ingredients of the drink.
     */
    public HashMap<Component, Integer> getRecipe() {
        return this.recipe;
    }


    /**
     * Get type of drink.
     */
    public TypeOfDrink getTypeOfDrink() {
        return this.typeOfDrink;
    }
}
