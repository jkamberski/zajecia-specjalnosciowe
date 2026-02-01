package pl.atins.microblog.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.atins.microblog.model.Uzytkownik;
import pl.atins.microblog.model.Wpis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@Transactional
public class MicroblogServiceTest {

    @Autowired
    private MicroblogService service;

    @Test
    public void registerUser_andFindUserByLogin() {
        Uzytkownik u1 = service.registerUser("ala");
        assertNotNull(u1);
        assertNotNull(u1.getId());

        Uzytkownik u2 = service.findUserByLogin("ala");
        assertNotNull(u2);
        assertEquals(u1.getId(), u2.getId());
    }

    @Test
    public void follow_unfollow_isFollowing() {
        Uzytkownik a = service.registerUser("a");
        Uzytkownik b = service.registerUser("b");

        assertFalse(service.isFollowing(a.getId(), b.getId()));
        service.follow(a.getId(), b.getId());
        assertTrue(service.isFollowing(a.getId(), b.getId()));
        service.unfollow(a.getId(), b.getId());
        assertFalse(service.isFollowing(a.getId(), b.getId()));
    }

    @Test
    public void timelines_shouldNotBeNull() {
        Uzytkownik u = service.registerUser("autor");

        List<Wpis> userTl = service.getUserTimeline(u.getId());
        assertNotNull(userTl);

        List<Wpis> fullTl = service.getFullTimeline(u.getId());
        assertNotNull(fullTl);

        List<Wpis> publicTl = service.getPublicTimeline();
        assertNotNull(publicTl);
    }
}
