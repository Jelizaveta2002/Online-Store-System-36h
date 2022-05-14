package ee.taltech.iti0202.store.product;

import java.util.Collections;
import java.util.Objects;

public class Product {

    private static int idCounter = 0;
    private String name;
    private double price;
    private Type type;
    private Integer id;
    private Integer bonusAmount;
    private Integer bonusPrice;
    boolean isBought = false;
    boolean inBasket = false;
    public enum Type {
        FOOD, COSMETICS, FORHOME, ELECTRONICS, ALCOHOL, BABYGOODS
    }

    public Product(String name, double price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.id = idCounter;
        this.bonusAmount = Math.toIntExact(Math.round(price) / 25);
        if (bonusAmount == 0) {
            bonusAmount = 1;
        }
        this.bonusPrice = Math.toIntExact(20 * Math.round(price));
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

    public Integer getBonusAmount() {
        return bonusAmount;
    }

    public Integer getBonusPrice() {
        return bonusPrice;
    }

    public Type getType() {
        return type;
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
