//package ee.taltech.iti0202.computerstore;
//
//import com.google.gson.Gson;
//import ee.taltech.iti0202.computerstore.components.Component;
//import ee.taltech.iti0202.computerstore.database.Database;
//import ee.taltech.iti0202.computerstore.exceptions.NotEnoughMoneyException;
//import ee.taltech.iti0202.computerstore.exceptions.OutOfStockException;
//import ee.taltech.iti0202.computerstore.exceptions.ProductNotFoundException;
//import ee.taltech.iti0202.computerstore.store.Store;
//
//import java.math.BigDecimal;
//
//public class Main {
//    public static void main(String[] args) throws OutOfStockException, NotEnoughMoneyException, ProductNotFoundException {
//        Database database = Database.getInstance();
//        Component comp = new Component("name", Component.Type.CPU, new BigDecimal(100.123),"cpu", 3, 6);
//        Store store = new Store("store", new BigDecimal(200000.123), new BigDecimal(50.123));
//        Customer customer = new Customer("liza", new BigDecimal(150.124));
//        store.purchaseComponent(0, customer)
//    }
//}
