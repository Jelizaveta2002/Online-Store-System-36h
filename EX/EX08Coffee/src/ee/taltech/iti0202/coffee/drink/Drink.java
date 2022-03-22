package ee.taltech.iti0202.coffee.drink;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;
import ee.taltech.iti0202.coffee.recipe.Recipe;

public class Drink {
    private CoffeeMachine coffeeMachine;
    private Recipe recipe;

    public Drink(CoffeeMachine coffeeMachine, Recipe recipe) {
        this.coffeeMachine = coffeeMachine;
        this.recipe = recipe;
    }
}
