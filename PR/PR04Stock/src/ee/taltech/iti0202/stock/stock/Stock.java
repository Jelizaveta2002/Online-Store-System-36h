package ee.taltech.iti0202.stock.stock;
import ee.taltech.iti0202.stock.exceptions.StockException;
import ee.taltech.iti0202.stock.product.Product;

import java.util.*;

/**
 * The stock class.
 * <p>
 * Each stock has a name, list of products that are currently stored in it
 * and the maximum amount of products that stock can store.
 * <p>
 * If adding a product to the stock is not possible, due to exceeding the maximum limit of products
 * OR stock already contains a product, a StockException must be thrown,
 * otherwise product must be added to the stock.
 * <p>
 * When getting (not removing) a product from our stock,
 * it is important to find the product with the lowest price first.
 */

public class Stock {
    private final String name;
    private final int maxCapacity;
    private final ArrayList<Product> listOfProducts = new ArrayList<>();

    /**
     * Create a new stock with the given name and the max capacity for the products.
     *
     * @param name the name of the stock.
     * @param maxCapacity max amount of products allowed in the stock.
     */
    public Stock(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    /**
     * Add a product to the stock, if stock does not contain the product and is not full yet.
     * <p>
     * Check in following order:
     * If stock already contains a product, throw an StockException with a STOCK_ALREADY_CONTAINS_PRODUCT reason.
     * If stock is full, throw a StockException with a STOCK_IS_FULL reason.
     *
     * @param product to be added
     * @throws StockException STOCK_ALREADY_CONTAINS_PRODUCT, STOCK_IS_FULL
     */
    public void addProduct(Product product) throws StockException {
        if (listOfProducts.isEmpty() && this.maxCapacity > 0) {
            listOfProducts.add(product);
        }
        else {
            if (ifContainsProduct(listOfProducts, product)) {
                throw new StockException(StockException.Reason.STOCK_ALREADY_CONTAINS_PRODUCT);
            } else if (isFull()) {
                throw new StockException(StockException.Reason.STOCK_IS_FULL);
            }
            else {
                listOfProducts.add(product);
            }
        }
    }

    /**
     * Create a new stock with the given name and the max capacity for the products.
     *
     * @param list the name of the stock.
     * @param product max amount of products allowed in the stock.
     */
    public boolean ifContainsProduct(ArrayList<Product> list, Product product) {
        for (Product pr : listOfProducts) {
            if (pr.getName().equals(product.getName()) && pr.getPrice() == product.getPrice() && pr.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a product from a stock by name with the lowest price.
     *
     * If there are several products with the same name and price,
     * returns the product with the lowest id.
     *
     * @param name the product's name
     * @return Optional
     */
    public Optional<Product> getProduct(String name) {
        if (!listOfProducts.isEmpty()) {
            ArrayList<Product> storageByName = new ArrayList<>();
            ArrayList<Integer> storageByPrice = new ArrayList<>();
            ArrayList<Integer> storageById = new ArrayList<>();
            ArrayList<Product> storageByPrice2 = new ArrayList<>();
            for (Product product : listOfProducts) {
                if (Objects.equals(product.getName(), name)) {
                    storageByName.add(product);
                }
            }
            if (!storageByName.isEmpty()) {
                for (Product product : storageByName) {
                    storageByPrice.add(product.getPrice());
                }
                int minPrice = Collections.min(storageByPrice);
                for (Product product : storageByName) {
                    if (product.getPrice() == minPrice) {
                        storageByPrice2.add(product);
                    }
                }
                for (Product product : storageByPrice2) {
                    storageById.add(product.getId());
                }
                int minId = Collections.min(storageById);
                for (Product product : storageByPrice2) {
                    if (product.getId() == minId) {
                        return Optional.of(product);
                    }
                }
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    /**
     * Remove and return a product from a stock,
     * if stock has a given product.
     *
     * Use getProduct() method to get the product.
     *
     * If there is nothing to remove, return Optional.empty()
     *
     * @param name Name of the product to be removed
     * @return Optional
     */

    public Optional<Product> removeProduct(String name) {
        if (!listOfProducts.isEmpty()) {
            if (getProduct(name).isPresent()) {
                Product product = getProduct(name).get();
                for (Product pr : listOfProducts) {
                    if (pr.getName().equals(product.getName()) && pr.getPrice() == product.getPrice() && pr.getId() == product.getId()) {
                        listOfProducts.remove(pr);
                        return Optional.of(pr);
                    }
                }
                return Optional.empty();
            }
            return Optional.empty();
        }
        return Optional.empty();
    }

    /**
     * Get a list of current products in the stock.
     *
     * @return List
     */
    public List<Product> getProducts() {
        System.out.println(listOfProducts);
        return listOfProducts;
    }

    /**
     * Get a list of current products in the stock filtered by name.
     *
     * Order the products by price ascending. In case of the same price, by id ascending.
     *
     * @param name Name to be filtered.
     * @return List
     */
    public List<Product> getProducts(String name) {
        ArrayList<Product> storageOfProductsByName = new ArrayList<>();
        if (!listOfProducts.isEmpty()) {
            for (Product product : listOfProducts) {
                if (product.getName().equals(name)) {
                    storageOfProductsByName.add(product);
                }
            }
            return storageOfProductsByName;
        }
        return storageOfProductsByName;
    }

    /**
     * Get total price of all the products.
     *
     * @return Total price.
     */
    public int getTotalPrice() {
        int totalPrice = 0;
        if (!listOfProducts.isEmpty()) {
            for (Product product : listOfProducts) {
                totalPrice += product.getPrice();
            }
            return totalPrice;
        }
        return totalPrice;
    }

    /**
     * Check if stock is full.
     *
     * @return boolean
     */
    public boolean isFull() {
        return listOfProducts.size() == maxCapacity;
    }

}
