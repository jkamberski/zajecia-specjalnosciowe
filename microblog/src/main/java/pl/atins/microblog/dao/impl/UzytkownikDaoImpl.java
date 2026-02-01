package pl.atins.microblog.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.atins.microblog.dao.UzytkownikDao;
import pl.atins.microblog.model.Uzytkownik;

@Repository
@Transactional
public class UzytkownikDaoImpl implements UzytkownikDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Uzytkownik findByLogin(String login) {
        TypedQuery<Uzytkownik> q = entityManager.createQuery(
                "SELECT u FROM Uzytkownik u WHERE u.username = :login", Uzytkownik.class);
        q.setParameter("login", login);

        return q.getResultList().isEmpty() ? null : q.getResultList().get(0);
    }

    @Override
    public void registerUser(Uzytkownik user) {
        entityManager.persist(user);
    }
}
