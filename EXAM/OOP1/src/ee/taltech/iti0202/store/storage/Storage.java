package ee.taltech.iti0202.store.storage;

import ee.taltech.iti0202.store.product.Product;

import java.util.ArrayList;

public final class Storage {
    private final ArrayList<Product> listOfProducts = new ArrayList<>();
    private static Storage instance = null;

    /**
     *
     * Storage is made for holding all the new products.
     * Product can be added to store only if it located in storage.
     * After appearing in shop product disappears from storage.
     * The aim of the storage is to make sure that the same product can not exist in several stores.
     *
     */
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
     * Add single product.
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
     * Add several products.
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
     * Remove single products.
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
     * Remove several products.
     *
     * @param listWithProductsToDelete
     */
    public void removeSeveralProducts(ArrayList<Product> listWithProductsToDelete) {
        for (Product product : listWithProductsToDelete) {
            removeSingleProduct(product);
        }
    }
}
