package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.client.Client;
import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.storage.Storage;

import java.util.ArrayList;
import java.util.Optional;

public class DepartmentStore extends FoodStore {

    public DepartmentStore(String name, Integer profit) {
        super(name, profit);
    }

    @Override
    public Optional<Product> addProductFromStorage(Product product) {
        ArrayList<Product> listOfProductsInStorage = Storage.getInstance().getListOfProducts();
        if (listOfProductsInStorage.contains(product) && !listOfProducts.contains(product)) {
            listOfProducts.add(product);
            Storage.getInstance().removeSingleProduct(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }

    @Override
    public void returnProductBack(Client client, Product product) {
        if (!dataBase.containsKey(client)) {
            throw new RuntimeException("NO SUCH CLIENT IN DATABASE");
        }
        if (!dataBase.get(client).contains(product)) {
            throw new RuntimeException("CLIENT DOES NOT HAVE SUCH A PRODUCT");
        }
        if (product.getType() == Product.Type.FOOD) {
            throw new RuntimeException("FOOD CAN NOT BE RETURN");
        } else {
            profit -= product.getPrice();
            client.addMoney(product.getPrice());
            client.getProductsAndStores().get(this).remove(product);
            dataBase.get(client).remove(product);
            this.listOfProducts.add(product);
        }
    }
}
