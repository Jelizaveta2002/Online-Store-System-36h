package ee.taltech.iti0202.coffee.storage;

import ee.taltech.iti0202.coffee.capsule.Capsule;
import ee.taltech.iti0202.coffee.drink.Drink;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class Storage {

    private static final Logger LOGGER = Logger.getLogger(Drink.class.getName());
    public static final int TWOZEROZERO = 200;
    public static final int KUUZSERO = 60;
    public static final int FIVEZEROZERO = 500;
    public static final int ZERO = 0;
    public static final int ONEFIVE = 15;
    private int millilitersOfMilk;
    private int gramsOfBeans;
    private int gramsOfCacao;
    private final ArrayList<Capsule> listOfCapsules = new ArrayList<>();

    /**
     * Create a new storage for products.
     *
     */
    public Storage() { //firstly storage is empty, we have to fill it
        LOGGER.info("Creating a Storage.");
    }

    /**
     * Get milliliters of milk.
     * @return the name of the object
     */
    public Integer getMillilitersOfMilk() {
        return this.millilitersOfMilk;
    }


    /**
     * Get amount of coffee beans.
     * @return the name of the object
     */
    public Integer getGramsOfBeans() {
        return this.gramsOfBeans;
    }


    /**
     * Get amount of cacao.
     * @return the name of the object
     */
    public Integer getGramsOfCacao() {
        return this.gramsOfCacao;
    }


    /**
     * Get list of all the capsules.
     * @return the name of the object
     */
    public ArrayList<Capsule> getCapsules() {
        return this.listOfCapsules;
    }


    /**
     * Fill the storage with all the products (amounts of products are fixed).
     */
    public void fillStorage() { //we fill the storage (all the amounts of products are fixed)
        this.listOfCapsules.clear(); //clear the list of capsules to have only a fixed amount of them
        this.millilitersOfMilk = TWOZEROZERO;
        this.gramsOfBeans = KUUZSERO;
        this.gramsOfCacao = FIVEZEROZERO;
        ArrayList<Drink> choiceOfDrinks = new ArrayList<>(); //make a list of all types of capsules
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.CACAO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.CAPPUCCINO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.ESPRESSO));
        choiceOfDrinks.add(new Drink(Drink.TypeOfDrink.LATTE));
        Random rand = new Random();
        for (int i = ZERO; i < ONEFIVE; i++) { //
            Capsule capsule = new Capsule(choiceOfDrinks.get(rand.nextInt(choiceOfDrinks.size()))); //randomly
                                                                                                // add a new capsule
            this.listOfCapsules.add(capsule);
        }
    }


    /**
     * Take milk from storage.
     *
     * @param millilitersOfMilk milk
     */
    public void takeMilkFromStorage(Integer millilitersOfMilk) {
        if (this.millilitersOfMilk >= millilitersOfMilk) {
            this.millilitersOfMilk -= millilitersOfMilk;
        }
    }


    /**
     * Take coffee beans from storage.
     *
     * @param gramsOfBeans beans
     */
    public void takeBeansFromStorage(Integer gramsOfBeans) {
        if (this.gramsOfBeans >= gramsOfBeans) {
            this.gramsOfBeans -= gramsOfBeans;
        }
    }


    /**
     * Take cacao from storage.
     * @return the name of the object
     *
     * @param gramsOfCacao cacao
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
     *
     * @param capsule capsule
     */
    public void takeCapsule(Capsule capsule) {
        this.listOfCapsules.remove(capsule);
    }


    /**
     * Check if storage is not empty.
     * @return the name of the object
     */
    public boolean isEmpty() {
        return this.gramsOfCacao == ZERO && this.gramsOfBeans == ZERO && this.millilitersOfMilk == ZERO;
    }


    /**
     * Get state of storage in a current time.
     * @return the name of the object
     */
    public String getStateOfStorage() {
        return "|||  Milliliters of Milk: " + this.millilitersOfMilk + "\n" + "Grams of Coffee beans: "
                + this.gramsOfBeans + "\n" + "Grams of Cacao: " + this.gramsOfCacao + "\n" + "Number of capsules: "
                + this.listOfCapsules.size() + " |||";
    }
}
