package ee.taltech.iti0202.store.exceptions;

public class AdultOnlyProduct extends Exception{
    public AdultOnlyProduct(String errorMessage) {
        super(errorMessage);
    }
}
