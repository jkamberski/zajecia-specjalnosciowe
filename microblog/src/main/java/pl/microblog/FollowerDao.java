package pl.atins.microblog.dao;

public interface FollowerDao {
    void follow(long followerId, long followedId);
    void unfollow(long followerId, long followedId);
    boolean isFollowing(long followerId, long followedId);
}