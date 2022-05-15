package ee.taltech.iti0202.store.product;

import java.util.Collections;
import java.util.Objects;

public class Product {

    private static int idCounter = 0;
    private String name;
    private double price;
    private Type type;
    private Integer id;
    public enum Type {
        FOOD, COSMETICS, FORHOME, ELECTRONICS, GARDENGOODS, BABYGOODS
    }

    public Product(String name, double price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.id = idCounter;
        idCounter ++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
