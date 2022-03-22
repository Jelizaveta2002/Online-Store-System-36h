package ee.taltech.iti0202.coffee.recipe;

import java.util.HashMap;

public class CacaoRecipe extends Recipe {
    private final static String nameOfRecipe = "CACAO";
    private final static Integer getAmountOfCacao = 30;
    private final static Integer amountOfMilk = 100;

    public CacaoRecipe() {
        this.name = nameOfRecipe;
        this.ingredients = new HashMap<>();
        ingredients.put(Component.MILK, amountOfMilk);
        ingredients.put(Component.CACAO, getAmountOfCacao);

    }
}
