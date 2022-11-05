package ua.org.smit.authorization.exceptions;

/**
 *
 * @author smit
 */
public class LoginNotExistException extends RuntimeException {

    public LoginNotExistException(String message) {
        super(message);
    }

}
