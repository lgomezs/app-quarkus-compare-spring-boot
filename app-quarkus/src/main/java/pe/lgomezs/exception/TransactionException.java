package pe.lgomezs.exception;

public class TransactionException extends RuntimeException {

    public TransactionException(String message, Throwable throwable) {
        super(message,throwable);
    }

    public TransactionException(String message) {
        super(message);
    }
}
