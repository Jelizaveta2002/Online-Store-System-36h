package ee.taltech.iti0202.computerstore.database;
import com.google.gson.Gson;
import ee.taltech.iti0202.computerstore.components.Component;
import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
import ee.taltech.iti0202.computerstore.exceptions.ProductAlreadyExistsException;
import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class Database {
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
        if (components.containsKey(component.getId())) {
            throw new ProductAlreadyExistsException();
        }
        else {
            component.setDatabase(this);
            components.put(component.getId(), component);
        }
    }

    public void deleteComponent(int id) throws ProductNotFoundException {
        if (components.containsKey(id)) {
            components.remove(id);
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public void increaseComponentStock(int id, int amount) throws ProductNotFoundException {
        if (components.containsKey(id)) {
            Component component = components.get(id);
            if (amount <= 0) {
                throw new IllegalArgumentException();
            }
            else {
                component.increase(amount); //setAmount
            }
        }
        else {
            throw new ProductNotFoundException();
        }

    }

    public void decreaseComponentStock(int id, int amount) throws OutOfStockException, ProductNotFoundException {
        if (components.containsKey(id)) {
            Component component = components.get(id);
            if (amount <= 0) {
                throw new IllegalArgumentException();
            }
            if (amount > component.getAmount()) {
                throw new OutOfStockException();
            }
            else {
                component.decrease(amount); //setAmount
            }
        }
        else {
            throw new ProductNotFoundException();
        }
    }

    public Map<Integer, Component> getComponents() {
        return this.components;
    }

    public void resetEntireDatabase() {
        this.components.clear();
    }

    public void saveToFile(String location) {
//        Gson gson = new Gson();
//
//        String json = gson.toJson(components);
//        try {
//            FileWriter fWriter = new FileWriter(location);
//            fWriter.write(json);
//            fWriter.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void loadFromFile(String location) {
    }
}