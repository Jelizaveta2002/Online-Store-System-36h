package ee.taltech.iti0202.computerstore.database;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.util.*;

public class Database {
    private final Map<Integer, Component> components = new HashMap<>();
    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void saveComponent(Component component) throws ProductAlreadyExistsException {
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
    }

    public void increaseComponentStock(int id, int amount) throws ProductNotFoundException {
    }

    public void decreaseComponentStock(int id, int amount) throws OutOfStockException, ProductNotFoundException {
    }

    public Map<Integer, Component> getComponents() {
        return null;
    }

    public void resetEntireDatabase() {
    }

    public void saveToFile(String location) {
    }

    public void loadFromFile(String location) {
    }
}