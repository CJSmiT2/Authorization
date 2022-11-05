package ua.org.smit.authorization.exceptions;

/**
 *
 * @author smit
 */
public class EmailNotUniqeException extends RuntimeException {

    public EmailNotUniqeException(String message) {
        super(message);
    }

}
