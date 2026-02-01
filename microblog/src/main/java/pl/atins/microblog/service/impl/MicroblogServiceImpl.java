package pl.atins.microblog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.atins.microblog.dao.FollowerDao;
import pl.atins.microblog.dao.UzytkownikDao;
import pl.atins.microblog.dao.WiadomoscDao;
import pl.atins.microblog.model.Uzytkownik;
import pl.atins.microblog.model.Wpis;
import pl.atins.microblog.service.MicroblogService;

@Service
@Transactional
public class MicroblogServiceImpl implements MicroblogService {

    @Autowired
    private UzytkownikDao uzytkownikDao;

    @Autowired
    private FollowerDao followerDao;

    @Autowired
    private WiadomoscDao wiadomoscDao;

    // ===== UŻYTKOWNICY =====

    @Override
    public Uzytkownik registerUser(String login) {
        Uzytkownik existing = uzytkownikDao.findByLogin(login);
        if (existing != null) {
            return existing;
        }

        Uzytkownik u = new Uzytkownik();
        u.setUsername(login);
        uzytkownikDao.registerUser(u);
        return u;
    }

    @Override
    public Uzytkownik findUserByLogin(String login) {
        return uzytkownikDao.findByLogin(login);
    }

    // ===== FOLLOW / UNFOLLOW =====

    @Override
    public void follow(long followerId, long followedId) {
        if (!followerDao.isFollowing(followerId, followedId)) {
            followerDao.follow(followerId, followedId);
        }
    }

    @Override
    public void unfollow(long followerId, long followedId) {
        followerDao.unfollow(followerId, followedId);
    }

    @Override
    public boolean isFollowing(long followerId, long followedId) {
        return followerDao.isFollowing(followerId, followedId);
    }

    // ===== WIADOMOŚCI =====

    @Override
    public void addMessage(Wpis post) {
        wiadomoscDao.addMessage(post);
    }

    @Override
    public List<Wpis> getUserTimeline(long userId) {
        return wiadomoscDao.getUserTimeline(userId);
    }

    @Override
    public List<Wpis> getFullTimeline(long userId) {
        return wiadomoscDao.getFullTimeline(userId);
    }

    @Override
    public List<Wpis> getPublicTimeline() {
        return wiadomoscDao.getPublicTimeline();
    }
}
