package ee.taltech.iti0202.store.client;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.Strategy;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class ShoppingBag {

    private ArrayList<Product> listOfProductsToBy = new ArrayList<>();
    private Client client;
    private FoodStore store;

    /**
     *
     * This class is covered by tests in another test classes by using different tests (such as createShoppingBag).
     *
     * @param client
     * @param store
     */
    public ShoppingBag(Client client, FoodStore store) {
        this.client = client;
        this.store = store;
    }

    public Client getClient() {
        return client;
    }

    public FoodStore getStore() {
        return store;
    }

    public ArrayList<Product> getListOfProductsToBuy() {
        return listOfProductsToBy;
    }

    /**
     * The aim of this method is to fill bag of products according to the strategy tht client has.
     * This method works automatically when client creates a new shopping bag.
     *
     * @return Optional of ArrayList filled with Products.
     */
    protected Optional<ArrayList<Product>> addProductsToBag() {
        ArrayList<Product> productsInStore = store.getListOfProducts();
        double money = client.getMoney();
        Strategy strategyToUse = client.getStrategy();
        listOfProductsToBy = strategyToUse.addProductToBag(productsInStore, money, store);
        if (!listOfProductsToBy.isEmpty()) {
            return Optional.of(listOfProductsToBy);
        }
        return Optional.empty();
    }

    /**
     * Get the total sum of the whole bag.
     * Use to be sure that client is able to pay for bag
     * @return
     */
    public int countTotalSum() {
        int counter = 0;
        for (Product product : listOfProductsToBy) {
            counter += product.getPrice();
        }
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingBag that = (ShoppingBag) o;
        return Objects.equals(client, that.client) && Objects.equals(store, that.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, store);
    }
}
