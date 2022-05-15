package ee.taltech.iti0202.store.startegy;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;

import java.util.ArrayList;

public class DifferentTypes implements Strategy {

    @Override
    public ArrayList<Product> addProductToBag(ArrayList<Product> productsInStore, double money, FoodStore store) {
        double totalPriceCounter = 0;
        ArrayList<Product> listToIterate = new ArrayList<>(productsInStore);
        ArrayList<Product> listToReturn = new ArrayList<>();
        ArrayList<Product.Type> listOfAllTypes = new ArrayList<>();
        for (Product product : listToIterate) {
            if (!listOfAllTypes.contains(product.getType()) && (totalPriceCounter + product.getPrice()) < money) {
                listToReturn.add(product);
                store.removeSingleProduct(product);
                listOfAllTypes.add(product.getType());
            }
        }
        return listToReturn;
    }
}
