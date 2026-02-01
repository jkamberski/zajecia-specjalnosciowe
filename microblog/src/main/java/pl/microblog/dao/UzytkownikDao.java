package pl.atins.microblog.dao;

import pl.atins.microblog.model.User;

public interface UzytkownikDao {
    User findByLogin(String login);
    void registerUser(User user);
}
