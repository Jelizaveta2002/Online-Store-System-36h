package ee.taltech.iti0202.store.client;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.DepartmentStore;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.shoppingbag.ShoppingBag;
import ee.taltech.iti0202.store.startegy.Strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Client {

    private String name;
    private Integer age;
    private Strategy strategy;
    private double money;
    private boolean isAdult;
    private HashMap<DepartmentStore, Integer> storeAndBonus = new HashMap<>();
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

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Optional<ShoppingBag> createNewShoppingBag(FoodStore store) {
        for (ShoppingBag bag : listOfShoppingBags) {
            if (bag.getStore().getName().equals(store.getName())) {
                return Optional.empty();
            }
        }
        ShoppingBag newBag = new ShoppingBag(this, store);
        newBag.addProductsToBag();
        listOfShoppingBags.add(newBag);
        return Optional.of(newBag);
    }

    private void payForBag(ShoppingBag shoppingBag) {
        double counter = 0;
        for (Product product : shoppingBag.getListOfProductsToBuy()) {
            counter += product.getPrice();
        }
        productsAndStores.put(shoppingBag.getStore(), shoppingBag.getListOfProductsToBuy());
        money -= counter;
        shoppingBag.getStore().getMoneyFromClient(counter);
    }

    public void buyProductsFromBag(FoodStore store) {
        for (ShoppingBag bag : listOfShoppingBags) {
            if (bag.getStore().equals(store)) {
                payForBag(bag);
                listOfShoppingBags.remove(bag);
                return;
            }
        }
    }

}
