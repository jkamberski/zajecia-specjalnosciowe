package pl.atins.microblog.dao.impl;


import org.springframework.stereotype.Repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import pl.atins.microblog.dao.WiadomoscDao;
import pl.atins.microblog.model.Wpis;

@Repository
@Transactional
public class WiadomoscDaoImpl implements WiadomoscDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Wpis> getUserTimeline(long userId) {
        TypedQuery<Wpis> q = entityManager.createQuery(
                "SELECT p FROM Wpis p WHERE p.userId = :uid ORDER BY p.createdAt DESC",
                Wpis.class);
        q.setParameter("uid", userId);
        return q.getResultList();
    }

    @Override
    public List<Wpis> getFullTimeline(long userId) {
        TypedQuery<Wpis> q = entityManager.createQuery(
                "SELECT p FROM Wpis p " +
                "WHERE p.userId = :uid " +
                "OR p.userId IN (SELECT f.followedId FROM Follower f WHERE f.followerId = :uid) " +
                "ORDER BY p.createdAt DESC",
                Wpis.class);
        q.setParameter("uid", userId);
        return q.getResultList();
    }

    @Override
    public List<Wpis> getPublicTimeline() {
        return entityManager.createQuery(
                "SELECT p FROM Wpis p ORDER BY p.createdAt DESC",
                Wpis.class).getResultList();
    }

    @Override
    public void addMessage(Wpis post) {
        entityManager.persist(post);
    }
}
