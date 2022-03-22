package ee.taltech.iti0202.coffee.storage;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;

import java.util.ArrayList;
import java.util.Random;

public class Storage {
    private int millilitersOfMilk;
    private int gramsOfBeans;
    private int gramsOfCacao;
    private final ArrayList<Capsule> listOfCapsules = new ArrayList<>();

    public Storage() {

    }

    public Integer getMillilitersOfMilk() {
        return this.millilitersOfMilk;
    }

    public Integer getGramsOfBeans() {
        return this.gramsOfBeans;
    }

    public Integer getGramsOfCacao() {
        return this.gramsOfCacao;
    }

    public ArrayList<Capsule> getCapsules() {
        return this.listOfCapsules;
    }

    public void fillStorage() {
        this.listOfCapsules.clear();
        this.millilitersOfMilk = 200;
        this.gramsOfBeans = 60;
        this.gramsOfCacao = 500;
        ArrayList<Drink> choiceOfDrinks = new ArrayList<>();
        choiceOfDrinks.add(new Drink(Drink.TypeOfCoffee.CACAO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfCoffee.CAPPUCCINO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfCoffee.ESPRESSO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfCoffee.LATTE));
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            Capsule capsule = new Capsule(choiceOfDrinks.get(rand.nextInt(choiceOfDrinks.size())));
            this.listOfCapsules.add(capsule);
        }
    }

    public void takeMilkFromStorage(Integer millilitersOfMilk) {
        if (this.millilitersOfMilk >= millilitersOfMilk) {
            this.millilitersOfMilk -= millilitersOfMilk;
        }
    }

    public void takeBeansFromStorage(Integer gramsOfBeans) {
        if (this.gramsOfBeans >= gramsOfBeans) {
            this.gramsOfBeans -= gramsOfBeans;
        }
    }

    public boolean takeCacaoFromStorage(Integer gramsOfCacao) {
        if (this.gramsOfCacao >= gramsOfCacao) {
            this.gramsOfCacao -= gramsOfCacao;
            return true;
        }
        return false;
    }

    public void takeCapsule(Capsule capsule) {
        this.listOfCapsules.remove(capsule);
    }

    public boolean isEmpty() {
        return this.gramsOfCacao == 0 && this.gramsOfBeans == 0 && this.millilitersOfMilk == 0;
    }

    public String getStateOfStorage() {
        return "Milliliters of Milk: " + this.millilitersOfMilk + "\n" + "Grams of Coffee beans: "
                + this.gramsOfBeans + "\n" + "Grams of Cacao: " + this.gramsOfCacao + "\n" + "Number of capsules: " + this.listOfCapsules.size();
    }
}
