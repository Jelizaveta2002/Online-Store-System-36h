package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.startegy.CheapestProduct;
import ee.taltech.iti0202.store.storage.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FoodStoreTest {

    @Test
    void testAddProductFromStorage() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 600, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        assertEquals(Optional.empty(), st1.addProductFromStorage(pr3));
                                                        //product is not in storage, it can not be added
        assertEquals(2, st1.listOfProducts.size()); //only 2 products can be added from storage
        assertTrue(Storage.getInstance().getListOfProducts().isEmpty()); //now storage is empty
    }

    @Test
    void testAddListOfProductsFromStorage() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 600, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductsFromStorage(toAdd);
        assertEquals(st1.listOfProducts.size(), 2);
                        //length is , because only 2 products are added (pr3 is not in Storage)
        toAdd.clear();
        assertThrows(RuntimeException.class, () -> {
            st1.addProductsFromStorage(toAdd); //list is empty, so we get error
        }, "LIST OF PRODUCTS IS EMPTY");
    }

    @Test
    void testRemoveProductsFromStore() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 600, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        FoodStore st1 = new FoodStore("store", 200);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        st1.addProductsFromStorage(toAdd);
        st1.removeSeveralProducts(toAdd);
        assertTrue(st1.getListOfProducts().isEmpty()); //successfully removed products
        assertThrows(RuntimeException.class, () -> {
            st1.removeSeveralProducts(toAdd); //list is empty, so we get error
        }, "LIST OF PRODUCTS IS EMPTY");
    }

    @Test
    void testFindProductByName() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 600, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        FoodStore st1 = new FoodStore("store", 200);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        st1.addProductsFromStorage(toAdd);
        List<Product> toCompare = List.of(pr1, pr2);
        assertEquals(st1.findProductByName("pr1"), Optional.of(toCompare));
    }


    @Test
    void testFindProductByPrice() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        FoodStore st1 = new FoodStore("store", 200);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        st1.addProductsFromStorage(toAdd);
        List<Product> toCompare = List.of(pr2, pr3);
        assertEquals(st1.findProductByPrice(500), Optional.of(toCompare));
    }

    @Test
    void testFindProductById() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        FoodStore st1 = new FoodStore("store", 200);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        st1.addProductsFromStorage(toAdd);
        assertEquals(st1.findProductById(12), Optional.of(pr2));
    }

    @Test
    void testFillDataBase() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        FoodStore st1 = new FoodStore("store", 200);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        st1.addProductsFromStorage(toAdd);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(4000)
                .strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false);
        HashMap<Client, ArrayList<Product>> mapToPut = new HashMap<>();
        mapToPut.put(client1, toAdd);
        assertEquals(st1.getDataBase(), mapToPut);
    }

    @Test
    void testReturnProductBackFood() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(4000)
                .strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false);
        assertThrows(RuntimeException.class, () -> {
            st1.returnProductBack(client1, pr1); //food can not be refunded
        }, "CAN NOT RETURN FOOD!");
    }

    @Test
    void testReturnProductBackCosmetics() {
        Product pr1 = new Product("pr1", 500, Product.Type.COSMETICS);
        Storage.getInstance().addProduct(pr1);
        DepartmentStore st1 = new DepartmentStore("store", 200);
        st1.addProductFromStorage(pr1);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(4000)
                .strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false);
        assertEquals(client1.getMoney(), 3500); //amount of money after order
        st1.returnProductBack(client1, pr1);
        assertEquals(client1.getMoney(), 4000); //amount of money after refund
    }

    @Test
    void testAddClients() {
        Product pr1 = new Product("pr1", 500, Product.Type.COSMETICS);
        Product pr2 = new Product("pr2", 400, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        DepartmentStore st1 = new DepartmentStore("store", 200);
        st1.addProductFromStorage(pr1);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(600)
                .strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false);
        assertEquals(st1.showClients(), "Client{name='anna', age=19}\n");
        assertThrows(RuntimeException.class, () -> {
            st1.addClient(client1); //client is already added
        }, "CLIENT IS ALREADY ADDED");
    }

    @Test
    void testShowProducts() {
        Product pr1 = new Product("pr1", 500, Product.Type.COSMETICS);
        Product pr2 = new Product("pr2", 400, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        DepartmentStore st1 = new DepartmentStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        assertEquals(st1.showProducts(), "Product{name='pr1', price=500.0, type=COSMETICS, id=0}\n"
                + "Product{name='pr2', price=400.0, type=FOOD, id=1}\n");
    }
}
