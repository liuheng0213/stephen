package basic.knowledge.stephen.algorithm_4_Edition.ch1.exception;

public class ListIsEmptyException extends  RuntimeException{
    public ListIsEmptyException() {
        super();
    }

    public ListIsEmptyException(String message) {
        super(message);
    }

    public ListIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
