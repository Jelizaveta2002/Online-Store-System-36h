//package ee.taltech.iti0202.coffee.machine;
//
//import java.util.logging.Logger;
//
//public class Builder {
//    private final static Logger LOGGER = Logger.getLogger(Builder.class.getName());
//    private String name;
//    private Integer capacityOfRubbishBin ;
//    private Integer capacityOfRubbishBinConstant;
//
//
//    public Builder name(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Builder capacityOfRubbishBin(Integer capacityOfRubbishBin) {
//        this.capacityOfRubbishBin = capacityOfRubbishBin;
//        this.capacityOfRubbishBinConstant = capacityOfRubbishBin;
//        return this;
//    }
//
//    public CoffeeMachine createCoffeeMachine() {
//        LOGGER.info("Creating CoffeeMachine.");
//        return new CoffeeMachine(this);
//    }
//
//}
