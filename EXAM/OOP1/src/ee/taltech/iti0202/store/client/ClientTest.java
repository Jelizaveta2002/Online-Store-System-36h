package ee.taltech.iti0202.store.client;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.CheapestProduct;
import ee.taltech.iti0202.store.storage.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testClientNameIsCorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Client.ClientBuilder("  ").age(19).money(345.9).strategy(new CheapestProduct()).build();
        }, "NAME SHOULD EXIST");

        assertThrows(IllegalArgumentException.class, () -> {
            new Client.ClientBuilder(null).age(19).money(345.9).strategy(new CheapestProduct()).build();
        }, "NAME SHOULD EXIST");
    }

    @Test
    void testClientAgeIsCorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Client.ClientBuilder("andrus").age(17).money(345.9).strategy(new CheapestProduct()).build();
        }, "AGE IS INCORRECT OR LESS THAN 18");
    }

    @Test
    void testClientMoneyIsCorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Client.ClientBuilder("dan").age(19).money(-300).strategy(new CheapestProduct()).build();
        }, "MONEY CAN NOT BE NEGATIVE");
    }

    @Test
    void testClientHasStrategy() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Client.ClientBuilder("dan").age(30).money(-300).strategy(null).build();
        }, "STRATEGY SHOULD EXIST");
    }

    @Test
    void testClientAddMoney() {
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(1000).strategy(new CheapestProduct()).build());
        client1.addMoney(56);
        assertEquals(client1.getMoney(), 1056);
        assertThrows(RuntimeException.class, () -> {
            client1.addMoney(-56);
        }, "AMOUNT OF MONEY CAN NOT BE CHANGED, AMOUNT IS NEGATIVE OR 0");
    }

    @Test
    void testCreateShoppingBag() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        FoodStore st2 = new FoodStore("store3", 400);
        st1.addProductFromStorage(pr1);
        st2.addProductFromStorage(pr2);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(1000).strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.createNewShoppingBag(st2);
        assertEquals(2, client1.getListOfShoppingBags().size()); //2 bags from different shops are created
        assertEquals(Optional.empty(), client1.createNewShoppingBag(st1)); //bag from this shop already exists
    }

    @Test
    void testBuyProductsFromBagSuccess() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD);
        ArrayList<Product> toCompare = new ArrayList<>();
        toCompare.add(pr1);
        toCompare.add(pr2);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(1000).strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false);
        assertEquals(client1.getProductsAndStores().get(st1), toCompare); // client has list of products as expected
        assertEquals(client1.getMoney(), 100); //1000 - 500 - 400 == 100
        assertEquals(st1.getProfit(), 1100); //200 + 400 + 500 == 1100
        assertEquals(client1.getStoreAndBonus().get(st1), 36); // 900 / 25 = 36 (bonusPoints in st1 store)
    }

    @Test
    void testBuyProductsFromBagFail() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(100).strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        assertThrows(RuntimeException.class, () -> {
            client1.buyProductsFromBag(st1, false);
        }, "CLIENT DOES NOT HAVE BAG IN THIS STORE OR MONEY IS NOT ENOUGH");
    }

    @Test
    void testBuyProductsFromBagUseBonusPoints() {
        Product pr1 = new Product("pr1", 1000, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 2000, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(4000).strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false); // make first order
        assertEquals(40, client1.getStoreAndBonus().get(st1)); //bonus after first order (1000 / 20 == 40)
        assertEquals(3000, client1.getMoney()); //4000-1000 == 3000
        st1.addProductFromStorage(pr2);
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, true);
        assertEquals(1002, client1.getMoney()); //paid using bonus points (3000 - (2000 + 40/20))
    }

    @Test
    void testDeleteShoppingBag() {
        Product pr1 = new Product("pr1", 1000, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 2000, Product.Type.FOOD);
        ArrayList<Product> toCompare = new ArrayList<>();
        toCompare.add(pr1);
        toCompare.add(pr2);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(4000).strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        assertEquals(toCompare, client1.getListOfShoppingBags().get(0).getListOfProductsToBuy()); //one bag is shoppingbag list
        client1.deleteShoppingBag(st1); // delete bag from list of bags
        assertTrue(client1.getListOfShoppingBags().isEmpty()); //list with bags is empty
        assertThrows(RuntimeException.class, () -> { // try to delete bag that does not exist, get error
            client1.deleteShoppingBag(st1);
        }, "NO BAG IN THIS STORE");
    }

    @Test
    void testShowProducts() {
        Product pr1 = new Product("pr1", 1000, Product.Type.FOOD);
        Product pr2 = new Product("pr2", 2000, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(4000).strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        client1.buyProductsFromBag(st1, false);
        String toCompare = "store: [Product{name='pr1', price=1000.0, type=FOOD, id=0}, Product{name='pr2', price=2000.0, type=FOOD, id=1}]";
        assertEquals(toCompare, client1.showProducts());
    }
}
