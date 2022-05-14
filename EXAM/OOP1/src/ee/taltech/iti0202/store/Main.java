package ee.taltech.iti0202.store;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.shop.FoodStore;
import ee.taltech.iti0202.store.startegy.CheapestProduct;
import ee.taltech.iti0202.store.startegy.Strategy;
import ee.taltech.iti0202.store.storage.Storage;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("anna", 19, 200567);
        Strategy strat1 = new CheapestProduct();
        client1.setStrategy(strat1);
        FoodStore st1 = new FoodStore("store", 234);
        Product pr1 = new Product("pr1", 5789, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 78890, Product.Type.FOOD);
        Product pr3 = new Product("pr3", 8, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        //Storage.getInstance().addProduct(pr3);
        st1.addSingleProduct(pr1);
        st1.addSingleProduct(pr2);
        System.out.println(st1.getListOfProducts());
        //st1.addSingleProduct(pr3);
        System.out.println(Storage.getInstance().getListOfProducts());
        System.out.println(client1.createNewShoppingBag(st1).get().getListOfProductsToBuy().get(0).getName());
        System.out.println(client1.createNewShoppingBag(st1));
        System.out.println(client1.getListOfShoppingBags());
        System.out.println(st1.getListOfProducts());
        client1.buyProductsFromBag(st1, false);
        System.out.println(client1.getMoney());
        System.out.println(client1.getListOfShoppingBags());
        System.out.println(st1.getProfit());
        System.out.println(client1.getProductsAndStores());
        System.out.println(st1.getDataBase());
        System.out.println(st1.getListOfProducts());
        System.out.println(client1.getStoreAndBonus());
        st1.addSingleProduct(pr2);
        System.out.println(client1.createNewShoppingBag(st1));
        client1.buyProductsFromBag(st1, true);
        System.out.println(client1.getMoney());
        System.out.println(client1.getStoreAndBonus());

    }
}
