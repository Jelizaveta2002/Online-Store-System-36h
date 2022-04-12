package ee.taltech.iti0202.delivery;

public interface Strategy {
    public default ee.taltech.iti0202.delivery.Action getAction() {
        return null;
    }
}