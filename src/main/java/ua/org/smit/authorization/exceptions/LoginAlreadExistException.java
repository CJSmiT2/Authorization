package ua.org.smit.authorization.exceptions;

/**
 *
 * @author smit
 */
public class LoginAlreadExistException extends RuntimeException {

    public LoginAlreadExistException(String message) {
        super(message);
    }

}
