package ee.taltech.iti0202.store.startegy;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;

import java.util.ArrayList;

public interface Strategy {

    ArrayList<Product> addProductToBag(ArrayList<Product> productsInStore, double money, FoodStore store);
}
