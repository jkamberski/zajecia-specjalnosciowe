package pl.atins.microblog.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import pl.atins.microblog.dao.FollowerDao;
import pl.atins.microblog.model.Follower;

@Transactional
public class FollowerDaoImpl implements FollowerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void follow(long followerId, long followedId) {
        Follower f = new Follower();
        f.setFollowerId(followerId);
        f.setFollowedId(followedId);
        entityManager.persist(f);
    }

    @Override
    public void unfollow(long followerId, long followedId) {
        TypedQuery<Follower> q = entityManager.createQuery(
                "SELECT f FROM Follower f WHERE f.followerId = :fid AND f.followedId = :foid",
                Follower.class);
        q.setParameter("fid", followerId);
        q.setParameter("foid", followedId);

        for (Follower f : q.getResultList()) {
            entityManager.remove(f);
        }
    }

    @Override
    public boolean isFollowing(long followerId, long followedId) {
        TypedQuery<Long> q = entityManager.createQuery(
                "SELECT COUNT(f) FROM Follower f WHERE f.followerId = :fid AND f.followedId = :foid",
                Long.class);
        q.setParameter("fid", followerId);
        q.setParameter("foid", followedId);

        return q.getSingleResult() > 0;
    }
}
