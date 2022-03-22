package ee.taltech.iti0202.coffee.recipe;

import java.util.HashMap;

public class EspressoRecipe extends Recipe {
    private final static String nameOfRecipe = "ESPRESSO";
    private final static Integer amountOfBeans = 20;

    public EspressoRecipe() {
        this.name = nameOfRecipe;
        this.ingredients = new HashMap<>();
        ingredients.put(Component.BEANS, amountOfBeans);
    }
}
