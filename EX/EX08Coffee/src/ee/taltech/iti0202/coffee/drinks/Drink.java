package ee.taltech.iti0202.coffee.drinks;

import ee.taltech.iti0202.coffee.machine.CoffeeMachine;

public class Drink {

    protected Integer millilitersOfMilk;
    protected Integer gramsOfBeans;
    protected Integer gramsOfCacao;
    protected Integer millilitersOfWater;

    public Drink(Integer millilitersOfWater, Integer millilitersOfMilk, Integer gramsOfBeans, Integer gramsOfCacao) {
        this.millilitersOfWater = millilitersOfWater;
        this.millilitersOfMilk = millilitersOfMilk;
        this.gramsOfBeans = gramsOfBeans;
        this.gramsOfCacao = gramsOfCacao;
    }

    public Integer getMillilitersOfMilk() {
        return this.millilitersOfWater;
    }
}
