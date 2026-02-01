package pl.atins.microblog.dao;

import pl.atins.microblog.model.Uzytkownik;

public interface UzytkownikDao {
    Uzytkownik findByLogin(String login);
    void registerUser(Uzytkownik user);
}
