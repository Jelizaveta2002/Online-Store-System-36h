package ee.taltech.iti0202.mysticorbs.exceptions;

import ee.taltech.iti0202.mysticorbs.oven.Oven;

public class CannotFixException extends Throwable {

    public enum Reason {
        IS_NOT_BROKEN,
        FIXED_MAXIMUM_TIMES,
        NOT_ENOUGH_RESOURCES
    }
    private final Oven oven;
    private Reason reason;
    public CannotFixException(Oven oven, Reason reason) {
        this.oven = oven;
        this.reason = reason;
    }

    public Oven getOven() {
        return null;
    }

    public Reason getReason() {
        return null;
    }
}
