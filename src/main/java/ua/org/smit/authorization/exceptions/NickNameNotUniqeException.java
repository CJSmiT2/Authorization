package ua.org.smit.authorization.exceptions;

/**
 *
 * @author smit
 */
public class NickNameNotUniqeException extends RuntimeException {

    public NickNameNotUniqeException(String message) {
        super(message);
    }

}
