package ee.taltech.iti0202.delivery;

public interface Strategy {
    public default Action getAction() {
        return null;
    }
}
