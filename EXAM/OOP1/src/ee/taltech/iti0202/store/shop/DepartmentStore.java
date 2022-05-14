package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.storage.Storage;

import java.util.ArrayList;
import java.util.Optional;

public class DepartmentStore extends FoodStore{

    public DepartmentStore(String name, Integer profit) {
        super(name, profit);
    }

    @Override
    public Optional<Product> addSingleProduct(Product product) {
        ArrayList<Product> listOfProductsInStorage = Storage.getInstance().getListOfProducts();
        if (listOfProductsInStorage.contains(product) && !listOfProducts.contains(product)) {
            listOfProducts.add(product);
            Storage.getInstance().removeSingleProduct(product);
            return Optional.of(product);
        }
        return Optional.empty();
    }
}
