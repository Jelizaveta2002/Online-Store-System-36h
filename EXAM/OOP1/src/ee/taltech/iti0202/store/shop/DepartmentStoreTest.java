package ee.taltech.iti0202.store.shop;

import ee.taltech.iti0202.store.product.Product;
import ee.taltech.iti0202.store.storage.Storage;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentStoreTest {

    @Test
    void testFindProductByParameter() {
        Product pr1 = new Product("pr1", 400, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.COSMETICS);
        Product pr3 = new Product("pr3", 500, Product.Type.GARDENGOODS);
        Product pr4 = new Product("pr3", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        Storage.getInstance().addProduct(pr2);
        Storage.getInstance().addProduct(pr3);
        Storage.getInstance().addProduct(pr4);
        DepartmentStore st1 = new DepartmentStore("store", 200);
        ArrayList<Product> toAdd = new ArrayList<>();
        toAdd.add(pr1);
        toAdd.add(pr2);
        toAdd.add(pr3);
        toAdd.add(pr4);
        ArrayList<Product> toCompare = new ArrayList<>();
        toCompare.add(pr2);
        toCompare.add(pr3);
        toCompare.add(pr4);
        st1.addProductsFromStorage(toAdd);
        assertEquals(st1.findProductByPrice(500), Optional.of(toCompare)); //FIND BY PRICE (3 products with price 500)
        toCompare.clear();
        toCompare.add(pr3);
        toCompare.add(pr4);
        assertEquals(st1.findProductByName("pr3"), Optional.of(toCompare)); //ONLY WITH NAME pr3 (2 in total)
        assertEquals(st1.findProductById(1), Optional.of(pr2)); //FIND FIRST PRODUCT
    }
}
