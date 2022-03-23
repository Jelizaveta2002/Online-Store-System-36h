package ee.taltech.iti0202.coffee.storage;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Storage {

    private final static Logger LOGGER = Logger.getLogger(Drink.class.getName());
    private int millilitersOfMilk;
    private int gramsOfBeans;
    private int gramsOfCacao;
    private final ArrayList<Capsule> listOfCapsules = new ArrayList<>();

    /**
     * Create a new storage for products.
     */
    public Storage() { //firstly storage is empty, we have to fill it
        LOGGER.info("Creating a Storage.");
    }

    /**
     * Get milliliters of milk.
     */
    public Integer getMillilitersOfMilk() {
        return this.millilitersOfMilk;
    }


    /**
     * Get amount of coffee beans.
     */
    public Integer getGramsOfBeans() {
        return this.gramsOfBeans;
    }


    /**
     * Get amount of cacao.
     */
    public Integer getGramsOfCacao() {
        return this.gramsOfCacao;
    }


    /**
     * Get list of all the capsules.
     */
    public ArrayList<Capsule> getCapsules() {
        return this.listOfCapsules;
    }


    /**
     * Fill the storage with all the products (amounts of products are fixed).
     */
    public void fillStorage() { //we fill the storage (all the amounts of products are fixed)
        this.listOfCapsules.clear(); //clear the list of capsules to have only a fixed amount of them
        this.millilitersOfMilk = 200;
        this.gramsOfBeans = 60;
        this.gramsOfCacao = 500;
        ArrayList<Drink> choiceOfDrinks = new ArrayList<>(); //make a list of all types of capsules
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.CACAO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.CAPPUCCINO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.ESPRESSO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.LATTE));
        Random rand = new Random();
        for (int i = 0; i < 15; i++) { //
            Capsule capsule = new Capsule(choiceOfDrinks.get(rand.nextInt(choiceOfDrinks.size()))); //randomly add a new capsule
            this.listOfCapsules.add(capsule);
        }
    }


    /**
     * Take milk from storage.
     */
    public void takeMilkFromStorage(Integer millilitersOfMilk) {
        if (this.millilitersOfMilk >= millilitersOfMilk) {
            this.millilitersOfMilk -= millilitersOfMilk;
        }
    }


    /**
     * Take coffee beans from storage.
     */
    public void takeBeansFromStorage(Integer gramsOfBeans) {
        if (this.gramsOfBeans >= gramsOfBeans) {
            this.gramsOfBeans -= gramsOfBeans;
        }
    }


    /**
     * Take cacao from storage.
     */
    public boolean takeCacaoFromStorage(Integer gramsOfCacao) {
        if (this.gramsOfCacao >= gramsOfCacao) {
            this.gramsOfCacao -= gramsOfCacao;
            return true;
        }
        return false;
    }


    /**
     * Take capsule from storage.
     */
    public void takeCapsule(Capsule capsule) {
        this.listOfCapsules.remove(capsule);
    }


    /**
     * Check if storage is not empty.
     */
    public boolean isEmpty() {
        return this.gramsOfCacao == 0 && this.gramsOfBeans == 0 && this.millilitersOfMilk == 0;
    }


    /**
     * Get state of storage in a current time.
     */
    public String getStateOfStorage() {
        return "Milliliters of Milk: " + this.millilitersOfMilk + "\n" + "Grams of Coffee beans: "
                + this.gramsOfBeans + "\n" + "Grams of Cacao: " + this.gramsOfCacao + "\n" + "Number of capsules: " + this.listOfCapsules.size();
    }
}
