package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.storage.Storage;
import org.junit.jupiter.api.Test;

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
        assertEquals(Optional.empty(), st1.addProductFromStorage(pr3)); //product is not in storage, it can not be added
        assertEquals(2, st1.listOfProducts.size()); //only 2 products can be added from storage
        assertTrue(Storage.getInstance().getListOfProducts().isEmpty()); //now storage is empty
    }

    @Test
    void getProfit() {
    }

    @Test
    void getListOfProducts() {
    }

    @Test
    void getListOfClients() {
    }

    @Test
    void getDataBase() {
    }

    @Test
    void addProductFromStorage() {
    }
}