package parser;

public class NoSuchFileException extends RuntimeException {

    public NoSuchFileException() {
        super();
    }

    public NoSuchFileException(String message) {
        super(message);
    }

    public NoSuchFileException(String message, Throwable t) {
        super(message, t);
    }
}
