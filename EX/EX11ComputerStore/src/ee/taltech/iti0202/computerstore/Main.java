package ee.taltech.iti0202.computerstore;

import com.google.gson.Gson;
import ee.taltech.iti0202.computerstore.components.Component;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Component comp = new Component("name", Component.Type.CPU, new BigDecimal(13342423.4324),"cpu", 3, 6);
        Gson gson = new Gson();

        String json = gson.toJson(comp);
        System.out.println(json);

    }
}
