package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany.exception;

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
