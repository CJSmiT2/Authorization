package ua.org.smit.authorization;

import java.sql.Timestamp;
import ua.org.smit.authorization.dao.Dao;
import ua.org.smit.authorization.exceptions.EmailNotUniqeException;
import ua.org.smit.authorization.exceptions.LoginAlreadExistException;
import ua.org.smit.authorization.exceptions.NickNameNotUniqeException;

public class RegistrationImpl implements Registration {

    private final Dao dao = new Dao(AuthUser.class);

    @Override
    public void register(RegistrationDto regInfo, String session) {

        if (dao.findByLogin(regInfo.getLogin()).isPresent()) {
            throw new LoginAlreadExistException(regInfo.getLogin() + " not uniqe!");
        }
        if (dao.findByNickName(regInfo.getNickName()).isPresent()) {
            throw new NickNameNotUniqeException(regInfo.getNickName() + " not uniqe!");
        }
        if (dao.findByEmail(regInfo.getEmail()).isPresent()) {
            throw new EmailNotUniqeException(regInfo.getEmail() + " not uniqe!");
        }
        if (regInfo.getLogin().length() > 20) {
            throw new IllegalArgumentException("Login to long!");
        }
        if (regInfo.getNickName().length() > 20) {
            throw new IllegalArgumentException("LickName to long!");
        }

        AuthUser user = new AuthUser();
        user.setLogin(regInfo.getLogin());
        user.setNickName(regInfo.getNickName());
        user.setHashedPassword(regInfo.getPassword());
        user.setEmail(regInfo.getEmail());
        user.setRegistration(new Timestamp(System.currentTimeMillis()));
        user.setType(Type.MEMBER);
        user.createAlias();
        dao.create(user);
    }

}
