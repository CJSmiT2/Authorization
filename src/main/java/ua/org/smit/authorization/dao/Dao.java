package ua.org.smit.authorization.dao;

import java.util.List;
import java.util.Optional;
import org.hibernate.query.Query;
import ua.org.smit.authorization.AuthUser;

public class Dao extends AbstractHibernateDAO< AuthUser> {

    public Dao(Class<AuthUser> aClass) {
        setClazz(aClass);
    }

    public Optional<AuthUser> findBySessionId(String sessionId) {
        Optional<AuthUser> result = Optional.empty();
        this.openCurrentSession();
        String hql = "select E from " + clazz.getName() + " E LEFT JOIN E.sessions A WHERE A.session = :sessionId";
        Query query = currentSession.createQuery(hql);
        query.setParameter("sessionId", sessionId);
        query.setMaxResults(1);
        List<AuthUser> items = query.getResultList();

        if (!query.getResultList().isEmpty()) {
            AuthUser entity = (AuthUser) query.getSingleResult();
            result = Optional.ofNullable(entity);
        }

        this.closeCurrentSession();
        return result;
    }

    public Optional<AuthUser> findByLogin(String login) {
        Optional<AuthUser> result = Optional.empty();

        this.openCurrentSession();
        String hql = "from " + clazz.getName() + " E where E.login = :login";
        Query query = currentSession.createQuery(hql);
        query.setParameter("login", login);
        query.setMaxResults(1);

        if (!query.getResultList().isEmpty()) {
            AuthUser entity = (AuthUser) query.getSingleResult();
            result = Optional.ofNullable(entity);
        }

        this.closeCurrentSession();

        return result;
    }

    public Optional<AuthUser> findByNickName(String nickName) {
        Optional<AuthUser> result = Optional.empty();

        this.openCurrentSession();
        String hql = "from " + clazz.getName() + " E where E.nickName = :nickName";
        Query query = currentSession.createQuery(hql);
        query.setParameter("nickName", nickName);
        query.setMaxResults(1);

        if (!query.getResultList().isEmpty()) {
            AuthUser entity = (AuthUser) query.getSingleResult();
            result = Optional.ofNullable(entity);
        }

        this.closeCurrentSession();

        return result;
    }

    public Optional<AuthUser> findByEmail(String email) {
        Optional<AuthUser> result = Optional.empty();

        this.openCurrentSession();
        String hql = "from " + clazz.getName() + " E where E.email = :email";
        Query query = currentSession.createQuery(hql);
        query.setParameter("email", email);
        query.setMaxResults(1);

        if (!query.getResultList().isEmpty()) {
            AuthUser entity = (AuthUser) query.getSingleResult();
            result = Optional.ofNullable(entity);
        }

        this.closeCurrentSession();

        return result;
    }

}
