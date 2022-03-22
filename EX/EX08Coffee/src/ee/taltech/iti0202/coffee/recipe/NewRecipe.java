package ee.taltech.iti0202.coffee.recipe;

public class NewRecipe extends Recipe{

    public NewRecipe(String nameOfRecipe, Integer amountOfBeans, Integer amountOfMilk) {
        this.name = nameOfRecipe;
        this.ingredients.put(Component.BEANS, amountOfBeans);
        this.ingredients.put(Component.MILK, amountOfMilk);
    }
}
