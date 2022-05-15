package ee.taltech.iti0202.store.storage;

import ee.taltech.iti0202.store.product.Product;

import java.util.ArrayList;
import java.util.Optional;

public final class Storage {
    private final ArrayList<Product> listOfProducts = new ArrayList<>();
    private static Storage instance = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public void addProduct(Product product) {
        if (!listOfProducts.contains(product)) {
            listOfProducts.add(product);
        }
        else {
            throw new IllegalArgumentException("PRODUCT IS ALREADY IN STORAGE");
        }
    }

    public void addSeveralProducts(ArrayList<Product> listWithProductsToAdd) {
        for (Product product : listWithProductsToAdd) {
            addProduct(product);
        }
    }

    public void removeSingleProduct(Product product) {
        if (listOfProducts.contains(product)) {
            listOfProducts.remove(product);
        }
        else {
            throw new IllegalArgumentException("PRODUCT IS NOT IN THE STORAGE");
        }
    }

    public void removeSeveralProducts(ArrayList<Product> listWithProductsToDelete) {
        for (Product product : listWithProductsToDelete) {
            removeSingleProduct(product);
        }
    }

    public static void main(String[] args) {
        Product pr1 = new Product("pr1", 12, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 12, Product.Type.COSMETICS);
        Product pr3 = new Product("  ", 12, Product.Type.COSMETICS);
        getInstance().addProduct(pr1);
        getInstance().addProduct(pr2);
        getInstance().addProduct(pr3);
        getInstance().addProduct(pr2);
        System.out.println(getInstance().getListOfProducts());
    }


}
