package ee.taltech.iti0202.computerstore.store;
import ee.taltech.iti0202.computerstore.Customer;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.database.Database;
import ee.taltech.iti0202.computerstore.exceptions.NotEnoughMoneyException;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.math.BigDecimal;
import java.util.stream.Collectors;

public class Store {
    public static final int SIX = 6;
    public static final int ZERO = 0;
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
        if (!Database.getInstance().getComponents().containsKey(id)) {
            throw new ProductNotFoundException();
        }
        Component component = Database.getInstance().getComponents().get(id);
        BigDecimal finalPrice = component.getPrice().multiply(profitMargin);
        if (customer.getBalance().compareTo(finalPrice) < ZERO) {
            throw new NotEnoughMoneyException();
        } else {
            customer.addComponent(component);
            balance = balance.add(finalPrice);
            customer.decreaseBalance(finalPrice);
            Database.getInstance().decreaseComponentStock(id, 1);
            return component;
        }
    }

    public List<Component> getAvailableComponents() {
        List<Component> listOfAvailableComps = new ArrayList<>();
        for (Integer id : Database.getInstance().getComponents().keySet()) {
            Component component = Database.getInstance().getComponents().get(id);
            if (component.getAmount() > ZERO) {
                listOfAvailableComps.add(component);
            }
        }
        return listOfAvailableComps;
    }

    public List<Component> getComponentsSortedByAmount() {
        Database database = Database.getInstance();
        return new ArrayList<>(database.getComponents().values())
                .stream()
                .sorted(Comparator.comparingInt(Component::getAmount))
                .collect(Collectors.toList());
    }

    public List<Component> getComponentsSortedByName() {
        Database database = Database.getInstance();
        return new ArrayList<>(database.getComponents().values())
                .stream()
                .sorted(Comparator.comparing(Component::getName))
                .collect(Collectors.toList());
    }

    public List<Component> getComponentsSortedByPrice() {
        Database database = Database.getInstance();
        return new ArrayList<>(database.getComponents().values())
                .stream()
                .sorted(Comparator.comparing(Component::getPrice))
                .collect(Collectors.toList());
    }

    public List<Component> filterByType(Component.Type type) {
        Database database = Database.getInstance();
        List<Component> listSortedByType = new ArrayList<>();
        for (Component component : database.getComponents().values()) {
            if (component.getType().equals(type)) {
                listSortedByType.add(component);
            }
        }
        return listSortedByType;
    }

    public BigDecimal getInventoryValue() {
        BigDecimal finalNumber = new BigDecimal(ZERO);
        MathContext m = new MathContext(SIX);
        Database database = Database.getInstance();
        for (Component component : database.getComponents().values()) {
            int amount = component.getAmount();
            BigDecimal price = component.getPrice().multiply(profitMargin);
            BigDecimal finalPrice = price.multiply(new BigDecimal(amount));
            finalNumber = finalNumber.add(finalPrice);
        }
        return finalNumber.round(m);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getProfitMargin() {
        return this.profitMargin;
    }

    public void setProfitMargin(BigDecimal profitMargin) {
        if (Math.rint(profitMargin.doubleValue()) < 1) {
            throw new IllegalArgumentException();
        } else {
            this.profitMargin = profitMargin;
        }
    }
}
