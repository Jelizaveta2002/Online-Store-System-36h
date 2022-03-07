package ee.taltech.iti0202.files.input;

public class FileReaderException extends RuntimeException {
    private Throwable cause;
    public String getMessage() {
        return null;
    }

    public Throwable getCause() {
        return cause;
    }
}
