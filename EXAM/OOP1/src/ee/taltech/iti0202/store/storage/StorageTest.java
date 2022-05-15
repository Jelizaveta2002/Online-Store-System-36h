package ee.taltech.iti0202.store.storage;

import ee.taltech.iti0202.store.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class StorageTest {

    @Test
    void testStorageAddTheSameProduct() {
        Product pr1 = new Product("pr1", 800, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        assertThrows(IllegalArgumentException.class, () -> {
            Storage.getInstance().addProduct(pr1);   //ERROR BECAUSE THE SAME PRODUCT EXIST IN STORAGE
        }, "\"PRODUCT IS ALREADY IN STORAGE\"");
        Storage.getInstance().addProduct(pr2);
        assertEquals(2, Storage.getInstance().getListOfProducts().size()); //SECOND PRODUCT SUCCESSFULLY ADDED
    }

    @Test
    void removeProductThatIsNotInStorage() {
        Product pr1 = new Product("pr1", 800, Product.Type.FOOD);
        Product pr2 = new Product("pr1", 500, Product.Type.FOOD);
        Storage.getInstance().addProduct(pr1);
        assertThrows(IllegalArgumentException.class, () -> {
            Storage.getInstance().removeSingleProduct(pr2);   //ERROR BECAUSE PRODUCT IS OUT OD STORAGE
        }, "PRODUCT IS NOT IN THE STORAGE");
    }
}
