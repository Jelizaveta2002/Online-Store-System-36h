package ee.taltech.iti0202.coffee.storage;

public class Storage {
    private Integer millilitersOfMilk;
    private Integer gramsOfBeans;
    private Integer gramsOfCacao;

    public Storage(Integer millilitersOfMilk, Integer gramsOfBeans, Integer gramsOfCacao) {
        this.millilitersOfMilk = millilitersOfMilk;
        this.gramsOfBeans = gramsOfBeans;
        this.gramsOfCacao = gramsOfCacao;
    }

    public Integer getMillilitersOfMilk() {
        return this.millilitersOfMilk;
    }

    public Integer getGramsOfBeans() {
        return this.gramsOfBeans;
    }

    public Integer getGramsOfCacao() {
        return this.gramsOfCacao;
    }

    public void fillStorage(Integer millilitersOfMilk, Integer gramsOfBeans, Integer gramsOfCacao) {
        this.millilitersOfMilk += millilitersOfMilk;
        this.gramsOfBeans += gramsOfBeans;
        this.gramsOfCacao += gramsOfCacao;
    }

    public boolean getMilkFromStorage(Integer millilitersOfMilk) {
        if (this.millilitersOfMilk >= millilitersOfMilk) {
            this.millilitersOfMilk -= millilitersOfMilk;
            return true;
        }
        return false;
    }

    public boolean getBeansFromStorage(Integer gramsOfBeans) {
        if (this.gramsOfBeans >= gramsOfBeans) {
            this.gramsOfBeans -= gramsOfBeans;
            return true;
        }
        return false;
    }

    public boolean getCacaoFromStorage(Integer gramsOfCacao) {
        if (this.gramsOfCacao >= gramsOfCacao) {
            this.gramsOfCacao -= gramsOfCacao;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.gramsOfCacao == 0 && this.gramsOfBeans == 0 && this.millilitersOfMilk == 0;
    }

    public String getStateOfStorage() {
        return "Milliliters of Milk: " + this.millilitersOfMilk + "\n" + "Grams of Coffee beans: "
                + this.gramsOfBeans + "\n" + "Grams of Cacao: " + this.gramsOfCacao;
    }
}
