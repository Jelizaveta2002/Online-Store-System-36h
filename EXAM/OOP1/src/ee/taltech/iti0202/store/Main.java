package ee.taltech.iti0202.store;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.DepartmentStore;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.CheapestProduct;
import ee.taltech.iti0202.store.startegy.DifferentTypes;
import ee.taltech.iti0202.store.startegy.Strategy;
import ee.taltech.iti0202.store.storage.Storage;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //create products
        Product pr1 = new Product("pr1", 800, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 200, Product.Type.COSMETICS);
        try {
            Product pr4 = new Product("  ", 800, Product.Type.FOOD); //incorrect product, name contains of
            //whitespaces
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //create list of products to add to bag
        ArrayList<Product> listToAddToStore = new ArrayList<>();
        listToAddToStore.add(pr1);
        listToAddToStore.add(pr2);

        //create shop
        FoodStore st1 = new FoodStore("store", 200);
        DepartmentStore st2 = new DepartmentStore("store2", 100);

        //fill storage with products
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);

        //add products to stores
        st1.addProductsFromStorage(listToAddToStore); //several products
        st2.addProductFromStorage(pr3); //single product
        st2.addProductFromStorage(pr1); // product is already added to st1
        System.out.println(st2.getListOfProducts()); //size of list is 1

        //create strategy
        CheapestProduct strategy1 = new CheapestProduct();
        DifferentTypes strategy2 = new DifferentTypes();

        //create new clients
        Client client1 = (new Client.ClientBuilder("anna").age(19).money(1000).strategy(strategy1).build());
        Client client3 = (new Client.ClientBuilder("lora").age(39).money(700).strategy(strategy2).build());
        try {
            Client client2 = (new Client.ClientBuilder("bob").age(10).money(500).strategy(strategy1).build());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //age is under 18, so error
        }

        //client create new shopping bag with products, according to strategy
        client1.createNewShoppingBag(st1);
        System.out.println(client1.getListOfShoppingBags().get(0).getListOfProductsToBuy()); //only one product is -
        // -added to bag, cause name and type of 2 products are the same (the one with lowest price)
        client3.createNewShoppingBag(st2);
        System.out.println(client3.getListOfShoppingBags().get(0).getListOfProductsToBuy());
        System.out.println(st1.getListOfProducts().size()); // 1 is still in shop
        System.out.println(st2.getListOfProducts().size()); // shop is rid of products, so 0

        // buy orders
        client1.buyProductsFromBag(st1, false);
        System.out.println(client1.showProducts());
        System.out.println(client1.getMoney()); // 500 (100 - 500)
        System.out.println(st1.getProfit()); // 700 (200 + 500)
        try {
            client3.buyProductsFromBag(st1, true); //no bag in this store, so error
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        client3.buyProductsFromBag(st2, true);
        System.out.println(client3.showProducts());
        System.out.println(client3.getMoney()); // 500 (700 - 200) (do not use points cause do not have them yet)
        System.out.println(st2.getProfit()); // 300 (100 + 200)


        //client return the product
        st2.returnProductBack(client3, pr3);
        System.out.println(st2.getProfit()); //100
        System.out.println(client3.getMoney()); //700
        System.out.println(st2.getListOfProducts());
        System.out.println(client3.showProducts()); //no products after refund
        try {
            st2.returnProductBack(client1, pr1); // no such client in database of the store
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        client1.createNewShoppingBag(st2); //create bag from another shop
        client1.buyProductsFromBag(st2, false); //buy this bag

        // the data of all the members in system
        System.out.println(st1.showClients());
        System.out.println(st2.showClients());
        System.out.println(client1.showProducts()); //2 product from 2 different stores
        System.out.println(client3.showProducts()); // no products from store2
        System.out.println(st2.getListOfClients()); //2 clients
        System.out.println(st2.getDataBase()); //no products client3 and 1 product was bought for client1
    }
}
