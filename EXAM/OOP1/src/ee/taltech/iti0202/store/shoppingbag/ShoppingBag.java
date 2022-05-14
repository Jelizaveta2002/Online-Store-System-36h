package ee.taltech.iti0202.store.shoppingbag;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.Strategy;

import java.util.ArrayList;
import java.util.Optional;

public class ShoppingBag {

    private ArrayList<Product> listOfProductsToBy = new ArrayList<>();
    private Client client;
    private FoodStore store;

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

    public Optional<ArrayList<Product>> addProductsToBag() {
        ArrayList<Product> productsInStore = store.getListOfProducts();
        double money = client.getMoney();
        Strategy strategyToUse = client.getStrategy();
        listOfProductsToBy = strategyToUse.addProductToBag(productsInStore, money, store);
        if (!listOfProductsToBy.isEmpty()) {
            return Optional.of(listOfProductsToBy);
        }
        return Optional.empty();
    }


}
