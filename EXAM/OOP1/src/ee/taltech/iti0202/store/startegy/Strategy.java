package ee.taltech.iti0202.store.startegy;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;

import java.util.ArrayList;

public interface Strategy {

    /**
     *
     * Fill the bag with products considering the algorithm of a specific strategy.
     *
     * @param productsInStore
     * @param money
     * @param store
     * @return
     */
    ArrayList<Product> addProductToBag(ArrayList<Product> productsInStore, double money, FoodStore store);
}
