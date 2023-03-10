package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;


public class FoodStore {

    protected String name;
    protected double profit;
    protected ArrayList<Product> listOfProducts = new ArrayList<>();
    protected ArrayList<Client> listOfClients = new ArrayList<>();
    protected HashMap<Client, ArrayList<Product>> dataBase = new HashMap<>();

    public FoodStore(String name, Integer profit) {
        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public double getProfit() {
        return profit;
    }

    public ArrayList<Product> getListOfProducts() {
        return listOfProducts;
    }

    public ArrayList<Client> getListOfClients() {
        return listOfClients;
    }

    public HashMap<Client, ArrayList<Product>> getDataBase() {
        return dataBase;
    }

    /**
     *
     * Add products to the store from the storage.
     * If product is not in storage, it can not be added.
     *
     * @param product
     * @return
     */
    public Optional<Product> addProductFromStorage(Product product) {
        if (!listOfProducts.contains(product) && product.getType().equals(Product.Type.FOOD)
                && Storage.getInstance().getListOfProducts().contains(product)) {
            listOfProducts.add(product);
            Storage.getInstance().removeSingleProduct(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    /**
     *
     * Add several projects from storage.
     *
     * @param listWithProductsToAdd
     */
    public void addProductsFromStorage(ArrayList<Product> listWithProductsToAdd) {
        ArrayList<Product> listOfProductsInStorage = Storage.getInstance().getListOfProducts();
        if (listWithProductsToAdd.isEmpty()) {
            throw new RuntimeException("LIST OF PRODUCTS IS EMPTY");
        }
        for (Product product : listWithProductsToAdd) {
            addProductFromStorage(product);
        }
    }

    /**
     *
     * Remove single product from store.
     *
     * @param product
     */
    public void removeSingleProduct(Product product) {
        if (listOfProducts.contains(product)) {
            listOfProducts.remove(product);
        } else {
            throw new RuntimeException("NO SUCH PRODUCT");
        }
    }

    /**
     *
     * Remove several projects from store.
     *
     * @param listWithProductsToRemove
     */
    public void removeSeveralProducts(ArrayList<Product> listWithProductsToRemove) {
        if (listWithProductsToRemove.isEmpty()) {
            throw new RuntimeException("LIST OF PRODUCTS IS EMPTY");
        }
        for (Product product : listWithProductsToRemove) {
            removeSingleProduct(product);
        }
    }

    /**
     *
     * Find list of products with a specific name.
     *
     * @param name
     * @return
     */
    public Optional<ArrayList<Product>> findProductByName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            ArrayList<Product> productsNeeded = new ArrayList<>();
            for (Product product: listOfProducts) {
                if (product.getName().equals(name)) {
                    productsNeeded.add(product);
                }
            }
            if (!productsNeeded.isEmpty()) {
                return Optional.of(productsNeeded);
            }
        }
        return Optional.empty();
    }

    /**
     *
     * Find list of products with a specific price.
     *
     * @param price
     * @return
     */
    public Optional<ArrayList<Product>> findProductByPrice(double price) {
        if (price > 0) {
            ArrayList<Product> productsNeeded = new ArrayList<>();
            for (Product product: listOfProducts) {
                if (product.getPrice() == price) {
                    productsNeeded.add(product);
                }
            }
            if (!productsNeeded.isEmpty()) {
                return Optional.of(productsNeeded);
            }
        }
        return Optional.empty();
    }

    /**
     *
     * Find product in list of products by id.
     *
     * @param id
     * @return
     */
    public Optional<Product> findProductById(Integer id) {
        if (id > 0) {
            for (Product product : listOfProducts) {
                if (product.getId().equals(id)) {
                    return Optional.of(product);
                }
            }
        }
        return Optional.empty();
    }

    /**
     *
     * Get money from client after the order.
     *
     * @param money
     */
    public void getMoneyFromClient(double money) {
        if (money <= 0) {
            throw new RuntimeException("AMOUNT OF MONEY CAN NOT BE CHANGED, AMOUNT IS NEGATIVE OR 0");
        } else {
            profit += money;
        }
    }

    /**
     *
     * Add new client if it is possible.
     *
     * @param client
     */
    public void addClient(Client client) {
        if (!listOfClients.contains(client)) {
            listOfClients.add(client);
        } else {
            throw new RuntimeException("CLIENT IS ALREADY ADDED");
        }
    }

    /**
     *
     * Fill map where client is a key and list with all the products, that he/she bought is a value.
     * After refund product is taken away from database.
     *
     * @param client
     * @param listOfProducts
     */
    public void fillDataBase(Client client, ArrayList<Product> listOfProducts) {
        if (dataBase.containsKey(client)) {
            ArrayList<Product> newListOfProducts = dataBase.get(client);
            newListOfProducts.addAll(listOfProducts);
            dataBase.replace(client, newListOfProducts);
        } else {
            dataBase.put(client, listOfProducts);
            listOfClients.add(client);
        }
    }

    /**
     *
     * Return the product if it is possible.
     *
     * @param client
     * @param product
     */
    public void returnProductBack(Client client, Product product) {
        throw new RuntimeException("CAN NOT RETURN FOOD!");
    }

    /**
     *
     * Show all the current clients.
     *
     * @return
     */
    public String showClients() {
        StringBuilder toReturn = new StringBuilder();
        int counter = -1;
        for (Client client : listOfClients) {
            counter += 1;
            toReturn.append(client.toString());
            if (listOfClients.size() != counter) {
                toReturn.append("\n");
            }
        }
        return toReturn.toString();
    }

    /**
     *
     * Show all the current products.
     *
     * @return
     */
    public String showProducts() {
        StringBuilder toReturn = new StringBuilder();
        int counter = -1;
        for (Product product : listOfProducts) {
            counter += 1;
            toReturn.append(product.toString());
            if (listOfProducts.size() != counter) {
                toReturn.append("\n");
            }
        }
        return toReturn.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodStore foodStore = (FoodStore) o;
        return Objects.equals(name, foodStore.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
