package ee.taltech.iti0202.store.storage;

import ee.taltech.iti0202.store.product.Product;

import java.util.ArrayList;

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

    /**
     *
     * @param product
     */
    public void addProduct(Product product) {
        if (!listOfProducts.contains(product)) {
            listOfProducts.add(product);
        } else {
            throw new IllegalArgumentException("PRODUCT IS ALREADY IN STORAGE");
        }
    }

    /**
     *
     * @param listWithProductsToAdd
     */
    public void addSeveralProducts(ArrayList<Product> listWithProductsToAdd) {
        for (Product product : listWithProductsToAdd) {
            addProduct(product);
        }
    }

    /**
     *
     * @param product
     */
    public void removeSingleProduct(Product product) {
        if (listOfProducts.contains(product)) {
            listOfProducts.remove(product);
        } else {
            throw new IllegalArgumentException("PRODUCT IS NOT IN THE STORAGE");
        }
    }

    /**
     *
     * @param listWithProductsToDelete
     */
    public void removeSeveralProducts(ArrayList<Product> listWithProductsToDelete) {
        for (Product product : listWithProductsToDelete) {
            removeSingleProduct(product);
        }
    }
}
