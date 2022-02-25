package ee.taltech.iti0202.tk2.shop;

public class Product {
    private String name;
    private Integer price;
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name) {
        this.name = name;
        this.price = null;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String toString() {
        return null;
    }
}
