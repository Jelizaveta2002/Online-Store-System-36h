package ee.taltech.iti0202.store.startegy;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CheapestProduct implements Strategy {
    @Override
    public ArrayList<Product> addProductToBag(ArrayList<Product> productsInStore, double money, FoodStore store) {
        double totalPriceCounter = 0;
        ArrayList<Product> listToReturn = new ArrayList<>();
        ArrayList<Product.Type> listOfTypes = new ArrayList<>();
        ArrayList<String> listOfNames = new ArrayList<>();
        List<Product> newList = new ArrayList<>(productsInStore)
                .stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)).toList();
        for (Product product : newList) {
            if ((!listOfTypes.contains(product.getType()) && !listOfNames.contains(product.getName())) && (totalPriceCounter + product.getPrice()) < money) {
                listToReturn.add(product);
                store.removeSingleProduct(product);
                listOfNames.add(product.getName());
                listOfTypes.add(product.getType());
            }
        }
        return listToReturn;
    }
}
