package exceptions;

/**
 * Negatif tutar hatası – CHECKED exception.
 */
public class NegativeAmountException extends Exception {

    public NegativeAmountException(String message) {
        super(message);
    }

    public NegativeAmountException(String message, Throwable cause) {
        super(message, cause);
    }
}
