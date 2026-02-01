package pl.microblog.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import pl.microblog.dao.FollowerDao;
import pl.microblog.model.Follow;

@Transactional
public class FollowerDaoImpl implements FollowerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void follow(long followerId, long followedId) {
        Follow f = new Follow();
        f.setFollowerId(followerId);
        f.setFollowedId(followedId);
        entityManager.persist(f);
    }

    @Override
    public void unfollow(long followerId, long followedId) {
        TypedQuery<Follow> q = entityManager.createQuery(
                "SELECT f FROM Follow f WHERE f.followerId = :fid AND f.followedId = :foid",
                Follow.class);
        q.setParameter("fid", followerId);
        q.setParameter("foid", followedId);

        for (Follow f : q.getResultList()) {
            entityManager.remove(f);
        }
    }

    @Override
    public boolean isFollowing(long followerId, long followedId) {
        TypedQuery<Long> q = entityManager.createQuery(
                "SELECT COUNT(f) FROM Follow f WHERE f.followerId = :fid AND f.followedId = :foid",
                Long.class);
        q.setParameter("fid", followerId);
        q.setParameter("foid", followedId);

        return q.getSingleResult() > 0;
    }
}
