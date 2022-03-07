package ee.taltech.iti0202.files.input;

public class FileReaderException extends RuntimeException {
    private Throwable cause;
    private String message;

    public FileReaderException(Throwable cause, String message) {
        this.cause = cause;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }
}
