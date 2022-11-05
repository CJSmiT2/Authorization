package ua.org.smit.authorization;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.org.smit.authorization.dao.Dao;
import ua.org.smit.authorization.dao.HibernateUtil;

public class AuthUserTest {
    
    @BeforeAll
    public static void initHibernate() {
        HibernateUtil.buildSessionFactory();
    }
    
    @Test
    public void foundBySession(){
        Authorization auth = new AuthorizationImpl(HibernateUtil.getSessionFactory());
        
        String sessionId = "9D14E0634FEFFACCC4009788FC263E89";
        AuthUser user = new AuthUser();
        user.signIn(sessionId);
        
        assertTrue(auth.find(sessionId).isPresent());
    }
    
    @Test
    public void isUserActive(){
        Authorization auth = new AuthorizationImpl(HibernateUtil.getSessionFactory());
        Dao dao = new Dao(AuthUser.class);
        
        String sessionId = "9D14E0634FEFFACCC4009788FC263E89";
        String login = "test_login";
        String password = "test_password";
        
        AuthUser user = new AuthUser();
        user.setLogin(login);
        user.setHashedPassword(password);
        user.setAlias(2);
        dao.create(user);
        
        auth.signInUser(login, password, sessionId);
        assertTrue(auth.isUserActive(sessionId));
    }
    
    @AfterAll
    public static void closeHibernateSession() {
        HibernateUtil.close();
    }
}