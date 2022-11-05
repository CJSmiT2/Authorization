package ua.org.smit.authorization.exceptions;

/**
 *
 * @author smit
 */
public class NotHasPermissionException extends RuntimeException {

    public NotHasPermissionException(String message) {
        super(message);
    }

}
