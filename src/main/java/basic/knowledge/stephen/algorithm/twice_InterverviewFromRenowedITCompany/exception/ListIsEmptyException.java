package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany.exception;

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
