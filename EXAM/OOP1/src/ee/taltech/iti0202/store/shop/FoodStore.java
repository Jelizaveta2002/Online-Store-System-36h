package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.storage.Storage;

import java.util.*;

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

    public Optional<Product> addProductFromStorage(Product product) {
        ArrayList<Product> listOfProductsInStorage = Storage.getInstance().getListOfProducts();
        if (!listOfProducts.contains(product) && product.getType().equals(Product.Type.FOOD)) {
            listOfProducts.add(product);
            Storage.getInstance().removeSingleProduct(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public void addProductsFromStorage(ArrayList<Product> listWithProductsToAdd) {
        ArrayList<Product> listOfProductsInStorage = Storage.getInstance().getListOfProducts();
        if (listWithProductsToAdd.isEmpty()) {
            throw new RuntimeException("LIST OF PRODUCTS IS EMPTY");
        }
        for (Product product : listWithProductsToAdd) {
            addProductFromStorage(product);
        }
    }

    public void removeSingleProduct(Product product) {
        if (listOfProducts.contains(product)) {
            listOfProducts.remove(product);
        }
        else {
            throw new RuntimeException("NO SUCH PRODUCT");
        }
    }

    public void removeSeveralProducts(ArrayList<Product> listWithProductsToRemove) {
        if (listWithProductsToRemove.isEmpty()) {
            throw new RuntimeException("LIST OF PRODUCTS IS EMPTY");
        }
        for (Product product : listWithProductsToRemove) {
            removeSingleProduct(product);
        }
    }

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

    public void getMoneyFromClient(double money) {
        if (money <= 0) {
            throw new RuntimeException("AMOUNT OF MONEY CAN NOT BE CHANGED, AMOUNT IS NEGATIVE OR 0");
        }
        else {
            profit += money;
        }
    }

    public void addClient(Client client) {
        if (!listOfClients.contains(client)) {
            listOfClients.add(client);
        }
        else {
            throw new RuntimeException("CLIENT IS ALREADY ADDED");
        }
    }

    /**
     * This method is needed in order to remember what kind of orders was done by a specific client.
     *
     */
    public void fillDataBase(Client client, ArrayList<Product> listOfProducts) {
        if (dataBase.containsKey(client)) {
            ArrayList<Product> newListOfProducts = dataBase.get(client);
            newListOfProducts.addAll(listOfProducts);
            dataBase.replace(client, newListOfProducts);
        }
        else {
            dataBase.put(client, listOfProducts);
            listOfClients.add(client);
        }
    }

    public void returnProductBack(Client client, Product product) {
        throw new RuntimeException("CAN NOT RETURN FOOD!");
    }

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

    public static void main(String[] args) {
        FoodStore st1 = new FoodStore("store", 234);
        Product pr1 = new Product("pr1", 12, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 12, Product.Type.FOOD);
        Product pr3 = new Product("  ", 12, Product.Type.COSMETICS);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        System.out.println(st1.getListOfProducts().get(1).getId());
    }
}
