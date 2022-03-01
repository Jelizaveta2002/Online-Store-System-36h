package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;

public interface Fixable {

    /**
     * Create a resourceStorage.
     */
    void fix() throws CannotFixException;

    /**
     * Create a resourceStorage.
     */
    int getTimesFixed();
}
