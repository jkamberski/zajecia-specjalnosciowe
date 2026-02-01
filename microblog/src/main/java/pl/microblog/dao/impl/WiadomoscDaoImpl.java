package pl.microblog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import pl.microblog.dao.WiadomoscDao;
import pl.microblog.model.Post;

@Transactional
public class WiadomoscDaoImpl implements WiadomoscDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> getUserTimeline(long userId) {
        TypedQuery<Post> q = entityManager.createQuery(
                "SELECT p FROM Post p WHERE p.userId = :uid ORDER BY p.createdAt DESC",
                Post.class);
        q.setParameter("uid", userId);
        return q.getResultList();
    }

    @Override
    public List<Post> getFullTimeline(long userId) {
        TypedQuery<Post> q = entityManager.createQuery(
                "SELECT p FROM Post p " +
                "WHERE p.userId = :uid " +
                "OR p.userId IN (SELECT f.followedId FROM Follow f WHERE f.followerId = :uid) " +
                "ORDER BY p.createdAt DESC",
                Post.class);
        q.setParameter("uid", userId);
        return q.getResultList();
    }

    @Override
    public List<Post> getPublicTimeline() {
        return entityManager.createQuery(
                "SELECT p FROM Post p ORDER BY p.createdAt DESC",
                Post.class).getResultList();
    }

    @Override
    public void addMessage(Post post) {
        entityManager.persist(post);
    }
}
