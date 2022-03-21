package ee.taltech.iti0202.coffee.machine;

public class AutomaticMachine extends CoffeeMachine {
    private Integer millilitersOfMilk;
    private Integer gramsOfCacaoBeans;
    public AutomaticMachine(CoffeeMachineBuilder builder) {
        super(builder);
        this.capacityOfRubbishBin = 10;
    }

    public Integer getMilk() {
        return this.millilitersOfMilk;
    }

    public Integer getCacaoBeans() {
        return this.gramsOfCacaoBeans;
    }
}
