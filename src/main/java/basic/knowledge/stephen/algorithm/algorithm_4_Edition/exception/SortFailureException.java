package basic.knowledge.stephen.algorithm.algorithm_4_Edition.exception;

public class SortFailureException extends RuntimeException {
    public SortFailureException() {
        super();
    }

    public SortFailureException(String message) {
        super(message);
    }

    public SortFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
