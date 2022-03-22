package ee.taltech.iti0202.coffee.recipe;

import java.util.HashMap;

public abstract class Recipe {
    protected HashMap<Component, Integer> ingredients = new HashMap<>();
    protected String name;
    public enum Component {
        MILK, BEANS, CACAO
    }


    public String getName() {
        return this.name;
    }

    public HashMap<Component, Integer> getIngredients() {
        return this.ingredients;
    }

}
