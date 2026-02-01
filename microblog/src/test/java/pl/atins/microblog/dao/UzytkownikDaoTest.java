package pl.atins.microblog.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.atins.microblog.model.Uzytkownik;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@Transactional
public class UzytkownikDaoTest {

    @Autowired
    private UzytkownikDao uzytkownikDao;

    @Test
    public void shouldRegisterAndFindUserByLogin() {
        Uzytkownik u = new Uzytkownik();
        u.setUsername("jan");   // jeśli u Ciebie pole nazywa się inaczej, patrz uwaga niżej

        uzytkownikDao.registerUser(u);

        Uzytkownik found = uzytkownikDao.findByLogin("jan");
        Assert.assertNotNull(found);
        Assert.assertEquals("jan", found.getUsername());
    }

    @Test
    public void shouldReturnNullWhenUserNotFound() {
        Uzytkownik found = uzytkownikDao.findByLogin("nie-istnieje");
        Assert.assertNull(found);
    }
}
