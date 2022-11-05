package ua.org.smit.authorization;

/**
 *
 * @author smit
 */
public class RegistrationDto {

    private final String login;
    private final String nickName;
    private final String password;
    private final String email;

    public RegistrationDto(String login, String nickName, String password, String email) {
        this.login = login;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "RegistrationInfo{" + "login=" + login + ", nickName=" + nickName + ", password=" + password + ", email=" + email + '}';
    }

}
