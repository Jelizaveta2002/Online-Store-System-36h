package ee.taltech.iti0202.store.startegy;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.DepartmentStore;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.storage.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StrategyTest {

    @Test
    void testCheapestProductStrategy() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD); //already in bag
        Product pr2 = new Product("pr2", 500, Product.Type.FOOD); //2
        Product pr3 = new Product("pr1", 300, Product.Type.FOOD); //1
        Product pr4 = new Product("pr5", 900, Product.Type.FOOD); //3
        ArrayList<Product> toCompare = new ArrayList<>();
        toCompare.add(pr3);
        toCompare.add(pr2);
        toCompare.add(pr4);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        Storage.getInstance().addProduct(pr4);
        FoodStore st1 = new FoodStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        st1.addProductFromStorage(pr3);
        st1.addProductFromStorage(pr4);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(3000)
                .strategy(new CheapestProduct()).build());
        client1.createNewShoppingBag(st1);
        assertEquals(client1.getListOfShoppingBags().get(0).getListOfProductsToBuy(), toCompare);
        //{pr3, pr2, pr4} because firstly
        //goes cheapest product but if product with the same type already exists, so goes next
    }

    @Test
    void testDifferentTypes() {
        Product pr1 = new Product("pr1", 400, Product.Type.COSMETICS);
        Product pr2 = new Product("pr2", 500, Product.Type.COSMETICS); //can not be added
        Product pr3 = new Product("pr1", 300, Product.Type.FOOD);
        Product pr4 = new Product("pr5", 900, Product.Type.GARDENGOODS);
        Product pr5 = new Product("pr5", 900, Product.Type.COSMETICS); //can not be added
        ArrayList<Product> toCompare = new ArrayList<>();
        toCompare.add(pr1);
        toCompare.add(pr3);
        toCompare.add(pr4);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        Storage.getInstance().addProduct(pr4);
        Storage.getInstance().addProduct(pr5);
        DepartmentStore st1 = new DepartmentStore("store", 200);
        st1.addProductFromStorage(pr1);
        st1.addProductFromStorage(pr2);
        st1.addProductFromStorage(pr3);
        st1.addProductFromStorage(pr4);
        st1.addProductFromStorage(pr5);
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(3000)
                .strategy(new DifferentTypes()).build());
        client1.createNewShoppingBag(st1);
        assertEquals(client1.getListOfShoppingBags().get(0).getListOfProductsToBuy(), toCompare); //{pr1, pr3, pr4}
        // because others products
        //types already exist in the bag
    }
}
