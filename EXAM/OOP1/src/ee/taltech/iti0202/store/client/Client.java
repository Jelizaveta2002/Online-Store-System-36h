package ee.taltech.iti0202.store.client;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.DepartmentStore;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.Strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Client {

    private String name;
    private Integer age;
    private Strategy strategy;
    private double money;
    private boolean isAdult;
    private HashMap<FoodStore, Long> storeAndBonus = new HashMap<>();
    private HashMap<FoodStore, ArrayList<Product>> productsAndStores = new HashMap<>();
    private ArrayList<Product> listOfAllProducts = new ArrayList<>();
    private ArrayList<ShoppingBag> listOfShoppingBags = new ArrayList<>();

    public Client(String name, Integer age, double money) {
        this.name = name;
        this.age = age;
        this.money = money;
        isAdult = age >= 18;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public ArrayList<ShoppingBag> getListOfShoppingBags() {
        return listOfShoppingBags;
    }

    public HashMap<FoodStore, ArrayList<Product>> getProductsAndStores() {
        return productsAndStores;
    }

    public HashMap<FoodStore, Long> getStoreAndBonus() {
        return storeAndBonus;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Create new shopping bag in a specific shop (this bag is filled according to the strategy that client has).
     *
     * @return Optional of bag.
     */
    public Optional<ShoppingBag> createNewShoppingBag(FoodStore store) {
        for (ShoppingBag bag : listOfShoppingBags) {
            if (bag.getStore().equals(store)) {
                return Optional.empty();
            }
        }
        ShoppingBag newBag = new ShoppingBag(this, store);
        newBag.addProductsToBag();
        listOfShoppingBags.add(newBag);
        return Optional.of(newBag);
    }

    /**
     * When bag is ready we use this function to pay for it (method buyProductFromBag uses it to calculate the whole-
     * price.)
     *
     */
    private void payForBag(ShoppingBag shoppingBag, long bonusToPay) {
        FoodStore store = shoppingBag.getStore();
        double counter = 0;
        long bonus = 0;
        for (Product product : shoppingBag.getListOfProductsToBuy()) {
            counter += product.getPrice();
        }
        store.getMoneyFromClient(counter);
        store.fillDataBase(this, shoppingBag.getListOfProductsToBuy());
        if (counter >= bonusToPay) {
            counter = counter - bonusToPay;
            storeAndBonus.replace(store, 0L);
        }
        bonus = Math.round(counter / 25.0);
        if (bonus == 0) {
            bonus = 1;
        }
        productsAndStores.put(store, shoppingBag.getListOfProductsToBuy());
        if (storeAndBonus.containsKey(store)) {
            storeAndBonus.replace(store, storeAndBonus.get(store) + bonus);
        }
        else {
            storeAndBonus.put(store, bonus);
        }
        money -= counter;
    }

    /**
     * When customer is ready to pay for order in a specific shop he/she uses this function.
     * If customer does not have a bag in this shop, throws exception error !!!!!!!!!!!
     *
     */
    public void buyProductsFromBag(FoodStore store, boolean useBonusPoints) {
        long bonus = 0;
        for (ShoppingBag bag : listOfShoppingBags) {
            if (bag.getStore().equals(store)) {
                if (useBonusPoints) {
                    bonus = storeAndBonus.get(store) / 20;
                }
                payForBag(bag, bonus);
                listOfShoppingBags.remove(bag);
                return;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(age, client.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
