package ee.taltech.iti0202.computerstore.store;
import ee.taltech.iti0202.computerstore.Customer;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.database.Database;
import ee.taltech.iti0202.computerstore.exceptions.NotEnoughMoneyException;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.util.List;
import java.math.BigDecimal;

public class Store {
    private  String name;
    private BigDecimal balance;
    private BigDecimal profitMargin;

    public Store(String name, BigDecimal balance, BigDecimal profitMargin) {
        if (Math.rint(profitMargin.doubleValue()) < 1) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.balance = balance;
        this.profitMargin = profitMargin;
    }

    public Component purchaseComponent(int id, Customer customer) throws OutOfStockException,
            ProductNotFoundException,
            NotEnoughMoneyException {
        Database database = Database.getInstance();
        Component component = database.getComponents().get(id);
        BigDecimal finalPrice = component.getPrice().multiply(profitMargin);
        if (customer.getBalance().compareTo(finalPrice) < 0) {
            throw new NotEnoughMoneyException();
        } else {
            customer.addComponent(component);
            balance = balance.add(finalPrice);
            customer.decreaseBalance(finalPrice);
            database.decreaseComponentStock(id, 1);
            return component;
        }
    }

    public List<Component> getAvailableComponents() {
        return null;
    }

    public List<Component> getComponentsSortedByAmount() {
        return null;
    }

    public List<Component> getComponentsSortedByName() {
        return null;
    }

    public List<Component> getComponentsSortedByPrice() {
        return null;
    }

    public List<Component> filterByType(Component.Type type) {
        return null;
    }

    public BigDecimal getInventoryValue() {
        return BigDecimal.ZERO;
    }

    public String getName() {
        return null;
    }

    public void setName(String name) {
    }

    public BigDecimal getBalance() {
        return null;
    }

    public void setBalance(BigDecimal balance) {
    }

    public BigDecimal getProfitMargin() {
        return null;
    }

    public void setProfitMargin(BigDecimal profitMargin) {
    }
}