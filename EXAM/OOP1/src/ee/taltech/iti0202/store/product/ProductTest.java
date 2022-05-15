package ee.taltech.iti0202.store.product;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {

    @org.junit.jupiter.api.Test
    void testProductIsInCorrect() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("  ", 800, Product.Type.FOOD);
        }, "PRODUCT CAN NOT BE CREATED, PARAMETERS ARE INCORRECT");

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("prod", -30, Product.Type.FOOD);
        }, "PRODUCT CAN NOT BE CREATED, PARAMETERS ARE INCORRECT");

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("prod", 100, null);
        }, "PRODUCT CAN NOT BE CREATED, PARAMETERS ARE INCORRECT");

        assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, 100, Product.Type.COSMETICS);
        }, "PRODUCT CAN NOT BE CREATED, PARAMETERS ARE INCORRECT");
    }

    @org.junit.jupiter.api.Test
    void productToString() {
        Product pr3 = new Product("pr3", 200, Product.Type.COSMETICS);
        String toCompare = "Product{"
                + "name='" + "pr3" + '\''
                + ", price=" + 200.0
                + ", type=" + Product.Type.COSMETICS
                + ", id=" + 0
                + '}';
        assertEquals(pr3.toString(), toCompare);
    }
}
