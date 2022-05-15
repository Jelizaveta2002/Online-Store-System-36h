package ee.taltech.iti0202.store.client;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.Strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


public class Client {

    public static final int ADULT_AGE = 18;
    public static final int CONVERT_TO_BONUS = 25;
    public static final int CONVERT_TO_MONEY = 20;
    private String name;
    private Integer age;
    private Strategy strategy;
    private double money;
    private HashMap<FoodStore, Integer> storeAndBonus = new HashMap<>(); //just bonus points in shop
    private HashMap<FoodStore, ArrayList<Product>> productsAndStores = new HashMap<>();
    private ArrayList<Product> listOfAllProducts = new ArrayList<>();
    private ArrayList<ShoppingBag> listOfShoppingBags = new ArrayList<>();

    public Client(ClientBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.money = builder.money;
        this.strategy = builder.strategy;
    }

    public static class ClientBuilder {
        private String name;
        private Integer age;
        private double money;
        private Strategy strategy;

        public ClientBuilder(String name) {
            this.name = name;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder age(int age) {
            this.age = age;
            return this;
        }

        public ClientBuilder money(double money) {
            this.money = money;
            return this;
        }

        public ClientBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Client build() {
            if (this.name == null || this.name.trim().isEmpty()) {
                throw new IllegalArgumentException("NAME SHOULD EXIST");
            }
            if (this.age == null || this.age < ADULT_AGE) {
                throw new IllegalArgumentException("AGE IS INCORRECT OR LESS THAN 18");
            }
            if (this.strategy == null) {
                throw new IllegalArgumentException("STRATEGY SHOULD EXIST");
            }
            if (this.money < 0) {
                throw new IllegalArgumentException("MONEY CAN NOT BE NEGATIVE");
            }
            return new Client(this);
        }
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

    public Strategy getStrategy() {
        return strategy;
    }

    public ArrayList<ShoppingBag> getListOfShoppingBags() {
        return listOfShoppingBags;
    }

    public HashMap<FoodStore, ArrayList<Product>> getProductsAndStores() {
        return productsAndStores;
    }

    public HashMap<FoodStore, Integer> getStoreAndBonus() {
        return storeAndBonus;
    }

    /**
     *
     * @param summa
     */
    public void addMoney(double summa) {
        if (summa <= 0) {
            throw new RuntimeException("AMOUNT OF MONEY CAN NOT BE CHANGED, AMOUNT IS NEGATIVE OR 0");
        } else  {
            money += summa;
        }
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     *
     * @param store
     * @return
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
     *
     * @param shoppingBag
     * @param bonusToPay
     */
    private void payForBag(ShoppingBag shoppingBag, int bonusToPay) {
        FoodStore store = shoppingBag.getStore();
        double counter = 0;
        int bonus = 0;
        for (Product product : shoppingBag.getListOfProductsToBuy()) { //count total sum of all products in bag
            counter += product.getPrice();
        }
        store.getMoneyFromClient(counter); //add money to store
        store.fillDataBase(this, shoppingBag.getListOfProductsToBuy()); // add client and order to database
        if (bonusToPay > 0) {
            if (convertPointsToMoney(bonusToPay) >= counter) {
                storeAndBonus.put(store, storeAndBonus.get(store) - convertMoneyToPoints((int) counter));
                counter = 0;
            } else {
                counter = counter - convertPointsToMoney(bonusToPay);
                storeAndBonus.put(store, 0);
            }
        }
        money -= counter; // get money from client
        bonus = (int) counter / CONVERT_TO_BONUS;
        if (bonus == 0) {
            bonus = 1;
        }
        if (productsAndStores.containsKey(store)) { // if client already bought in this shop
            productsAndStores.get(store).addAll(shoppingBag.getListOfProductsToBuy());
        } else {
            productsAndStores.put(store, shoppingBag.getListOfProductsToBuy()); //if a new shop for this client
        }
        if (storeAndBonus.containsKey(store)) {
            storeAndBonus.replace(store, storeAndBonus.get(store) + bonus); // add bonus points
                                                                            // if store already was used
        } else {
            storeAndBonus.put(store, bonus); // add points if a new store
        }
    }

    /**
     *
     * @param bonusPoints
     * @return
     */
    private int convertPointsToMoney(int bonusPoints) {
        return bonusPoints / CONVERT_TO_MONEY;
    }

    /**
     *
     * @param moneyBonus
     * @return
     */
    private int convertMoneyToPoints(int moneyBonus) {
        return moneyBonus * CONVERT_TO_MONEY;
    }

    /**
     *
     * @param store
     * @param useBonusPoints
     */
    public void buyProductsFromBag(FoodStore store, boolean useBonusPoints) {
        int bonus = 0;
        for (ShoppingBag bag : listOfShoppingBags) {
            if (bag.getStore().equals(store) && bag.countTotalSum() <= money) {
                if (!bag.getListOfProductsToBuy().isEmpty()) {
                    if (useBonusPoints && storeAndBonus.containsKey(store)) {
                        bonus = storeAndBonus.get(store);
                    }
                    payForBag(bag, bonus);
                    listOfShoppingBags.remove(bag);
                    return;
                } else {
                    throw new RuntimeException("BAG IS EMPTY !");
                }
            }
        }
        throw new RuntimeException("CLIENT DOES NOT HAVE BAG IN THIS STORE OR MONEY IS NOT ENOUGH");
    }

    /**
     *
     * @param store
     */
    public void deleteShoppingBag(FoodStore store) {
        ArrayList<ShoppingBag> toIterate = new ArrayList<>(listOfShoppingBags);
        for (ShoppingBag bag : toIterate) {
            if (bag.getStore().equals(store)) {
                store.getListOfProducts().addAll(bag.getListOfProductsToBuy()); //return products back to shop from bag
                listOfShoppingBags.remove(bag);
                return;
            }
        }
        throw new RuntimeException("NO BAG IN THIS STORE");
    }

    /**
     *
     * @return
     */
    public String showProducts() {
        StringBuilder toReturn = new StringBuilder();
        int counter = 0;
        for (FoodStore store : productsAndStores.keySet()) {
            counter += 1;
            toReturn.append(store.getName());
            toReturn.append(": ");
            toReturn.append(productsAndStores.get(store).toString());
            if (productsAndStores.size() != counter) {
                toReturn.append("\n");
            }
        }
        return toReturn.toString();
    }


    @Override
    public String toString() {
        return "Client{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
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
