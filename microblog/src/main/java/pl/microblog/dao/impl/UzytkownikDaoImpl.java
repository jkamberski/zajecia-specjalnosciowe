package pl.microblog.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import pl.microblog.dao.UzytkownikDao;
import pl.microblog.model.User;

@Transactional
public class UzytkownikDaoImpl implements UzytkownikDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findByLogin(String login) {
        TypedQuery<User> q = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.username = :login", User.class);
        q.setParameter("login", login);

        return q.getResultList().isEmpty() ? null : q.getResultList().get(0);
    }

    @Override
    public void registerUser(User user) {
        entityManager.persist(user);
    }
}
