package pl.atins.microblog.service;

import java.util.List;
import pl.atins.microblog.model.Uzytkownik;
import pl.atins.microblog.model.Wpis;

public interface MicroblogService {

    // Użytkownicy
    Uzytkownik registerUser(String login);
    Uzytkownik findUserByLogin(String login);

    // Follow
    void follow(long followerId, long followedId);
    void unfollow(long followerId, long followedId);
    boolean isFollowing(long followerId, long followedId);

    // Wpisy
    void addMessage(Wpis post);

    List<Wpis> getUserTimeline(long userId);
    List<Wpis> getFullTimeline(long userId);
    List<Wpis> getPublicTimeline();
}
