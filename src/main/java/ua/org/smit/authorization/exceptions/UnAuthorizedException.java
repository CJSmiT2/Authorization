package ua.org.smit.authorization.exceptions;

/**
 *
 * @author smit
 */
public class UnAuthorizedException extends RuntimeException {

    public UnAuthorizedException(String message) {
        super(message);
    }
}
