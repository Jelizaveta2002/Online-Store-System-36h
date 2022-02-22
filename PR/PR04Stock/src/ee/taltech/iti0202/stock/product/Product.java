package ee.taltech.iti0202.stock.product;
import ee.taltech.iti0202.stock.exceptions.StockException;

public class Product {

    private String name;
    private int price;
    /**
     * Create a new product with the given name and price.
     * <p>
     * If the price is negative, throw a StockException with a NEGATIVE_PRICE reason.
     *
     * @param name Name of the product.
     * @param price Price of the product.
     * @throws StockException NEGATIVE_PRICE
     */
    public Product(String name, int price) throws StockException {
        if (price >=0) {
            this.name = name;
            this.price = price;
        }
        else {
            throw new StockException(StockException.Reason.NEGATIVE_PRICE);
        }
    }

    /**
     * Returns the next id.
     *
     * This value has to increment with every call.
     *
     * @return The next id.
     */
    public static int getNextId() {
        return 0;
    }

    /**
     * Returns id of the product.
     *
     * @return id of the product.
     */
    public int getId() {
        return 0;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product.
     */
    public String getName() {
        return null;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product.
     */
    public int getPrice() {
        return 0;
    }
}