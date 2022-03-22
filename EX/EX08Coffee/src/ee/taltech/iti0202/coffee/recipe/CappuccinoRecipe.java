package ee.taltech.iti0202.coffee.recipe;

import java.util.HashMap;

public class CappuccinoRecipe extends Recipe {
    private final static String nameOfRecipe = "CAPPUCCINO";
    private final static Integer amountOfBeans = 20;
    private final static Integer amountOfMilk = 100;

    public CappuccinoRecipe() {
        this.name = nameOfRecipe;
        this.ingredients = new HashMap<>();
        ingredients.put(Component.BEANS, amountOfBeans);
        ingredients.put(Component.MILK, amountOfMilk);
    }
}
